package com.example.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        Map<String, List<String>> staticContent = new HashMap<>();
        Map<String, List<String>> erroredUrl = new HashMap<>();
        Map<String, List<String>> externalUrls = new HashMap<>();
        for (WebPage wp:processedPages.getAll()) {
            if (wp.isStaticContent()) {
                addItemToMap(wp.getSourceUrl(), wp.getUrl(), staticContent);
            } else if (wp.getError() != null) {
                addItemToMap(wp.getSourceUrl(), wp.getUrl(), erroredUrl);
            } else if (wp.isExternalUrl()) {
                addItemToMap(wp.getSourceUrl(), wp.getUrl(), externalUrls);
            }
        }

        System.out.println(staticContent);
    }
}
