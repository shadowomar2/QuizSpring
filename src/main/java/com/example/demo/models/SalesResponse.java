package com.example.demo.models;

 
import java.time.LocalDateTime;
import java.util.Set;

import com.example.demo.entities.Clients;

public class SalesResponse {
    private long id;
    private Clients client;
    private String seller;
    private Set<ProductResponse> products;
    private LocalDateTime creationDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Clients getClient() {
		return client;
	}
	public void setClient(Clients client) {
		this.client = client;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Set<ProductResponse> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductResponse> products) {
		this.products = products;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public SalesResponse(long id, Clients client, String seller, Set<ProductResponse> products, LocalDateTime creationDate) {
		super();
		this.id = id;
		this.client = client;
		this.seller = seller;
		this.products = products;
		this.creationDate = creationDate;
	}
	public SalesResponse() {
		super();
	}
	@Override
	public String toString() {
		return "SalesResponse [id=" + id + ", client=" + client + ", seller=" + seller + ", products=" + products
				+ ", creationDate=" + creationDate + "]";
	}

 
}