package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

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
        List<Discount> discounts = discountService.getDiscounts(watches);

        return IntStream
                .concat(watches.stream()
                                .mapToInt(Watch::unitPrice),
                        discounts.stream()
                                .mapToInt(discount -> discount.price() * -1))
                .sum();
    }
}
