package ru.cft.shift.intensive.template.repository.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("products")
public record Products(
    @PrimaryKey
    UUID id,
    @Column
    String name,
    @Column("shop_name")
    String shop,
    @Column
    String address,
    @Column
    Float price,
    @Column
    Integer weight,
    @Column
    String description
) {
}
