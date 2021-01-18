package com.sanket.app.ws.service;

import java.util.List;

import com.sanket.app.ws.Entity.Products;

public interface ProductService {

	Products createProduct(Products product);
	
	Products updateProduct(Products product);
	
	List<Products> getAllProduct();
	
	Products getProductById(long productId);
	
	void deleteProduct(long id);
	
}
