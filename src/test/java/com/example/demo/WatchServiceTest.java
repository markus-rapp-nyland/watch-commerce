package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WatchServiceTest {

    private final WatchRepository repo = new WatchRepository();
    private final DiscountService discountService = new DiscountService();
    private final WatchService service = new WatchService(repo, discountService);

    @Test
    void calculate_price_for_single_items() {
        int result = service.sumCheckout(List.of("001", "002"));

        assertEquals(180, result);
    }
}