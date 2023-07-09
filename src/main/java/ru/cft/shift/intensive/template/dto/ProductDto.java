package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProductDto {
    @NotEmpty(message =" {validation.delivery.id.not-empty}") private String id;
    @NotEmpty(message = "{validation.delivery.name.not-empty}") private String name;
    @NotEmpty(message = "{validation.delivery.owner.not-empty}") private String shopName;
    @NotEmpty(message = "{validation.delivery.address.not-empty}") private Address address;
    @Min(value =  1, message = "{validation.delivery.cost.positive}") private Float price;
    @Min(value =  1, message = "{validation.delivery.cost.positive}") private Float weight;
    @Size(max = 280) private String description;
    
    public ProductDto() {
    }

    public ProductDto(String id, String name, String shopName, String address, Float price, Float weight, String description) throws RuntimeException {
        Boolean isInputValid = false;
        for (Address district: Address.values()) {
            if (district.toString().equalsIgnoreCase(address)) {
                this.address = district;
                isInputValid = true;
                break;
            }
        }
        if (!isInputValid) throw new RuntimeException();

        this.id = id;
        this.name = name;
        this.shopName = shopName;
        this.price = price;
        this.weight = weight;
        this.description = description;
    }
}
