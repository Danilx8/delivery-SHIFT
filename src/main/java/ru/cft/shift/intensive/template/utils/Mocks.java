package ru.cft.shift.intensive.template.utils;

import ru.cft.shift.intensive.template.dto.CartDto;
//import ru.cft.shift.intensive.template.dto.ProductDescriptionDto;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.ProductIdDto;
import ru.cft.shift.intensive.template.dto.SpecificationsDto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Mocks {
    private Mocks() {}

//    public static ProductDto products() {
//        return new ProductDto("Футболка FILA", Set.of(new SpecificationsDto("XL", "Хлопок", "Принт")));
//    }

//    public static ProductDescriptionDto productsDescription() {
//        return new ProductDescriptionDto("Гамбургер", "134", "Новый бургер", "149.99");
//    }


    public static ProductIdDto productIdDto(ProductDto product){
        return new ProductIdDto(product.getName());
    }

    // получит все товары
    public static List<ProductDto> product(){
        return Arrays.asList(
                new ProductDto("Зеленая футболка", Set.of(
                        new SpecificationsDto("XXL", "cotton", "Print")
                ), "Футболка оригинальная")
        );
    }
}
