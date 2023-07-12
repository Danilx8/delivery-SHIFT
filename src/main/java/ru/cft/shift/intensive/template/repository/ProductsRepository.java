package ru.cft.shift.intensive.template.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import ru.cft.shift.intensive.template.repository.entity.Products;

@Repository
public interface ProductsRepository extends CassandraRepository<Products, java.util.UUID> { 
    Products findByName(String name);
}
