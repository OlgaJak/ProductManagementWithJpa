package com.productmanagementwithjpa.controller;

import com.productmanagementwithjpa.entity.ProductRequest;
import com.productmanagementwithjpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private ProductRepository productRepository;
    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @GetMapping("/")
    public String displayProducts(){
        return "all-product";
    }
    @GetMapping("/create")
    public String displayAddProductPage(){
        return "add-product";
    }

    @PostMapping("/create-product")
    public String handleCreateProduct(ProductRequest productRequest){
        //do stuff with the product here
        return "redirect:/";
    }
}
