package com.cs425.mpweb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//unidirectional solution
@Entity
@Table(name="PRODUCTS")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pid;
	@Column(nullable = false)
	@NotNull(message = "Product Number should not be null")
	private Long productNumber;
	@Column(nullable = false)
	@NotNull(message = "Product Name should not be null")
	private String name;
	@Column(nullable = false)
	@NotNull(message = "Product Unit Price should not be null")
	private Float unitPrice;
	@Column(nullable = false)
	@NotNull(message = "Manufacture Date should not be null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateMfd;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sup_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Supplier supplier;
	@Transient
	private int idsup;
	@Transient
	private String name_supplier;
	
	
	
	public Product() {
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Long getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Long productNumber) {
		this.productNumber = productNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public LocalDate getDateMfd() {
		return dateMfd;
	}
	public void setDateMfd(LocalDate dateMfd) {
		this.dateMfd = dateMfd;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getIdsup() {
		return idsup;
	}

	public void setIdsup(int idsup) {
		this.idsup = idsup;
	}

	public String getName_supplier() {
		return name_supplier;
	}

	public void setName_supplier(String name_supplier) {
		this.name_supplier = name_supplier;
	}
}
