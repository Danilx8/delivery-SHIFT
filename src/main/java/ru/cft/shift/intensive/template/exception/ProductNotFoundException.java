package ru.cft.shift.intensive.template.exception;

public class ProductNotFoundException extends CodeAbleException{
    public ProductNotFoundException() {
        super(2, "api.store.products.by-name.api.response.404");
    }
}
