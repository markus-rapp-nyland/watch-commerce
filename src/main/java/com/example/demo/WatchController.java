package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WatchController {

    private final WatchService watchService;

    public WatchController(WatchService watchService) {
        this.watchService = watchService;
    }

    @PostMapping(path = "checkout")
    public PriceResponse checkout(@RequestBody List<String> itemIds) {
        return new PriceResponse(watchService.sumCheckout(itemIds));
    }
}
