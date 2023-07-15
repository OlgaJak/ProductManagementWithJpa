package com.productmanagementwithjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
