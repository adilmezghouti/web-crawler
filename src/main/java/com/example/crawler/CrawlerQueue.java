package com.example.crawler;

public interface CrawlerQueue<T> {
    void add(T item);
    T remove();
    boolean isEmpty();
}
