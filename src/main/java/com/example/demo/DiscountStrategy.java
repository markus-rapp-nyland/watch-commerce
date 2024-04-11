package com.example.demo;

import java.util.List;

public interface DiscountStrategy {
    int applyDiscount(List<Watch> watchOrder);
}
