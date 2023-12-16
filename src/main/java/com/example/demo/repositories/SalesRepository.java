package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

 
import com.example.demo.entities.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long>{

}
