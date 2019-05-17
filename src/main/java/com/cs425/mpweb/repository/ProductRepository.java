package com.cs425.mpweb.repository;

import com.cs425.mpweb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("studentRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {
}
