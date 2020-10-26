package com.example.crawler;

import java.util.Objects;

public class WebPage {
    private String url;
    private boolean visited;
    private String error;
    private int timeVisited;
    private String sourceUrl;

    public WebPage(String url, String sourceUrl) {
        this.sourceUrl = sourceUrl;
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

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage webPage = (WebPage) o;
        return visited == webPage.visited && timeVisited == webPage.timeVisited && Objects.equals(url, webPage.url) && Objects.equals(error, webPage.error) && Objects.equals(sourceUrl, webPage.sourceUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, visited, error, timeVisited, sourceUrl);
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "url='" + url + '\'' +
                ", visited=" + visited +
                ", error='" + error + '\'' +
                ", timeVisited=" + timeVisited +
                ", sourceUrl='" + sourceUrl + '\'' +
                '}';
    }
}
