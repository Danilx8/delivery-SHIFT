package ru.cft.shift.intensive.template.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ru.cft.shift.intensive.template.dto.Address;
import ru.cft.shift.intensive.template.dto.OrderDto;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;
import ru.cft.shift.intensive.template.dto.PurchaseState;
import ru.cft.shift.intensive.template.repository.PurchasesRepository;
import ru.cft.shift.intensive.template.repository.entity.Purchases;
import ru.cft.shift.intensive.template.repository.entity.PurchasesPrimaryKeyClass;
import ru.cft.shift.intensive.template.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    
    private final PurchasesRepository repository;

    public PurchaseServiceImpl(PurchasesRepository repository) {
        this.repository = repository;
    }

    private Purchases BuildPurchaseEntity(ProductDto product, Address destination, PurchaseState state, Integer quantity, Address address) {
        UUID id = UUID.randomUUID();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        return new Purchases(new PurchasesPrimaryKeyClass(id, product.getId()), destination.toString(), state.toString(), product.getWeight(), product.getShopName(), user, product.getName(), quantity, address.toString(), product.getPrice(), product.getDescription());
    }

    @Override
    public List<String> PurchaseCartProducts(OrderDto order) {
        List<PurchaseDto> purchases = order.purchases();
        String destination = order.destination();
        purchases.forEach(purchase -> {
            UUID id = UUID.randomUUID();
            String user = SecurityContextHolder.getContext().getAuthentication().getName();
            repository.save(new Purchases(new PurchasesPrimaryKeyClass(id, purchase.getItemId()), destination, "IN_PROGRESS", purchase.getWeight(), purchase.getShopName(), user, purchase.getItemName(), purchase.getQuantity(), purchase.getShopAddress().toString(), purchase.getPrice(), purchase.getDescription()));
        });
        return purchases.stream().map(purchase -> purchase.getItemName()).toList();
    }

    @Override
    public List<PurchaseDto> ListAllPurchases() {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository.findAllByUser(user).stream().map(
            purchase -> new PurchaseDto(purchase.keyClass().getId().toString(), purchase.address(), purchase.state().toString(), purchase.weight(), purchase.shop(), purchase.keyClass().getProductId(), purchase.productName(), purchase.quantity(), purchase.price(), purchase.destination(), purchase.description())
        ).toList();
    }

    @Override
    public Void AddToCart(ProductDto product) {
        repository.save(BuildPurchaseEntity(product, Address.NONE, PurchaseState.VACANT, 1, product.getAddress()));
        return null;
    }

    @Override
    public Void DeleteFromCart(String productId) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Purchases purchase = repository.findByUserAndKeyClassProductId(user, productId); 
        if(purchase == null) throw new RuntimeException();
        repository.delete(purchase);
        return null;
    }

    @Override
    public Float CalculateTotalCost() {
        // return repository.findAllBySession(RandomStringUtils.randomAlphabetic(10)).stream().map(Purchases::price).reduce(0.0f, Float::sum);
        return 0.0f;
    }

    @Override
    public Integer CalculateDeliveryTime() {
        // if (repository.findBySession(RandomStringUtils.randomAlphabetic(10)).stream().map(Purchases::address) == repository.findBySession(RandomStringUtils.randomAlphabetic(10)).stream().map(Purchases::destination)) {
        //     return 30.0f;
        // }

        return 60;
    }

    @Override
    public Void RemovePurchase(String productId) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Purchases purchase = repository.findByUserAndKeyClassProductId(user, productId);
        if (purchase == null) throw new RuntimeException(); 
        if (purchase.quantity() == 1) {
            repository.delete(purchase);
        } else {
            Purchases updatedPurchase = new Purchases(new PurchasesPrimaryKeyClass(purchase.keyClass().getId(), purchase.keyClass().getProductId()), purchase.destination(), purchase.state(), purchase.weight(), purchase.shop(), user, purchase.productName(), purchase.quantity() - 1, purchase.address(), purchase.price(), purchase.description());
            repository.save(updatedPurchase);
        }

        return null;
    }

    @Override
    public Void AddPurchase(String productId) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Purchases purchase = repository.findByUserAndKeyClassProductId(user, productId);
        if (purchase == null) throw new RuntimeException();
        Purchases updatedPurchase = new Purchases(new PurchasesPrimaryKeyClass(purchase.keyClass().getId(), purchase.keyClass().getProductId()), purchase.destination(), purchase.state(), purchase.weight(), purchase.shop(), user, purchase.productName(), purchase.quantity() + 1, purchase.address(), purchase.price(), purchase.description());
        repository.save(updatedPurchase);
        
        return null;
    }
}
