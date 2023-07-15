package com.productmanagementwithjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @GetMapping("/")
    public String displayProducts(){
        return "all-product";
    }
    @GetMapping("/create")
    public String displayAddProductPage(){
        return "add-product";
    }

    @PostMapping("/create-product")
    public String handleCreateProduct(){
        //do stuff with the product here
        return "redirect:/";
    }
}
