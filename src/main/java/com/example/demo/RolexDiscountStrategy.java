package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RolexDiscountStrategy implements DiscountStrategy {
    @Override
    public int applyDiscount(List<Watch> watchOrder) {
        List<Watch> rolexList = watchOrder.stream()
                .filter(watch -> "001".equals(watch.id()))
                .toList();

        int discount = 0;
        if (!rolexList.isEmpty()) {
            int unitPrice = rolexList.getFirst().unitPrice();

            for (int i = 0; i < Math.floorDiv(rolexList.size(), 3); i++) {
                discount += unitPrice;
                log.debug("Applied 3 for 2 discount for rolex watches");
            }
        }
        return discount;
    }
}
