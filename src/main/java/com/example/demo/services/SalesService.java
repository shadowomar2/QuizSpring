package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Clients;
import com.example.demo.entities.Product;
import com.example.demo.entities.Sales;
import com.example.demo.models.ProductResponse;
import com.example.demo.models.SalesRequest;
import com.example.demo.models.SalesResponse;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.ProductsRepository;
import com.example.demo.repositories.SalesRepository;

@Service
public class SalesService {
	@Autowired
	private SalesRepository salesRepository;

	@Autowired
	private ClientRepository clientsRepository;

	@Autowired
	private ProductsRepository productRepository;

	public List<SalesResponse> getAllSales() {
		List<Sales> sales = salesRepository.findAll();
		return mapSalesToResponse(sales);
	}

	public  SalesResponse  getSalesById(long id) {
		 
		Optional<Sales> Optional = salesRepository.findById(id);

		if (Optional.isPresent()) {
			return mapSalesToResponse(Optional.get());
		} else {
			throw new IllegalArgumentException("Sales with ID " + id + " not found");
		}
	}

	public SalesResponse createSales(SalesRequest salesRequest) {
		Clients client = clientsRepository.findById(salesRequest.getClientId()).orElseThrow(
				() -> new IllegalArgumentException("Client with ID " + salesRequest.getClientId() + " not found"));

		Sales sales = new Sales();
		sales.setClient(client);
		sales.setSeller(salesRequest.getSeller());
		sales.setProducts(mapProductIdsToEntities(salesRequest.getProductIds()));

		Sales savedSales = salesRepository.save(sales);
		return mapSalesToResponse(savedSales);
	}

	public SalesResponse updateSales(long id, SalesRequest updatedSalesRequest) {
		Sales existingSales = salesRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Sales with ID " + id + " not found"));

		Clients client = clientsRepository.findById(updatedSalesRequest.getClientId())
				.orElseThrow(() -> new IllegalArgumentException(
						"Client with ID " + updatedSalesRequest.getClientId() + " not found"));

		existingSales.setClient(client);
		existingSales.setSeller(updatedSalesRequest.getSeller());
		existingSales.setProducts(mapProductIdsToEntities(updatedSalesRequest.getProductIds()));

		Sales updatedSales = salesRepository.save(existingSales);
		return mapSalesToResponse(updatedSales);
	}

	public void deleteSales(long id) {

		Optional<Sales> Optional = salesRepository.findById(id);

		if (Optional.isPresent()) {
			salesRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Sales with ID " + id + " not found");
		}
	}

	private List<SalesResponse> mapSalesToResponse(List<Sales> sales) {
		return sales.stream().map(this::mapSalesToResponse).collect(Collectors.toList());
	}

	private SalesResponse mapSalesToResponse(Sales sales) {
		SalesResponse response = new SalesResponse();
		response.setId(sales.getId());
		response.setClient(sales.getClient());
		response.setSeller(sales.getSeller());
		response.setProducts(mapProductEntitiesToResponses(sales.getProducts()));
		response.setCreationDate(sales.getCreationdate());
		return response;
	}

	private Set<Product> mapProductIdsToEntities(Set<Long> productIds) {
		return productIds.stream().map(productRepository::findById).filter(Optional::isPresent).map(Optional::get)
				.collect(Collectors.toSet());
	}

	private Set<ProductResponse> mapProductEntitiesToResponses(Set<Product> products) {
		return products.stream().map(this::mapProductEntityToResponse).collect(Collectors.toSet());
	}

	private ProductResponse mapProductEntityToResponse(Product product) {
		ProductResponse response = new ProductResponse();
		response.setId(product.getId());
		response.setName(product.getName());
		response.setDescription(product.getDescription());
		response.setPrice(product.getPrice());
		response.setCategory(product.getCategory());
		response.setCreationDate(product.getCreationdate());
		return response;
	}
}
