package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.models.ProductRequest;
import com.example.demo.models.ProductResponse;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	private ProductsRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return mapProductsToResponse(products);
	}

	public ProductResponse getProductById(long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional.isPresent()) {
		return mapProductToResponse(productOptional.get());
		}
		else {
			throw new IllegalArgumentException("Product with ID " + id + " not found");
		}
	}

	public ProductResponse createProduct(ProductRequest productRequest) {
		Category category = categoryRepository.findById(productRequest.getCategoryId())
				.orElseThrow(() -> new IllegalArgumentException(
						"Category with ID " + productRequest.getCategoryId() + " not found"));

		Product product = new Product();
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		product.setCategory(category);

		Product savedProduct = productRepository.save(product);
		return mapProductToResponse(savedProduct);
	}

	public ProductResponse updateProduct(long id, ProductRequest updatedProductRequest) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Product with ID " + id + " not found"));

		Category category = categoryRepository.findById(updatedProductRequest.getCategoryId())
				.orElseThrow(() -> new IllegalArgumentException(
						"Category with ID " + updatedProductRequest.getCategoryId() + " not found"));

		existingProduct.setName(updatedProductRequest.getName());
		existingProduct.setDescription(updatedProductRequest.getDescription());
		existingProduct.setPrice(updatedProductRequest.getPrice());
		existingProduct.setCategory(category);

		Product updatedProduct = productRepository.save(existingProduct);
		return mapProductToResponse(updatedProduct);
	}

	public void deleteProduct(long id) {
		Optional<Product> Optional = productRepository.findById(id);

		if (Optional.isPresent()) {
			productRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Product with ID " + id + " not found");
		}
	}

	private List<ProductResponse> mapProductsToResponse(List<Product> products) {
		return products.stream().map(this::mapProductToResponse).toList();
	}

	private ProductResponse mapProductToResponse(Product product) {
		ProductResponse response = new ProductResponse();
		response.setId(product.getId());
		response.setName(product.getName());
		response.setDescription(product.getDescription());
		response.setPrice(product.getPrice());
		response.setCategory(product.getCategory());
		response.setCreationDate(product.getCreationdate());
		return response;
	}
	
	  public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }
	  
	  
	   public void deleteCategory(long id) {
	       
	    	Optional<Category> Optional =  categoryRepository.findById(id);

			if (Optional.isPresent()) {
				categoryRepository.deleteById(id);
			} else {
				throw new IllegalArgumentException("Product with ID " + id + " not found");
			}
	    }
	   public List<Category> getAllCategories() {
	        return categoryRepository.findAll();
	    }
}
