package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class DiscountService {

    public int getDiscount(List<Watch> watches) {
        return IntStream.of(
                new RolexDiscountStrategy().applyDiscount(watches),
                new MichaelCorsDiscountStrategy().applyDiscount(watches)
        ).sum();
    }
}
