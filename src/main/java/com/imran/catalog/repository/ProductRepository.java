package com.imran.catalog.repository;

import com.imran.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Fetch all products of a specific category
    List<Product> findByCategoryIgnoreCase(String category);

    @org.springframework.data.jpa.repository.Query("SELECT DISTINCT p.category FROM Product p ORDER BY p.category")
    List<String> findDistinctCategories();
}
