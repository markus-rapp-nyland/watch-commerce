package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WatchServiceTest {

    private final WatchRepository repo = new WatchRepository();
    private final DiscountService discountService = new DiscountService();
    private final WatchService service = new WatchService(repo, discountService);

    @Test
    void empty_order() {
        int result = service.sumCheckout(emptyList());
        assertEquals(0, result);
    }

    @Test
    void calculate_price_for_single_items() {
        int result = service.sumCheckout(List.of("001", "002"));
        assertEquals(180, result);
    }

    @Test
    void single_rolex_discount() {
        int result = service.sumCheckout(List.of("001", "001", "001", "001"));
        assertEquals(300, result);
    }

    @Test
    void multiple_rolex_discount() {
        int result = service.sumCheckout(List.of("001", "001", "001", "001", "001", "001"));
        assertEquals(400, result);
    }

    @Test
    void single_michael_cors_discount() {
        int result = service.sumCheckout(List.of("002", "002", "002"));
        assertEquals(200, result);
    }

    @Test
    void multiple_michael_cors_discount() {
        int result = service.sumCheckout(List.of("002", "002", "002", "002", "002", "002"));
        assertEquals(360, result);
    }
}