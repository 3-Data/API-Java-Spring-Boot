package com.data.apidata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.data.apidata.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByDocument(String document);
}
