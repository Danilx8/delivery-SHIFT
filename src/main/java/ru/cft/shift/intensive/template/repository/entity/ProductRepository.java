package ru.cft.shift.intensive.template.repository.entity;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table("products_food")
public class ProductRepository {
    @PrimaryKey
    private long category_id;
    @Column
    private String id;

    public ProductRepository(long category_id, String id) {
        this.category_id = category_id;
        this.id = id;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}