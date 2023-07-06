package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;

public class ProductDto {
    @NotEmpty(message = "{validation.store.products.name.not-empty}")
    private String name;
    private Set<SpecificationsDto> specifications = new HashSet<>();

    public String getName() {
        return name;
    }

    public ProductDto(String name, Set<SpecificationsDto> specifications) {
        this.name = name;
        this.specifications = specifications;
    }

    public ProductDto() {}

    public void setName(String name) {
        this.name = name;
    }

    public Set<SpecificationsDto> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Set<SpecificationsDto> specifications) {
        this.specifications = specifications;
    }
}
