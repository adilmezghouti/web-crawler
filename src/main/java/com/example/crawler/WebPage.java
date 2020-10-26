package com.example.crawler;

import java.util.Objects;

public class WebPage {
    private String url;
    private boolean visited;
    private String error;
    private int timeVisited;

    public WebPage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getTimeVisited() {
        return timeVisited;
    }

    public void setTimeVisited(int timeVisited) {
        this.timeVisited = timeVisited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage webPage = (WebPage) o;
        return visited == webPage.visited && timeVisited == webPage.timeVisited && Objects.equals(url, webPage.url) && Objects.equals(error, webPage.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, visited, error, timeVisited);
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "url='" + url + '\'' +
                ", visited=" + visited +
                ", error='" + error + '\'' +
                ", timeVisited=" + timeVisited +
                '}';
    }
}
