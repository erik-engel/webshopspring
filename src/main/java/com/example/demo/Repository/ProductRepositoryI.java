package com.example.demo.Repository;


import com.example.demo.Model.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepositoryI extends CrudRepository<Product, Integer> {
}
