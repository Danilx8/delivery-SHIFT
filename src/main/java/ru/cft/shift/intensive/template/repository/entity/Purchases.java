package ru.cft.shift.intensive.template.repository.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("purchases")
public record Purchases(
    @PrimaryKey()
    PurchasesPrimaryKeyClass keyClass,
    @Column
    String destination,
    @Column("condition")
    String state,
    @Column
    Integer weight,
    @Column("shop_name")
    String shop,
    @Column("user_id")
    UUID user,
    @Column("product_name")
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