package ru.cft.shift.intensive.template.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.repository.entity.Purchases;
import ru.cft.shift.intensive.template.repository.entity.PurchasesPrimaryKeyClass;

import java.util.Collection;
import java.util.List;

@Repository
public interface PurchasesRepository extends CassandraRepository<Purchases, ru.cft.shift.intensive.template.repository.entity.PurchasesPrimaryKeyClass>{
    // List<Purchases> findAllBySession(String id);

    // Collection<Purchases> findBySession(String randomAlphabetic);
}
