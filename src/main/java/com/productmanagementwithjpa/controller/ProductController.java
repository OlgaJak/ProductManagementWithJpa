package com.productmanagementwithjpa.controller;

import com.productmanagementwithjpa.entity.Product;
import com.productmanagementwithjpa.entity.ProductRequest;
import com.productmanagementwithjpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String displayProducts(Model model){
        model.addAttribute("products",this.productRepository.findAll());
        System.out.println(this.productRepository.findAll());
        return "all-products";
    }
    @GetMapping("/create")
    public String displayAddProductPage(){
        return "add-product";
    }

    @PostMapping("/create-product")
    public String handleCreateProduct(ProductRequest productRequest){
        Product productToCreate = new Product();

        //transfer information from request to entity
        productToCreate.setName(productRequest.getName());
        productToCreate.setPrice(productToCreate.getPrice());
        productToCreate.setQuantity(productToCreate.getQuantity());
        productToCreate.setImageUrl(productRequest.getImageUrl());


        this.productRepository.save(productToCreate);
        //do stuff with the product here
        return "redirect:/";
    }
}
