package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchService {

    private final WatchRepository watchRepository;
    private final DiscountService discountService;

    public WatchService(WatchRepository watchRepository, DiscountService discountService) {
        this.watchRepository = watchRepository;
        this.discountService = discountService;
    }

    public int sumCheckout(List<String> itemIds) {
        List<Watch> watches = watchRepository.getWatchesFromIds(itemIds);
        int discount = discountService.getDiscount(watches);

        int regularPrice = watches.stream()
                .mapToInt(Watch::unitPrice).sum();

        return regularPrice - discount;
    }
}
