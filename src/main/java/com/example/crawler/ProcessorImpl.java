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

    @Autowired
    private CrawlerQueue<WebPage> queue;

    @Autowired
    private ProcessedPages<WebPage> processedPages;
    
    @Autowired
    private WebPageParser<WebPage> parser;

    @Override
    public void process(String url) {
        logger.debug("Processing {}", url);
        queue.add(new WebPage(url));
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            WebPage wp = queue.remove();
            try {
                if (wp.getTimeVisited() > 3) {
                    processedPages.add(wp);
                } else {
                    for (WebPage newPage:parser.parse(wp.getUrl())) {
                        if (!visited.contains(newPage.getUrl())) {
                            queue.add(newPage);
                            visited.add(newPage.getUrl());
                        }
                    }
                    processedPages.add(wp);
                }
            } catch (Exception e) {
                wp.setError(e.getMessage());
                wp.setVisited(true);
                wp.setTimeVisited(wp.getTimeVisited() + 1);
                queue.add(wp);
            }
        }
    }
}
