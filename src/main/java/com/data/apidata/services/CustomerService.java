package com.data.apidata.services;

import org.springframework.stereotype.Service;
import com.data.apidata.repository.*;
import com.data.apidata.model.*;



@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findByDocument (String document) {
        return customerRepository.findByDocument(document);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public boolean deleteByDocument(String document) {
        Customer customer = customerRepository.findByDocument(document);
        if (customer != null) {
            customerRepository.delete(customer);
            return true;
        } else {
            return false;
        }
    }

}
