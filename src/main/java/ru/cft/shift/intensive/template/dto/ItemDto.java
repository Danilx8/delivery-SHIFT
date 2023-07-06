package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record ItemDto(@NotEmpty(message = "{validation.delivery.owner.not-empty}") String owner,
            @NotEmpty(message = "{validation.delivery.name.not-empty}") String name,
            @Min(value =  1, message = "{validation.delivery.cost.positive}") Integer cost,
            @Size(max = 280) String description,
            @Min(value =  1, message = "{validation.delivery.cost.positive}") Integer weight) {
    
}
