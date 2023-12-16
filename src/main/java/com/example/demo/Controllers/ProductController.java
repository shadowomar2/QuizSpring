package com.example.demo.Controllers;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.models.ProductRequest;
import com.example.demo.models.ProductResponse;
import com.example.demo.services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductsService productService;

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public  ProductResponse  getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable long id, @RequestBody ProductRequest updatedProductRequest) {
        return productService.updateProduct(id, updatedProductRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }
    
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return productService.getAllCategories();
    }
    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category) {
        return productService.createCategory(category);
    }
    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable long id) {
    	productService.deleteCategory(id);
    }

}