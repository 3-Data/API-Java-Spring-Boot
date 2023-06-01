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

@RestController
@RequestMapping("/customer")
@ResponseBody
@AllArgsConstructor

public class CustomerController {

    @Autowired
    private CustomerRepository CustomerRepository;

    @GetMapping ("/customer")
    public List<Customer> getAllCustomers() {
        return CustomerRepository.findAll();

    }
/*-------------------CUSTOMER----------------------------------- */
private final CustomerService CustomerService;
    public CustomerController(CustomerService customerService) {
        this.CustomerService = customerService;
    }

    @GetMapping("/{document}")
    public ResponseEntity<?> findByDocument(@PathVariable String document) {
        Customer customer = CustomerService.findByDocument(document);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
/*-------------------CUSTOMER----------------------------------- */

    @PostMapping ("/customer")
    @ResponseStatus (HttpStatus.CREATED)    
    public Customer createCustomer(@RequestBody Customer customer){
        return CustomerRepository.save(customer);
    }


    @PutMapping("/{document}")
    public ResponseEntity<Customer> atualizarCustomerPorDocumento(@PathVariable String document, @RequestBody Customer customerAtualizado) {
        Customer customerExistente = CustomerService.findByDocument(document);
        if (customerExistente != null) {
            // Atualizar os campos do cliente existente com os dados atualizado
            customerExistente.setName(customerAtualizado.getName());
            customerExistente.setEmail(customerAtualizado.getEmail());

            // Chamar o método do serviço para salvar as alterações
            CustomerService.updateCustomer(customerExistente);

            return ResponseEntity.ok(customerExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{document}")
    public ResponseEntity<?> deleteByDocument(@PathVariable String document) {
        boolean excluido = CustomerService.deleteByDocument(document);
        if (excluido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}