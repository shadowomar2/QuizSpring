package com.example.demo.models;

 
import java.time.LocalDateTime;

import com.example.demo.entities.Category;

public class ProductResponse {
    private long id;
    private String name;
    private String description;
    private long price;
    private Category category;
    private LocalDateTime creationDate;
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public ProductResponse(long id, String name, String description, long price, Category category, LocalDateTime creationDate) {
		 
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.creationDate = creationDate;
	}
	public ProductResponse() {
	 
	}
    
    
}
