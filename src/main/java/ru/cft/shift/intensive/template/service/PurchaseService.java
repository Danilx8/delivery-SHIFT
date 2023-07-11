package ru.cft.shift.intensive.template.service;

import java.util.List;

import ru.cft.shift.intensive.template.dto.OrderDto;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;
import ru.cft.shift.intensive.template.repository.entity.PurchasesPrimaryKeyClass;

public interface PurchaseService {
    Void PurchaseCartProducts(OrderDto order);
    
    List<PurchaseDto> ListAllPurchases();

    Void AddToCart(ProductDto product);

    Void RemovePurchase(PurchasesPrimaryKeyClass purchaseId);

    Void AddPurchase(PurchasesPrimaryKeyClass purchaseId);

    Void DeleteFromCart(PurchasesPrimaryKeyClass purchaseId);

    Float CalculateTotalCost();

    Float CalculateDeliveryTime();
}
