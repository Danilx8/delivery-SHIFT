package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public record PurchaseDto(
            @NotEmpty String orderId,
            @NotEmpty Address shopAdress,
            @NotEmpty PurchaseState state,
            @NotEmpty @Min(value = 1) Float weight, //упрощение ограничения значения
            @NotEmpty String shopName,
            @NotEmpty String itemId,
            @NotEmpty String itemName,
            @NotEmpty @Min(value = 1) Integer quantity,
            @NotEmpty @Min(value = 1) Float cost,
            @NotEmpty Address customerAddress,
            @NotEmpty @Max(value = 250) String description) {
}
