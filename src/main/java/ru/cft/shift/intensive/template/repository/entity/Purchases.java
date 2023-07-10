package ru.cft.shift.intensive.template.repository.entity;

import org.springframework.data.cassandra.core.mapping.Table;

@Table("purchases")
public record Purchases(
    String id,
    String destination,
    String state,
    Float weight,
    String shop,
    String productId,
    String productName,
    Integer quantity,
    String adress,
    Float price,
    String description
) {
}