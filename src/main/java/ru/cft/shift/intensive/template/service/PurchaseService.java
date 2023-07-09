package ru.cft.shift.intensive.template.service;

import java.util.List;

import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;

public interface PurchaseService {
    Void Create(List<ProductDto> products);
    
    List<PurchaseDto> AllPurchases(String currentSessionId);

    Void AddToCart(ProductDto product);

    Void DeleteFromCart(String currentSessionId, String productId);

    Float CalculateTotalCost(String currentSessionId);

    Float CalculateDeliveryTime(String currentSessionId);
}
