package com.productmanagementwithjpa.controller;

import com.productmanagementwithjpa.entity.Product;
import com.productmanagementwithjpa.entity.ProductRequest;
import com.productmanagementwithjpa.repository.ProductRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String displayProducts(Model model) {
        model.addAttribute("products", this.productRepository.findAll());
        System.out.println(this.productRepository.findAll());
        return "all-products";
    }

    @GetMapping("/create")
    public String displayAddProductPage() {
        return "add-product";
    }

    @PostMapping("/create-product")
    public String handleCreateProduct(ProductRequest productRequest) {
        Product productToCreate = new Product();

        //transfer information from request to entity
        productToCreate.setName(productRequest.getName());
        productToCreate.setPrice(productRequest.getPrice());
        productToCreate.setQuantity(productRequest.getQuantity());
        productToCreate.setImageUrl(productRequest.getImageUrl());

        this.productRepository.save(productToCreate);
        //do stuff with the product here
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable Long id, Model model) {
        // Redirect to the product details page with the given product ID
        Product current = this.productRepository.findProductById(id);
        model.addAttribute("product", current);
        return "product-details";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.productRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/product/edit/{id}")
    public String displayEditProductPage(@PathVariable Long id, Model model) {
        Product product = this.productRepository.findById(id).orElse(null);
        if (product == null) {
            // Handle the case when the product is not found
            return "redirect:/";
        }
        model.addAttribute("product", product);
        return "edit-product";
    }

    @PostMapping("/product/edit/{id}")
    public String handleEditProduct(@PathVariable("id") Long id, ProductRequest productRequest) {
        Product existingProduct = this.productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            // Handle the case when the product is not found
            return "redirect:/";
        }else{

        // Update the existing product with the new information
        existingProduct.setName(productRequest.getName());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setQuantity(productRequest.getQuantity());
        existingProduct.setImageUrl(productRequest.getImageUrl());

        this.productRepository.save(existingProduct);
        return "all-products";}
    }



}
