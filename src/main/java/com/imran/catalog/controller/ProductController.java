package com.imran.catalog.controller;

import com.imran.catalog.model.Product;
import com.imran.catalog.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // Home page with two options: Add product / Display product
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/products/add")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/products/save")
    public String save(@ModelAttribute Product product) {
        service.save(product);
        return "redirect:/products?saved=true";
    }

    // Display all products, optionally filtered by category
    @GetMapping("/products")
    public String display(@RequestParam(required = false) String category, Model model) {
        boolean filtered = category != null && !category.isBlank();
        model.addAttribute("products", filtered ? service.findByCategory(category) : service.findAll());
        model.addAttribute("categories", service.categories());
        model.addAttribute("selectedCategory", filtered ? category : "");
        return "products";
    }
}
