package com.example.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProcessorImpl implements Processor {
    private static final Logger logger = LoggerFactory.getLogger(ProcessorImpl.class);
    private static final int RETRY_TIMES_THRESHOLD = 3; //TODO move this to the properties file

    @Autowired
    private CrawlerQueue<WebPage> queue;

    @Autowired
    private ProcessedPages<WebPage> processedPages;
    
    @Autowired
    private WebPageParser<WebPage> parser;

    @Autowired
    private Reporter reporter;

    @Override
    public void process(String url) {
        logger.debug("Processing {}", url);
        queue.add(new WebPage(url, ""));
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            WebPage wp = queue.remove();
            System.out.println(wp.getUrl());
            try {
                if (wp.getTimeVisited() > RETRY_TIMES_THRESHOLD) {
                    processedPages.add(wp);
                } else {
                    for (WebPage newPage:parser.parse(wp.getUrl())) {
                        if (!Utils.areUrlsSameDomain(url, newPage.getUrl())) {
                            newPage.setExternalUrl(true);
                            processedPages.add(newPage);
                        }else if (newPage.isStaticContent()) {
                            processedPages.add(newPage);
                        } else {
                            processedPages.add(newPage);
                            if (!visited.contains(newPage.getUrl())) {
                                queue.add(newPage);
                                visited.add(newPage.getUrl());
                            }
                        }
                    }
                    processedPages.add(wp);
                }
            } catch (Exception e) {
                logger.error("Failed to process url: {}", url);
                wp.setError(e.getMessage());
                wp.setVisited(true);
                wp.setTimeVisited(wp.getTimeVisited() + 1);
                queue.add(wp);
            }
        }

        reporter.report();
    }
}
