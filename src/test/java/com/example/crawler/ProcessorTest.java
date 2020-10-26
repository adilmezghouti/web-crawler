package com.example.crawler;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProcessorTest {
    private final String URL = "http://wiprodigital.com";
    @Autowired
    Processor processor;

    @Autowired
    private ProcessedPages<WebPage> processedPages;

    @MockBean
    private WebPageParser<WebPage> parser;

    @Test
    void shouldProcessItems() throws Exception {
        given(this.parser.parse(URL))
                .willReturn(Set.of(new WebPage("https://wiprodigital.com/who-we-are/"), new WebPage("https://wiprodigital.com/what-we-do/")));
        processor.process(URL);
        assertTrue(processedPages.getAll().size() > 0);
    }

    @Test
    void shouldFindFailingItemsForNonExistingUrls() throws Exception {
        given(this.parser.parse(URL))
                .willReturn(Set.of(new WebPage("https://wiprodigital.com/who-we-are/"), new WebPage("https://wiprodigital.com/what-we-do/")));
        processor.process(URL + "blala");
        assertFalse(processedPages.getAll().stream().filter(WebPage::isVisited).toArray().length > 0);
    }

    @Test
    void shouldFindFailingItemsWhenExceptionsOccur() throws Exception {
        given(this.parser.parse(URL))
                .willThrow(new Exception("any error"));
        processor.process(URL);
        assertTrue(processedPages.getAll().stream().filter(item -> !item.getError().isEmpty()).toArray().length > 0);
    }
}