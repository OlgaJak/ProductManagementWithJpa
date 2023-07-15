package com.productmanagementwithjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/")
    public String displayProducts(){
        return "all-products";
    }
}
