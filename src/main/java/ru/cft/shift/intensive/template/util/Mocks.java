package ru.cft.shift.intensive.template.util;

import java.util.Arrays;
import java.util.List;

import ru.cft.shift.intensive.template.dto.Address;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;
import ru.cft.shift.intensive.template.dto.PurchaseState;

public class Mocks {
    private Mocks() {}

    public static String Owner(ProductDto product) {
        return product.shopName();
    }

    public static ProductDto ProductByName(String name) {
        return new ProductDto("1", "Суп Харчо", "Твиани", "OKTYABRSKY",  200.0F, 300.0F, "Традиционное грузинское блюдо с бараниной и различными специями");
    }

    public static List<ProductDto> AllProducts() {
        return Arrays.asList(
            new ProductDto("2",  "Ножки куриные", "KFC", "PERVOMAISKY", 250.0F, 500.0F, "Куриные ножки в хрустящей оболочке в фирменном ведре")
        );
    } 

    public static Integer Time() {
        return 30;
    }

    public static String OrderId() {
        return "0";
    }

    public static List<PurchaseDto> AllPurchases() {
        return Arrays.asList(
            new PurchaseDto("1", "KIROVSKY", "VACANT", 120000.0F, "Аура", "12", "Киа Рио", 1, 1200000.0F, "ZAELTSOVSKY", "Подвезите к подъезду")
        );
    }

    public static Float Cost() {
        return 3.0F;
    }

    public static List<String> CreatedPurchasesIds() {
        return Arrays.asList(
            "0", "1", "2", "3"
        );
    }
}