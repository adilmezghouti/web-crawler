package com.example.crawler;

import java.util.Set;

public interface WebPageParser<T> {
    Set<T> parse(final String url) throws Exception;
}
