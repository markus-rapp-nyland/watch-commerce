package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DiscountService {

    public List<Discount> getDiscounts(List<Watch> watches) {

        Map<String, List<Watch>> watchMap = watches.stream()
                .collect(Collectors.groupingBy(Watch::id));

        List<Discount> discounts = new ArrayList<>();

        for (Map.Entry<String, List<Watch>> entry : watchMap.entrySet()) {
            String key = entry.getKey();
            switch (key) {
                case "001" -> {
                    Watch rolexUnit = entry.getValue().getFirst();
                    DiscountStrategy discountStrategy = new RolexDiscountStrategy();

                    for (int i = 0; i < Math.floorDiv(entry.getValue().size(), 3); i++) {
                        discounts.add(new Discount(
                                discountStrategy.applyDiscount(rolexUnit.unitPrice()),
                                ""
                        ));

                    }
                }
            }
        }


        return discounts;
    }


}
