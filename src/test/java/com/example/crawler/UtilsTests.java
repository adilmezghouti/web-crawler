package com.example.crawler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTests {
    @Test
    void isValidIfGoodUrl() {
        assertTrue(Utils.validateUrl("http://wiprodigital.com"));
    }

    @Test
    void isInvalidIfNull() {
        assertFalse(Utils.validateUrl(null));
    }

    @Test
    void isInvalidIfEmpty() {
        assertFalse(Utils.validateUrl(""));
    }

    @Test
    void isInvalidIfBlank() {
        assertFalse(Utils.validateUrl(" "));
    }

    @Test
    void isTrueIfUrlsHaveSameHost() {
        assertTrue(Utils.isUrlSameDomain("https://wiprodigital.com", "https://wiprodigital.com/partners/leanix/"));
    }

    @Test
    void isFalseIfUrlsHaveDifferentHosts() {
        assertFalse(Utils.isUrlSameDomain("https://wiprodigital.com", "https://twitter.com/"));
    }
}
