package com.imran.catalog.service;

import com.imran.catalog.model.Product;
import com.imran.catalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public List<Product> findByCategory(String category) {
        return repository.findByCategoryIgnoreCase(category);
    }

    public List<String> categories() {
        return repository.findDistinctCategories();
    }
}
