package com.finalproject.consumerservice.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;
import com.finalproject.consumerservice.model.Product;

@Component
public class ProdcutKafkaListener {

	private final Logger log = LoggerFactory.getLogger(ProdcutKafkaListener.class);


	  @KafkaListener(topics = "addcart")  
       public void consume(Product product) 
      {  
		  log.info("customer   added " + product.getProduct_id()+  " : " + product.getProduct_name() + " to cart"); 
      } 

}
