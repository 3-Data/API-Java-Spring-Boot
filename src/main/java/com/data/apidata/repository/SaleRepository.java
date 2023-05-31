package com.data.apidata.repository;

import com.data.apidata.model.Product;
import com.data.apidata.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findBySupplierId(Long idSupplier);
    List<Sale> findByClientId(Long idClient);
}
