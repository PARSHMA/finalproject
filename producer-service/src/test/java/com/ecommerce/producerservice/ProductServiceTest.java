package com.ecommerce.producerservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ecommerce.producerservice.model.Product;

public class ProductServiceTest extends  AbstractTest{
	
	@Test
	public void createProduct() throws Exception {
	   String uri = "/save";
	   Product product = new Product();
	   product.setProduct_id("3");
	   product.setProduct_name("Ginger");
	   product.setProduct_price(34);
	   product.setProduct_quantity(12);
	   
	   String inputJson = super.mapToJson(product);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals(content, "Product is created successfully");
	}
	
	 @Test
	   public void deleteProduct() throws Exception {
	      String uri = "/delete/3";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Product is deleted successsfully");
	   }

}
