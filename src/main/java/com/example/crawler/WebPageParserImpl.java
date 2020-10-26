package com.example.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Scope("prototype")
public class WebPageParserImpl implements WebPageParser<WebPage> {

    @Override
    public Set<WebPage> parse(final String url) throws Exception {
        Set<WebPage> set = new HashSet<>();

        Document document = Jsoup.connect(url)
                .timeout(0).get();

        // Retrieve all the anchor tags
        Elements aElements =
                document.getElementsByTag("a");
        for (Element element : aElements) {
            set.add(new WebPage(element.attr("href"), url));
        }

        // Retrieve media elements
        for (Element element:document.select("[src]")) {
            set.add(new WebPage(element.attr("src"), url, true));
        }

        // retrieve css and script elements
        for (Element element:document.select("link[href]")) {
            set.add(new WebPage(element.attr("href"), url, true));
        }
        return set;
    }
}
