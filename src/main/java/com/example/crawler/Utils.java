package com.example.crawler;

import java.util.regex.Pattern;

public class Utils {
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
}
