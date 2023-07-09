package ru.cft.shift.intensive.template.service.impl;

import java.util.List;

import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.repository.ProductsRepository;
import ru.cft.shift.intensive.template.repository.entity.Products;
import ru.cft.shift.intensive.template.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private final ProductsRepository repository;

    public ProductServiceImpl(ProductsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDto> all() {
        return repository.findAll().stream()
            .map(product -> new ProductDto(product.id(), product.name(), product.shop(), product.address(), product.price(), product.weight(), product.description())).toList();
    }

    @Override
    public ProductDto findByName(String name) {
        Products product = repository.findByName(name);
        return new ProductDto(product.id(), product.name(), product.shop(), product.address(), product.price(), product.weight(), product.description());
    }
}
