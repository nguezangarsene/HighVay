package com.cs425.mpweb.service.impl;

import com.cs425.mpweb.model.Product;
import com.cs425.mpweb.repository.ProductRepository;
import com.cs425.mpweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product save(Product student) {
		return productRepository.save(student);
	}

	@Override
	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		productRepository.delete(id);
	}

}
