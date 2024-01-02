package com.ecommerce.producerservice.service;

import com.ecommerce.producerservice.model.Product;

public interface ProductService {
	
	public String save(Product product);
	
	public void delete(String id);
	
	public void findById(String id);

}
