package com.productmanagementwithjpa.repository;

import com.productmanagementwithjpa.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
