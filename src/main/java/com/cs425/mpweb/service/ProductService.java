package com.cs425.mpweb.service;


import com.cs425.mpweb.model.Product;

import java.util.List;

public interface ProductService {
	 List<Product> findAll();
	Product save(Product student);
	Product findOne(Long id);
	 void delete(Long id);
}
