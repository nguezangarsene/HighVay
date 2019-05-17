package com.cs425.mpweb.repository;

import com.cs425.mpweb.model.Product;
import com.cs425.mpweb.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("supplierRepository")
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
