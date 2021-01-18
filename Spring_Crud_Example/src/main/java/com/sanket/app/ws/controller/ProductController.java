package com.sanket.app.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.app.ws.Entity.Products;
import com.sanket.app.ws.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Products>> getAllProduct(){
		return ResponseEntity.ok().body(productService.getAllProduct());		
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Products> getProductById(@PathVariable long id){
		return ResponseEntity.ok().body(productService.getProductById(id));		
	}
	
	@PostMapping("/products")
	public ResponseEntity<Products> createProduct(@RequestBody Products product){
		return ResponseEntity.ok().body(this.productService.createProduct(product));		
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Products> updateProduct(@PathVariable long id, @RequestBody Products product){
		product.setId(id);
		return ResponseEntity.ok().body(this.productService.updateProduct(product));		
	}
	
	@DeleteMapping("/products/{id}")
	public HttpStatus deleteProduct(@PathVariable long id){
		this.productService.deleteProduct(id);
		return HttpStatus.OK;		
	}

}
