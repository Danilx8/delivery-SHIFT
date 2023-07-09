package ru.cft.shift.intensive.template.repository.entity;

import org.springframework.data.cassandra.core.mapping.Table;

@Table("purchases")
public record Purchases(
    String id,
    String destination,
    String state,
    Float weight,
    String shop,
    String name,
    Integer quantity,
    String adress,
    Float price,
    String description
) {
}