package com.productmanagementwithjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    String name;
    Double price;
    Double quantity;
    String imageUrl;
}
