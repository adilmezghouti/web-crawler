package com.example.crawler;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProcessedPagesImpl implements ProcessedPages<WebPage> {
    private final List<WebPage> processedPages = new ArrayList<>();

    @Override
    public void add(WebPage item) {
        processedPages.add(item);
    }

    @Override
    public List<WebPage> getAll() {
        return processedPages;
    }
}
