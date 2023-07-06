package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public class ProductDescriptionDto {
    @NotEmpty(message = "{validation.store.products.name.not-empty}")
    @Size(min = 3, max = 100)
    private String name;
    @Size(min = 1)
    private String id;
    @Size(max = 500)
    private String description;
    @NotEmpty(message = "{validation.store.products.cost.not-empty}")
    private String cost;

    public ProductDescriptionDto() {}
    public ProductDescriptionDto(String name, String id, String description, String cost) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
