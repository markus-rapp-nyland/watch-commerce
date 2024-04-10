package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchService {

    private final WatchRepository watchRepository;

    public WatchService(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    public int sumCheckout(List<String> itemIds) {
        List<Watch> watches = watchRepository.getWatchesFromIds(itemIds);

        return watches.stream()
                .mapToInt(Watch::unitPrice)
                .sum();
    }
}
