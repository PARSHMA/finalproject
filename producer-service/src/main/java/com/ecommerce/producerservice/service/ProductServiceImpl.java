package com.ecommerce.producerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ecommerce.producerservice.model.Product;
import com.ecommerce.producerservice.repositry.ProductRepositry;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	    @Autowired
	    private ProductRepositry productRepoistry;
	    
	    @Autowired
	    private MongoTemplate mongoTemplate;
	    
	    @Autowired
	    private KafkaTemplate<String, Product> kafkaTemplate;

	    @Override
	    public String save(Product product) {
	        return productRepoistry.save(product).getProduct_id();
	    }  

	    @Override
	    public void delete(String id) {
	    	productRepoistry.deleteById(id);
	    }
	    
	    @Override
		public void findById(String id) {
	    	Product product = mongoTemplate.findOne(Query.query(Criteria.where("product_id").is(id)),
	    			Product.class, "product");
	        createEvent(product);
		}
	    
	    public void createEvent(Product product) {
	    	kafkaTemplate.send("addcart",product.getProduct_name() + " product added to cart" , product);
	    }
	    

}
