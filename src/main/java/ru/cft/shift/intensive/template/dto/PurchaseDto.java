package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.NotEmpty;

public record PurchaseDto(@NotEmpty Long orderId,
    @NotEmpty String userId,
    @NotEmpty String itemId,
    @NotEmpty AddressDto address) {
}
