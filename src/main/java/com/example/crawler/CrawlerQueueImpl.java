package com.example.crawler;

import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class CrawlerQueueImpl implements CrawlerQueue<WebPage>{
    private final Queue<WebPage> queue = new ConcurrentLinkedQueue<>();

    @Override
    public void add(WebPage item) {
        queue.add(item);
    }

    @Override
    public WebPage remove() {
        return queue.remove();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
