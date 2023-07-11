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
    String address,
    Float price,
    String description
) {
}