package com.cs425.mpweb.service.impl;

import com.cs425.mpweb.model.Product;
import com.cs425.mpweb.model.Supplier;
import com.cs425.mpweb.repository.ProductRepository;
import com.cs425.mpweb.repository.SupplierRepository;
import com.cs425.mpweb.service.ProductService;
import com.cs425.mpweb.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierRepository supplierRepository;
	
	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier save(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier findOne(int id) {
		return supplierRepository.findOne(id);
	}

	@Override
	public void delete(int id) {
		supplierRepository.delete(id);
	}

}
