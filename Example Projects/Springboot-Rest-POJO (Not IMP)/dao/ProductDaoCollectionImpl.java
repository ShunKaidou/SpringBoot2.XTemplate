package com.demo.springboot_rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.springboot_rest.pojo.ProductPojo;

//@Component
@Repository
public class ProductDaoCollectionImpl {
	private List<ProductPojo> dataStore;

	public ProductDaoCollectionImpl() {
		dataStore = new ArrayList<>();
		dataStore.add(new ProductPojo(101,"Laptop", 40000, ""));
		dataStore.add(new ProductPojo(102,"Mobile", 50000, ""));
		dataStore.add(new ProductPojo(103,"Tablet", 20000, ""));
	}
	
	public List<ProductPojo> fetchAllProducts(){
		return dataStore;
	}
	
	public ProductPojo fetchAProduct(int productId) {
		ProductPojo fetchedProduct = null;
		for(ProductPojo eachProduct: dataStore) {
			if(eachProduct.getProductId() == productId) {
				fetchedProduct = eachProduct;
				break;
			}
		}
		return fetchedProduct;
	}
	
	public void deleteProduct(int productId) {
		dataStore  = dataStore
						.stream()
						.filter(eachProduct->eachProduct.getProductId()!=productId)
						.toList();
	}
	
	public ProductPojo addProduct(ProductPojo newProduct) {
		int newProductId = dataStore.get(dataStore.size() - 1).getProductId() + 1;
		newProduct.setProductId(newProductId);
		dataStore.add(newProduct);
		return newProduct;
	}
	
	public ProductPojo updateProduct(ProductPojo editProduct) {
		for(int i=0;i<dataStore.size();i++) {
			if(dataStore.get(i).getProductId() == editProduct.getProductId()) {
				dataStore.set(i, editProduct);
				break;
			}
		}
		return editProduct;
	}
}