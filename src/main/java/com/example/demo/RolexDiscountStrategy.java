package com.example.demo;

public class RolexDiscountStrategy implements DiscountStrategy {
    @Override
    public int applyDiscount(int standardUnitPrice) {
        return standardUnitPrice;
    }
}
