package com.example.demo.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
 
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "client_id")
	private Clients client;
	@Column(length = 60)
	private String seller;
	@OneToMany(  cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Product> Products = new HashSet<>();
	
	private LocalDateTime creationdate;

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

	public Set<Product> getProducts() {
		return Products;
	}

	public void setProducts(Set<Product> products) {
		Products = products;
	}

	public LocalDateTime getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(LocalDateTime creationdate) {
		this.creationdate = creationdate;
	}

	@Override
	public String toString() {
		return "Sales [id=" + id + ", client=" + client + ", seller=" + seller + ", Products=" + Products
				+ ", creationdate=" + creationdate + "]";
	}

	public Sales(long id, Clients client, String seller, Set<Product> products ) {
		super();
		this.id = id;
		this.client = client;
		this.seller = seller;
		Products = products;
		this.creationdate = LocalDateTime.now();
	}

	public Sales() {
		this.creationdate = LocalDateTime.now();
	}
	
	
	
}
