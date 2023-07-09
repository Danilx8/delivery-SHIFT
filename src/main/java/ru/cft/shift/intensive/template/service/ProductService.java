package ru.cft.shift.intensive.template.service;

import java.util.List;

import ru.cft.shift.intensive.template.dto.ProductDto;

public interface ProductService {
    List<ProductDto> all();

    ProductDto findByName(String name);
}
