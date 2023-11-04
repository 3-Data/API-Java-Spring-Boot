package com.data.apidata.controller;

import com.data.apidata.DTOs.CustomerRequestDTO;
import com.data.apidata.model.Customer;
import com.data.apidata.model.Supplier;
import com.data.apidata.repository.CustomerRepository;
import com.data.apidata.services.CustomerService;

import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    CustomerRepository repository;

    @GetMapping("/customer")
    public List<Customer>getAllCustomer(){
        return repository.findAll();
    
    }

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody CustomerRequestDTO customerData){
        Customer customer = new Customer(customerData);

        return repository.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }

@GetMapping
public List<Customer> getCustomersByDocument(@RequestParam("document") String document) {
    return customerService.getCustomersByDocument(document);
}
}
