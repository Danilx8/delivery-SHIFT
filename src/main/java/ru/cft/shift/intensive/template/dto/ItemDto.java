package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record ItemDto(
            @NotEmpty(message =" {validation.delivery.id.not-empty}") String id,
            @NotEmpty(message = "{validation.delivery.name.not-empty}") String name,
            @NotEmpty(message = "{validation.delivery.owner.not-empty}") String shopName,
            @NotEmpty(message = "{validation.delivery.address.not-empty}") Address address,
            @Min(value =  1, message = "{validation.delivery.cost.positive}") Float cost,
            @Min(value =  1, message = "{validation.delivery.cost.positive}") Float weight, //упрощение ограничения значения
            @Size(max = 280) String description) {
}
