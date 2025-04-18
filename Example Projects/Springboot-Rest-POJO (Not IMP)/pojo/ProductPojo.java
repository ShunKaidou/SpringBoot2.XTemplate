package com.demo.springboot_rest.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class ProductPojo {
	private int productId;
	private String productName;
	private int productCost;
	private String productImageUrl;
	
	public ProductPojo(int productId, String productName, int productCost, String productImageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.productImageUrl = productImageUrl;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	
	
}
