package com.example.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class WebCrawlerApplication {
    private static final Logger logger = LoggerFactory.getLogger(WebCrawlerApplication.class);

    public static void main(String[] args) {
        logger.info("Starting crawler with url: {}", Arrays.toString(args));
        SpringApplication.run(WebCrawlerApplication.class, args);
    }

}
