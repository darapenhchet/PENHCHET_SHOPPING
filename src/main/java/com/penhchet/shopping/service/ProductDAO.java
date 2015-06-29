package com.penhchet.shopping.service;

import java.util.List;

import com.penhchet.shopping.model.Product;

public interface ProductDAO {

	public List<Product> selectAllProducts();
	
	public boolean registerNewProduct(Product product);
	
}
