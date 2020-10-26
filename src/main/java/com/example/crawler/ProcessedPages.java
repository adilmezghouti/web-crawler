package com.example.crawler;

import java.util.List;

public interface ProcessedPages<T> {
    void add(T item);
    List<T> getAll();
}
