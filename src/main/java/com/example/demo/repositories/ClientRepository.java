package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Clients;
 
public interface ClientRepository  extends JpaRepository<Clients, Long>{

}
