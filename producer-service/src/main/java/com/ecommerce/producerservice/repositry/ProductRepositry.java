package com.ecommerce.producerservice.repositry;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.producerservice.model.Product;

@Repository
public interface ProductRepositry extends MongoRepository<Product, String> {

}

