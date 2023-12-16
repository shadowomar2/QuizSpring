package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.ClientsResponse;
import com.example.demo.models.ClientsRequest;

import com.example.demo.services.ClientService;

import java.util.List;
 

@RestController
@RequestMapping("/Clientss")
public class ClientsController {

    @Autowired
    private ClientService ClientsService;

    @GetMapping
    public List<ClientsResponse> getAllClientss() {
        return ClientsService.getAllClients();
    }

    @GetMapping("/{id}")
    public  ClientsResponse getClientsById(@PathVariable long id) {
        return ClientsService.getClientById(id);
    }

    @PostMapping
    public ClientsResponse createClients(@RequestBody ClientsRequest ClientsRequest) {
        return ClientsService.createClient(ClientsRequest);
    }

    @PutMapping("/{id}")
    public ClientsResponse updateClients(@PathVariable long id, @RequestBody ClientsRequest updatedClientsRequest) {
        return ClientsService.updateClient(id, updatedClientsRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteClients(@PathVariable long id) {
        ClientsService.deleteClient(id);
    }
}
