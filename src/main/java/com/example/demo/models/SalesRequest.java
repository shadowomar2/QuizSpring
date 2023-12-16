package com.example.demo.models;

import java.util.Set;

public class SalesRequest  {
    private long clientId;
    private String seller;
    private Set<Long> productIds;
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Set<Long> getProductIds() {
		return productIds;
	}
	public void setProductIds(Set<Long> productIds) {
		this.productIds = productIds;
	}
	public SalesRequest(long clientId, String seller, Set<Long> productIds) {
		super();
		this.clientId = clientId;
		this.seller = seller;
		this.productIds = productIds;
	}
	public SalesRequest() {
		super();
	}
	@Override
	public String toString() {
		return "SalesRequest [clientId=" + clientId + ", seller=" + seller + ", productIds=" + productIds + "]";
	}
    
    
}
