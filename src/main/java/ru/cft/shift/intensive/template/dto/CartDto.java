package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CartDto {
    @NotEmpty(message = "{validation.store.products.cost.not-empty}")
    @Size(max = 10)
    private String total_cost;

    public CartDto(String total_cost) {
        this.total_cost = total_cost;
    }

    public CartDto() {}

    public String getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(String total_cost) {
        this.total_cost = total_cost;
    }
}
