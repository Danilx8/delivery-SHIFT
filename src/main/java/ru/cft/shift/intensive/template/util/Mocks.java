package ru.cft.shift.intensive.template.util;

import java.util.Arrays;
import java.util.List;

import ru.cft.shift.intensive.template.dto.ItemDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;

public class Mocks {
    private Mocks() {}

    public static String Owner(ItemDto item) {
        return item.owner();
    }

    public static ItemDto ItemById(String owner, String name) {
        return new ItemDto("Твиани", "Суп Харчо", 200, "Традиционное грузинское блюдо с бараниной и различными специями", 300);
    }

    public static List<ItemDto> AllItems() {
        return Arrays.asList(
            new ItemDto("KFC", "Ножки куриные", 250, "Куриные ножки в хрустящей оболочке в фирменном ведре", 500)
        );
    } 

    public static Integer Time(PurchaseDto purchase) {
        return 30;
    }

    public static Long OrderId(PurchaseDto purchase) {
        return purchase.orderId();
    }
}
