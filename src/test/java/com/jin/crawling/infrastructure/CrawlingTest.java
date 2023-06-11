package com.jin.crawling.infrastructure;

import com.jin.crawling.application.TextProcessServiceImpl;
import com.jin.crawling.config.CrawlingProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest // TODO
public class CrawlingTest {

    @Autowired
    private CrawlingClientImpl crawlingClient;

    @Autowired
    private CrawlingProperties crawlingProperties;

    private final String url1 = "https://shop.hyundai.com";
    private final String url2 = "https://www.kia.com";
    private final String url3 = "https://www.genesis.com";

    @Test
    public void getHtmlTest() {
        String html = crawlingClient.getHtml(url1);
        crawlingClient.getHtml(url2);
        crawlingClient.getHtml(url3);
        crawlingClient.getHtml(url1);
        crawlingClient.getHtml(url2);
        crawlingClient.getHtml(url3);
        assertNotNull(html);
    }

//    @Test
//    public void test() throws IOException {
//        assertEquals("Test", "Test");
//
//        String crawlingText = "";
//
//        crawlingText = crawlingText + crawlingClient.getHtml(url1);
//        System.out.println("crawling1 length: " + crawlingText.length());
//
//        crawlingText = crawlingText + crawlingClient.getHtml(url2);
//        System.out.println("crawling2 length: " + crawlingText.length());
//
//        crawlingText = crawlingText + crawlingClient.getHtml(url3);
//        System.out.println("crawling3 length: " + crawlingText.length());
//
//        TextProcessServiceImpl processor = new TextProcessServiceImpl();
//        processor.initTextProcessService(crawlingText);
//        String filteredText = processor.filterEnglishAndNum();
//        System.out.println("filtered length: " + filteredText.length());
//
//        String deduplicated = processor.deduplicate();
//        System.out.println("deduplicated length: " + deduplicated.length());
//
//        String sortedText = processor.sortAscending();
//        System.out.println("sorted length: " + sortedText.length());
//
//
//        System.out.println(sortedText);
//    }
}
