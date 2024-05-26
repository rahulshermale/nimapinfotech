package com.example.nimap_infotech_task.Entity;



import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true) 
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,fetch = FetchType.LAZY)//, fetch = FetchType.LAZY
//    @JsonManagedReference
//    @JsonBackReference
    @JsonIgnoreProperties("category")
    private Set<Product> products;

    
    
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Category(Long id, String name, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}
	
	public Category() {
		super();
		
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
	

   
}
