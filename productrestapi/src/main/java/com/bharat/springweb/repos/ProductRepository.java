package com.bharat.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharat.springweb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}