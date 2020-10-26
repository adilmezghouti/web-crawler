package com.example.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CSVReporterImpl implements Reporter {
    private static final Logger logger = LoggerFactory.getLogger(CSVReporterImpl.class);

    @Autowired
    private ProcessedPages<WebPage> processedPages;

    @Override
    public void report() {
        logger.debug("Reporting...");
    }
}
