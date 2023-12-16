package com.example.demo.entities;

 

 
 
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
	@Column(length = 60)
	private String name;
	 
	private long price;
	@Lob
	@Column(length = 512)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	private LocalDateTime creationdate;

	
	
	public long getPrice() {
		return price;
	}



	public void setPrice(long price) {
		this.price = price;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public LocalDateTime getCreationdate() {
		return creationdate;
	}



	public void setCreationdate(LocalDateTime creationdate) {
		this.creationdate = creationdate;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", category=" + category + ", creationdate=" + creationdate + "]";
	}



	public Product(long id, String name, long price, String description, Category category ) {
		 
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.creationdate = LocalDateTime.now();
	}



	public Product() {
		this.creationdate = LocalDateTime.now();
	}



 



	 
	
	
}
