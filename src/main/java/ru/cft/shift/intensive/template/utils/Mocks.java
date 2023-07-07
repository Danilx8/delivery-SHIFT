package ru.cft.shift.intensive.template.utils;

import ru.cft.shift.intensive.template.dto.*;
import ru.cft.shift.intensive.template.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Mocks {
    private Mocks() {}

    public static ProductDto products() {
        return new ProductDto("Футболка FILA",  "Чёрная футболка с принтом", Set.of(new SpecificationsDto("XL", "Хлопок", "Принт")));
    }

    public static ProductDto productsDescription() {
        return new ProductDto("Гамбургер", "134", "Новый бургер", "149.99");
    }

    public static CartDto addProduct(ProductRepository productRepository) {
        return new CartDto();
    }


    public static List<CartDto> cartProducts() {
        return Arrays.asList(
                new CartDto("29.99", "Ланч баскет 15 за 30", "Большой обед", Set.of(
                         new CompositionDto("Здесь пишем состав", "1100г", "много")
                ), "231")
        );
    }

    public static DeliveryDto timeDelivery() {
        return new DeliveryDto("13:30");
    }

    public static List<DeliveryDto> deliveryDto(DeliveryDto order) {
        return Arrays.asList(
                new DeliveryDto("Чебупели", Set.of(
                        new CompositionDto("Здесь пишем состав", "1100г", "много")
                ), "231", "Состав: тесто и ещё что-то", "100", "13:00")
        );
    }

}
