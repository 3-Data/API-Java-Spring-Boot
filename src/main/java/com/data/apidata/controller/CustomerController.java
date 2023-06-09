package com.data.apidata.controller;

import java.util.List;
import com.data.apidata.model.*;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.data.apidata.services.*;
import com.data.apidata.repository.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

import com.data.apidata.model.Customer;
import com.data.apidata.repository.CustomerRepository;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@ResponseBody
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{document}")
    public ResponseEntity<Customer> getCustomerByDocument(@PathVariable String document) {
        Customer customer = customerService.getCustomerByDocument(document);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/{document}")
    public ResponseEntity<Customer> updateCustomerByDocument(@PathVariable String document, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomerByDocument(document, customer);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{document}")
    public ResponseEntity<Void> deleteCustomerByDocument(@PathVariable String document) {
        boolean deleted = customerService.deleteCustomerByDocument(document);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
