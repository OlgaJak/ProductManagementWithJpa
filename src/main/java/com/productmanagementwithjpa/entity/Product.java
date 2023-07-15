package com.productmanagementwithjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    private Double quantity;
    private String imageUrl;

    private Timestamp createdAt;   //the date when it was created
    private Timestamp lastUpdated;

    public Product() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PrePersist
    public void beforeSave(){
        this.lastUpdated = new Timestamp(System.currentTimeMillis());  //it's just a date when you made the stuff
    }
}
