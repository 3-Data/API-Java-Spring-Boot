package com.data.apidata.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.data.apidata.repository.*;
import com.data.apidata.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByDocument(String document) {
        return customerRepository.findByDocument(document);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomerByDocument(String document, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findByDocument(document);
        if (existingCustomer != null) {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            // Atualizar outros campos necessários

            return customerRepository.save(existingCustomer);
        } else {
            return null;
        }
    }

    public boolean deleteCustomerByDocument(String document) {
        Customer existingCustomer = customerRepository.findByDocument(document);
        if (existingCustomer != null) {
            customerRepository.delete(existingCustomer);
            return true;
        } else {
            return false;
        }
    }
}
