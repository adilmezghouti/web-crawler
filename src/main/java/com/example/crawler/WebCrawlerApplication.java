package com.example.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class WebCrawlerApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(WebCrawlerApplication.class);

    @Autowired
    private Processor processor;

    public static void main(String[] args) {
        SpringApplication.run(WebCrawlerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("Starting crawler with url: {}", Arrays.toString(args));
        if (Utils.validateUrl(args[0])) {
            processor.process(args[0]);
        } else {
            System.out.println("Please provide a valid url!");
        }
    }
}
