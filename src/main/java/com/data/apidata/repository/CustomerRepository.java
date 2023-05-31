package com.data.apidata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.apidata.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Customer findByDocument(String document);
}
