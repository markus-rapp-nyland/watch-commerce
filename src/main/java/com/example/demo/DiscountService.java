package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class DiscountService {

    public int getDiscount(List<Watch> watches) {
        return  Stream.of(new RolexDiscountStrategy(), new MichaelCorsDiscountStrategy())
                .mapToInt(discountStrategy -> discountStrategy.applyDiscount(watches))
                .sum();
    }
}
