package com.example.crawler;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JSONReporterImpl implements Reporter {
    private static final Logger logger = LoggerFactory.getLogger(JSONReporterImpl.class);

    @Autowired
    private ProcessedPages<WebPage> processedPages;

    private void addItemToMap(final String key, final String value, Map<String, List<String>> map) {
        map.compute(key, (k,v) -> {
            if (v == null) {
                return new ArrayList<>(){{add(value);}};
            } else {
                v.add(value);
                return v;
            }
        });
    }
    @Override
    public void report() {
        logger.debug("Reporting...");
        FileWriter file = null;
        Map<String, List<String>> urlMap = new HashMap<>();
        Map<String, List<String>> staticContentMap = new HashMap<>();
        Map<String, List<String>> externalUrlsMap = new HashMap<>();
        Map<String, List<String>> erroredUrlMap = new HashMap<>();

        for (WebPage wp:processedPages.getAll()) {
            if (wp.isStaticContent()) {
                addItemToMap(wp.getSourceUrl(), wp.getUrl(), staticContentMap);
            } else if (wp.getError() != null) {
                addItemToMap(wp.getSourceUrl(), wp.getUrl(), erroredUrlMap);
            } else if (wp.isExternalUrl()) {
                addItemToMap(wp.getSourceUrl(), wp.getUrl(), externalUrlsMap);
            } else {
                addItemToMap(wp.getSourceUrl(), wp.getUrl(), urlMap);
            }
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("InternalUrls", urlMap);
        jsonObject.put("ExternalUrls", externalUrlsMap);
        jsonObject.put("StaticContent", staticContentMap);
        jsonObject.put("ErroredUrls", erroredUrlMap);

        try {
            logger.debug("Generating report");
            file = new FileWriter("report.json");
            file.write(jsonObject.toJSONString());
            logger.debug("Successfully generated the crawling report");
        } catch (IOException e) {
            logger.error("Failed to generate report: {}", e.getMessage());
        } finally {
            try {
                file.flush();
                file.close();
            } catch (Exception e) {
                logger.error("Failed to close file");
            }
        }
    }
}
