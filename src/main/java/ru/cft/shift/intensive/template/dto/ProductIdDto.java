package ru.cft.shift.intensive.template.dto;

import javax.swing.*;

public class ProductIdDto {
    private Spring message;
    private Spring code;

    public ProductIdDto(Spring message, Spring code) {
        this.message = message;
        this.code = code;
    }

    public ProductIdDto(String name) {
    }

    public Spring getMessage() {
        return message;
    }

    public void setMessage(Spring message) {
        this.message = message;
    }

    public Spring getCode() {
        return code;
    }

    public void setCode(Spring code) {
        this.code = code;
    }
}
