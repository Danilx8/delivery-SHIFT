package ru.cft.shift.intensive.template.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.repository.entity.Purchases;

import java.util.Collection;
import java.util.List;

public interface PurchasesRepository extends CassandraRepository<Purchases, String>{ //временно обозначил тип значения как Integer
    List<Purchases> FindAllBySession(String id);

    Collection<Purchases> FindBySession(String randomAlphabetic);
}
