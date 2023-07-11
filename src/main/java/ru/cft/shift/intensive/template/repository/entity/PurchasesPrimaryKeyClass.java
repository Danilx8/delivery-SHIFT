package ru.cft.shift.intensive.template.repository.entity;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class PurchasesPrimaryKeyClass implements Serializable{
    @PrimaryKeyColumn(name = "id_order", type = PrimaryKeyType.PARTITIONED)
    private String id;
    
    @PrimaryKeyColumn(name = "id_product", type = PrimaryKeyType.PARTITIONED)
    private String productId;    

    public PurchasesPrimaryKeyClass() {
    }

    public PurchasesPrimaryKeyClass(String id, String productId) {
        this.id = id;
        this.productId = productId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object arg0) {
        // TODO Auto-generated method stub
        return super.equals(arg0);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}
