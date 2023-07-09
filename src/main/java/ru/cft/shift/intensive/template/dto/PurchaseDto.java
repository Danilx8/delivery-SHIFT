package ru.cft.shift.intensive.template.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public class PurchaseDto {
    @NotEmpty private String orderId;
    @NotEmpty private Address shopAddress;
    @NotEmpty private PurchaseState state;
    @NotEmpty @Min(value = 1) private Float weight;
    @NotEmpty private String shopName;
    @NotEmpty private String itemId;
    @NotEmpty private String itemName;
    @NotEmpty @Min(value = 1) private Integer quantity;
    @NotEmpty @Min(value = 1) private Float cost;
    @NotEmpty private Address customerAddress;
    @NotEmpty @Max(value = 250) private String description;

    public PurchaseDto() {
    }

    public PurchaseDto(String orderId, String shopAddress, String state, Float weight, String shopName, 
    String itemId, String itemName, Integer quantity, Float cost, String customerAddress, String description) throws RuntimeException {
        Boolean isInputValid = true;
        for (Address district: Address.values()) {
            if (district.toString().equalsIgnoreCase(shopAddress)) {
                this.shopAddress = district;
                break;
            }
            isInputValid = false;
        }

        for (PurchaseState purchaseState: PurchaseState.values()) {
            if (purchaseState.toString().equalsIgnoreCase(state)) {
                this.state = purchaseState;
                break;
            }
            isInputValid = false;
        }

        for (Address district: Address.values()) {
            if (district.toString().equalsIgnoreCase(customerAddress)) {
                this.customerAddress = district;
                break;
            }
            isInputValid = false;
        }

        if (!isInputValid) throw new RuntimeException();
        
        this.orderId = orderId;
        this.weight = weight;
        this.shopName = shopName;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.cost = cost;
        this.description = description;
    }
}
