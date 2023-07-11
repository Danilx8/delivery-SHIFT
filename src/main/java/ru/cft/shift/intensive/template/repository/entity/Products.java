package ru.cft.shift.intensive.template.repository.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("products")
public record Products(
    @PrimaryKey("id_product")
    String id,
    @Column("name_product")
    String name,
    @Column("name_shop")
    String shop,
    @Column
    String address,
    @Column
    Float price,
    @Column("weight_item")
    Float weight,
    @Column
    String description
) {
}
