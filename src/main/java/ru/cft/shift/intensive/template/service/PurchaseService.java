package ru.cft.shift.intensive.template.service;

import java.util.List;

import ru.cft.shift.intensive.template.dto.Address;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;

public interface PurchaseService {
    Void PurchaseCartProducts(List<ProductDto> products, Address destination, Integer quantity, Address address);
    
    List<PurchaseDto> ListAllPurchases();

    Void AddToCart(ProductDto product, Address destination, Integer quantity, Address address);

    Void DeleteFromCart(String productId);

    Float CalculateTotalCost();

    Float CalculateDeliveryTime();
}
