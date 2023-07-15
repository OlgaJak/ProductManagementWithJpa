package com.productmanagementwithjpa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    private Double quantity;
    private String imageUrl;

    private Timestamp createdAt;


    @PrePersist
    public void beforeSave(){
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}
