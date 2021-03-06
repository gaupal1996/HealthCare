package com.bharat.springweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bharat.springweb.entity.Product;
import com.bharat.springweb.repos.ProductRepository;

@RestController
public class ProductRestController {

	@Autowired
	ProductRepository repo;

	 @RequestMapping(value="/product/",method=RequestMethod.GET)
	//@GetMapping("/products/")
	public List<Product> getProduct() {
		return repo.findAll();
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {

		return repo.findById(id).get();

	}

	@PostMapping("/product/")
	public Product createProduct(Product product) {
		
		return repo.save(product);

	}
	
	@PutMapping("/product/")
	public Product updateProduct(Product product) {
		
		return repo.save(product); 
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {

		 repo.deleteById(id);
	}
	
}
