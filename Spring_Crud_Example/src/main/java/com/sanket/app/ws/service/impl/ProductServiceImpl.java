package com.sanket.app.ws.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanket.app.ws.Entity.Products;
import com.sanket.app.ws.Exceptions.ResourceNotFoundException;
import com.sanket.app.ws.Repository.ProductRepository;
import com.sanket.app.ws.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	int ctr = 0;
	
	@Override
	public Products createProduct(Products product) {
//		if(product.getCreatedAt() == null && product.getUpdatedAt() == null) {
		product.setId(ctr);
		product.setCreatedAt(Instant.now());
		product.setUpdatedAt(Instant.now());
//		}
		ctr++;
		return productRepository.save(product);
	}
	
	@Override
	public Products updateProduct(Products product) {
		Optional<Products> productDb = this.productRepository.findById(product.getId());
		
		if(productDb.isPresent()) {
			Products productUpdate = productDb.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			productRepository.save(productUpdate);
			return productUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id :: " + product.getId());
		}
	}
	
	@Override
	public List<Products> getAllProduct(){
		return this.productRepository.findAll();
	}
	
	@Override
	public Products getProductById(long productId) {
		Optional<Products> productDb = this.productRepository.findById(productId);
		
		if(productDb.isPresent()) {
			return productDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id :: " + productId);
		}
	}
	
	@Override
	public void deleteProduct(long productId) {
		Optional<Products> productDb = this.productRepository.findById(productId);
		
		if(productDb.isPresent()) {
			this.productRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id :: " + productId);
		}
	}

}
