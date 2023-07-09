package ru.cft.shift.intensive.template.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import ru.cft.shift.intensive.template.repository.entity.Products;

public interface ProductsRepository extends CassandraRepository<Products, String> { //временно обозначил тип значения как Integer
    Products findByName(String name);
}
