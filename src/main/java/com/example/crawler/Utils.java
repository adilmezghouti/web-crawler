package com.example.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * Checks if a given url is valid
     * @param url
     * @return
     */
    public static boolean validateUrl(final String url) {
        if (url == null || url.isBlank() || url.isEmpty()) return false;
        String regex = "^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        return Pattern.matches(regex, url);
    }

    public static boolean isUrlSameDomain(final String primaryUrl, final String secondaryUrl) {
        try {
            URL url1 =  new URL(primaryUrl);
            URL url2 = new URL(secondaryUrl);
            return url1.getHost().equalsIgnoreCase(url2.getHost());
        } catch (MalformedURLException e) {
            logger.error("Failed to compare two urls: {} and {}", primaryUrl, secondaryUrl);
            return false;
        }
    }
}
