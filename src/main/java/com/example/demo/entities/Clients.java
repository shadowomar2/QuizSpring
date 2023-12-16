package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 

@Entity
public class Clients {
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 60)
	private String name;
	@Column(length = 60)
	private String lastname;
	private long mobile;
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Clients(long id, String name, String lastname, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.mobile = mobile;
	}
	public Clients() {
		super();
	}
	@Override
	public String toString() {
		return "Clients [id=" + id + ", name=" + name + ", lastname=" + lastname + ", mobile=" + mobile + "]";
	}
	
	
}
