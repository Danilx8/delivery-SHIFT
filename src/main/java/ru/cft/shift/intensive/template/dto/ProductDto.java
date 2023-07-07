package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public class ProductDto {
    @NotEmpty(message = "{validation.store.products.name.not-empty}")
    @Size(min = 3, max = 100)
    private String name;
    private Set<SpecificationsDto> specifications = new HashSet<>();
    private Set<CompositionDto> composition = new HashSet<>();
    @Size(min = 1)
    @NotEmpty(message = "{validation.store.products.id.not-empty}")
    private String id;
    @Size(max = 500)
    @NotEmpty
    private String description;
    @NotEmpty(message = "{validation.store.products.cost.not-empty}")
    private String cost;

    public ProductDto(String name, Set<SpecificationsDto> specifications, Set<CompositionDto> composition, String id, String description, String cost) {
        this.name = name;
        this.specifications = specifications;
        this.composition = composition;
        this.id = id;
        this.description = description;
        this.cost = cost;
    }

    public ProductDto() {}

    public ProductDto(String name, String description, Set<SpecificationsDto> specifications) {
        this.name = name;
        this.specifications = specifications;
        this.description = description;
    }


    public ProductDto(String name, String id, String description, String cost) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.cost = cost;
    }

    public ProductDto(String name, Set<SpecificationsDto> specifications, String description) {
        this.name = name;
        this.specifications = specifications;
        this.description = description;
    }

    public String getName()  {
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
