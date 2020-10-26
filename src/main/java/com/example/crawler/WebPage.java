package com.example.crawler;

import java.util.Objects;

public class WebPage {
    private String url;
    private boolean visited;
    private String error;
    private int timeVisited;
    private String sourceUrl;
    private boolean isStaticContent;
    private boolean isExternalUrl;

    public WebPage(String url, String sourceUrl) {
        this.url = url;
        this.sourceUrl = sourceUrl;
    }

    public WebPage(String url, String sourceUrl, boolean isStaticContent) {
        this.url = url;
        this.sourceUrl = sourceUrl;
        this.isStaticContent = isStaticContent;
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

    public boolean isStaticContent() {
        return isStaticContent;
    }

    public void setStaticContent(boolean staticContent) {
        isStaticContent = staticContent;
    }

    public boolean isExternalUrl() {
        return isExternalUrl;
    }

    public void setExternalUrl(boolean externalUrl) {
        isExternalUrl = externalUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage webPage = (WebPage) o;
        return visited == webPage.visited && timeVisited == webPage.timeVisited && isStaticContent == webPage.isStaticContent && isExternalUrl == webPage.isExternalUrl && Objects.equals(url, webPage.url) && Objects.equals(error, webPage.error) && Objects.equals(sourceUrl, webPage.sourceUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, visited, error, timeVisited, sourceUrl, isStaticContent, isExternalUrl);
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "url='" + url + '\'' +
                ", visited=" + visited +
                ", error='" + error + '\'' +
                ", timeVisited=" + timeVisited +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", isStaticContent=" + isStaticContent +
                ", isExternalUrl=" + isExternalUrl +
                '}';
    }
}
