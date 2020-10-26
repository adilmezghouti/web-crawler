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
        assertTrue(Utils.areUrlsSameDomain("https://wiprodigital.com", "https://wiprodigital.com/partners/leanix/"));
    }

    @Test
    void isTrueIfUrlsHaveSameHostWithDifferentSubdomains() {
        assertTrue(Utils.areUrlsSameDomain("https://wiprodigital.com", "https://subdomain.wiprodigital.com/partners/leanix/"));
    }

    @Test
    void isTrueIfUrlsHaveSameHostWithDifferentCases() {
        assertTrue(Utils.areUrlsSameDomain("https://wiprodigital.com", "https://WIPRODIGITAL.com/partners/leanix/"));
    }

    @Test
    void isFalseIfUrlsHaveDifferentHosts() {
        assertFalse(Utils.areUrlsSameDomain("https://wiprodigital.com", "https://twitter.com/"));
    }
}
