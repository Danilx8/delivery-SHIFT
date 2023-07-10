package ru.cft.shift.intensive.template.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;
import ru.cft.shift.intensive.template.repository.PurchasesRepository;
import ru.cft.shift.intensive.template.repository.entity.Purchases;
import ru.cft.shift.intensive.template.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    
    private final PurchasesRepository repository;

    public PurchaseServiceImpl(PurchasesRepository repository) {
        this.repository = repository;
    }

    // private Purchases ProductToPurchaseConverter(ProductDto product) {
    //     String purchaseId = ()

    //     return new Purchases();
    // }

    // @Override
    // public Void AddToCart(ProductDto product) {
    //     repository.save(product);
    // }

    // @Override
    // public List<PurchaseDto> AllPurchases(String currentSessionId) {
    //     return repository.FindAllBySession(currentSessionId);
    // }

    // @Override
    // public Float CalculateDeliveryTime(String currentSessionId) {
    //     return repository.FindAllBySession(currentSessionId).map()
    // }

    // @Override
    // public Float CalculateTotalCost(String currentSessionId) {
    //     return repository.FindAllBySession(currentSessionId)
    // }

    // @Override
    // public Void Create(List<ProductDto> products) {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @Override
    // public Void DeleteFromCart(String currentSessionId, String productId) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'DeleteFromCart'");
    // }
    
}
