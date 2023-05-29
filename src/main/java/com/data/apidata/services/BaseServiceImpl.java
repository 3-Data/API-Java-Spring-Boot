package com.data.apidata.services;

import com.data.apidata.model.Category;
import com.data.apidata.model.Cliente;
import com.data.apidata.model.ProductImage;
import com.data.apidata.model.Supplier;
import com.data.apidata.repository.CategoryRepository;
import com.data.apidata.repository.ClienteRepository;
import com.data.apidata.repository.ProductImageRepository;
import com.data.apidata.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CategoryRepository categoriesRepository;
    @Override
    public Supplier findSupplierById(Long idSupplier) {
        return supplierRepository
                .findById(idSupplier)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado!"));
    }

    @Override
    public Cliente findClientById (Long idClient) {
        return clienteRepository
                .findById(idClient)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }
    @Override
    public List<Category> findCategoriesByIdsList (List<Long> categories) {
        return categoriesRepository
                .findAllByIdIn(categories);
    }
}
