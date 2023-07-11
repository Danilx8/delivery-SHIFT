package ru.cft.shift.intensive.template.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import ru.cft.shift.intensive.template.dto.Address;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;
import ru.cft.shift.intensive.template.dto.PurchaseState;
import ru.cft.shift.intensive.template.repository.PurchasesRepository;
import ru.cft.shift.intensive.template.repository.entity.Purchases;
import ru.cft.shift.intensive.template.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    
    private final PurchasesRepository repository;

    public PurchaseServiceImpl(PurchasesRepository repository) {
        this.repository = repository;
    }

    private Purchases ProductToPurchaseConverter(ProductDto product, Address destination, PurchaseState state, Integer quantity, Address address) {
        String id = RandomStringUtils.randomAlphabetic(10);

        return new Purchases(id, destination.toString(), state.toString(), product.getWeight(), product.getShopName(), product.getId(), product.getName(), quantity, address.toString(), product.getPrice(), product.getDescription());
    }

    @Override
    public Void PurchaseCartProducts(List<ProductDto> products, Address destination, Integer quantity, Address address) {
        products.forEach(product -> repository.save(ProductToPurchaseConverter(product,  destination, PurchaseState.IN_PROGRESS, quantity, address)));
        return null;
    }

    @Override
    public List<PurchaseDto> ListAllPurchases() {
        return repository.FindAllBySession("null").stream().map(
            purchase -> new PurchaseDto(purchase.id(), purchase.address(), purchase.state().toString(), purchase.weight(), purchase.shop(), purchase.productId(), purchase.productName(), purchase.quantity(), purchase.price(), purchase.destination(), purchase.description())
        ).toList();
    }

    @Override
    public Void AddToCart(ProductDto product, Address destination, Integer quantity, Address address) {
        repository.save(ProductToPurchaseConverter(product, destination, PurchaseState.VACANT, quantity, address));
        return null;
    }

    @Override
    public Void DeleteFromCart(String productId) {
        repository.delete(repository.findById(productId).orElseThrow());
        return null;
    }

    @Override
    public Float CalculateTotalCost() {
        return repository.FindAllBySession(RandomStringUtils.randomAlphabetic(10)).stream().map(Purchases::price).reduce(0.0f, Float::sum);
    }

    @Override
    public Float CalculateDeliveryTime() {
        if (repository.FindBySession(RandomStringUtils.randomAlphabetic(10)).stream().map(Purchases::address) == repository.FindBySession(RandomStringUtils.randomAlphabetic(10)).stream().map(Purchases::destination)) {
            return 30.0f;
        }

        return 60.0f;
    }

    
}
