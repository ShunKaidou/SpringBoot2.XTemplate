package com.demo.springboot_rest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot_rest.pojo.ProductPojo;
import com.demo.springboot_rest.service.ProductService;
@RestController
@RequestMapping("/api")
public class ProductController {
	
//	ProductService productService = new ProductService();
	
	@Autowired
	ProductService productService;

	// http://localhost:3030/api/products
	@GetMapping("/products")
	public List<ProductPojo> fetchAllProducts(){
		return productService.fetchAllProducts();
	}
	
	// http://localhost:3030/api/products/102
	@GetMapping("/products/{pid}")
	public ProductPojo fetchAProduct(@PathVariable("pid") int productId) {
		return productService.fetchAProduct(productId);
	}
	
	// http://localhost:3030/api/products/102
	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
	}
	
	// http://localhost:3030/api/products
	@PostMapping("/products")
	public ProductPojo addProduct(@RequestBody ProductPojo newProduct) {
		return productService.addProduct(newProduct);
	}
	
	// http://localhost:3030/api/products
	@PutMapping("/products")
	public ProductPojo updateProduct(@RequestBody ProductPojo editProduct) {
		return productService.updateProduct(editProduct);
	}
}
