package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class CartDto {
    @NotEmpty(message = "{validation.store.products.cost.not-empty}")
    @Size(max = 10)
    private String total_cost;
    @NotEmpty(message = "{validation.store.products.name.not-empty}")
    @Size(min = 3, max = 100)
    private String name;
    private Set<SpecificationsDto> specifications = new HashSet<>();
    private Set<CompositionDto> composition = new HashSet<>();
    @Size(min = 1)
    private String id;
    @Size(max = 500)
    private String description;

    public CartDto() {}

    public CartDto(String total_cost, String name, String description, Set<CompositionDto> composition, String id) {
        this.total_cost = total_cost;
        this.name = name;
        this.composition = composition;
        this.id = id;
        this.description = description;
    }

    public CartDto(String total_cost, String name, Set<SpecificationsDto> specifications, String id, String description) {
        this.total_cost = total_cost;
        this.name = name;
        this.specifications = specifications;
        this.id = id;
        this.description = description;
    }

    public String getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(String total_cost) {
        this.total_cost = total_cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SpecificationsDto> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Set<SpecificationsDto> specifications) {
        this.specifications = specifications;
    }

    public Set<CompositionDto> getComposition() {
        return composition;
    }

    public void setComposition(Set<CompositionDto> composition) {
        this.composition = composition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}