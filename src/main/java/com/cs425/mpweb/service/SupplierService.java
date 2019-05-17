package com.cs425.mpweb.service;



import com.cs425.mpweb.model.Supplier;

import java.util.List;

public interface SupplierService {
	 List<Supplier> findAll();
	Supplier save(Supplier student);
	Supplier findOne(int id);
	 void delete(int id);
}
