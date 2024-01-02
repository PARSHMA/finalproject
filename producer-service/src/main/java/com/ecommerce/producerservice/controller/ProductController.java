package com.ecommerce.producerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.producerservice.model.Product;
import com.ecommerce.producerservice.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/save")
    public String addProduct (@RequestBody Product product){
        return productService.save(product);
    }

	@GetMapping("/{id}")
	public void findByid(@PathVariable String id) {
		productService.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		 productService.delete(id);
	    }
}
