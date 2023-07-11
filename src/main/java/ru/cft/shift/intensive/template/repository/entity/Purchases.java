package ru.cft.shift.intensive.template.repository.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("purchases")
public record Purchases(
    @PrimaryKey()
    PurchasesPrimaryKeyClass keyClass,
    @Column("destination_point")
    String destination,
    @Column("condition")
    String state,
    @Column("weight_order")
    Float weight,
    @Column("name_shop")
    String shop,
    @Column("name_product")
    String productName,
    @Column
    Integer quantity,
    @Column
    String address,
    @Column
    Float price,
    @Column
    String description
) {
}