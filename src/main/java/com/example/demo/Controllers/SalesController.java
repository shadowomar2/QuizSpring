package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.SalesRequest;
import com.example.demo.models.SalesResponse;
import com.example.demo.services.SalesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping
    public List<SalesResponse> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/{id}")
    public  SalesResponse getSalesById(@PathVariable long id) {
        return salesService.getSalesById(id);
    }

    @PostMapping
    public SalesResponse createSales(@RequestBody SalesRequest salesRequest) {
        return salesService.createSales(salesRequest);
    }

    @PutMapping("/{id}")
    public SalesResponse updateSales(@PathVariable long id, @RequestBody SalesRequest updatedSalesRequest) {
        return salesService.updateSales(id, updatedSalesRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteSales(@PathVariable long id) {
        salesService.deleteSales(id);
    }
}
