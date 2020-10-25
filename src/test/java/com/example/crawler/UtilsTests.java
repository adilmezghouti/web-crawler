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

}