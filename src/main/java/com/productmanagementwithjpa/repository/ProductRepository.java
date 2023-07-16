package com.productmanagementwithjpa.repository;

import com.productmanagementwithjpa.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
//public List<Product> getAllBy();

//public List<Product> findProductByNameLike(String name);

//public List<Product> findProductByPriceBetween(double start, double end);
}
