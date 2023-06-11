package com.jin.crawling.controller;

import com.jin.crawling.application.CrawlingService;
import com.jin.crawling.application.TextProcessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class CrawlingController {

    private final CrawlingService crawlingService;
    private final TextProcessService textProcessService;

    public CrawlingController(CrawlingService crawlingService, TextProcessService textProcessService) {
        this.crawlingService = crawlingService;
        this.textProcessService = textProcessService;
    }

    @GetMapping("/crawling")
    public String crawling() {
        return "test";
    }

    public List<String> crawlInParallel(List<String> urls) {
        List<CompletableFuture<String>> completableFutures = urls.stream().map(this.crawlingService::getCrawlingContent).toList();

        return completableFutures.stream().map(CompletableFuture::join).toList();
    }
}
