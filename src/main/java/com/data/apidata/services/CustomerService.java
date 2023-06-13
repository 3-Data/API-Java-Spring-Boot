package com.data.apidata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.data.apidata.model.Customer;
import com.data.apidata.repository.CustomerRepository;

import lombok.Getter;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomersByDocument(String document) {
        return customerRepository.findByDocument(document);
    }
}
