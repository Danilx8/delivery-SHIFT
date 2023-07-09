package ru.cft.shift.intensive.template.repository.entity;

import org.springframework.data.cassandra.core.mapping.Table;

@Table("products")
public record Products(
    String id,
    String name,
    String shop,
    String address,
    Float price,
    Float weight,
    String description
) {
}
