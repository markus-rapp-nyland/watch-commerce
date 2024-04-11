package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MichaelCorsDiscountStrategy implements DiscountStrategy {
    @Override
    public int applyDiscount(List<Watch> watchOrder) {
        List<Watch> corsList = watchOrder.stream()
                .filter(watch -> "002".equals(watch.id()))
                .toList();

        int discount = 0;
        if (!corsList.isEmpty()) {
            int unitPrice = corsList.getFirst().unitPrice();

            for (int i = 0; i < Math.floorDiv(corsList.size(), 2); i++) {
                discount += (int) (unitPrice * 0.5);
                log.debug("Applied 50% discount for second Michael Cors watch");
            }
        }
        return discount;
    }
}
