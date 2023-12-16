package com.example.demo.models;

public class ProductRequest {
	  private String name;
	    private String description;
	    private long price;
	    private long categoryId;
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
		public long getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(long categoryId) {
			this.categoryId = categoryId;
		}
		public ProductRequest(String name, String description, long price, long categoryId) {
			super();
			this.name = name;
			this.description = description;
			this.price = price;
			this.categoryId = categoryId;
		}
	    
}
