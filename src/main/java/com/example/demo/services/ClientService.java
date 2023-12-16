package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Clients;
 
import com.example.demo.models.ClientsRequest;
import com.example.demo.models.ClientsResponse;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
    private ClientRepository ClientRepository;

    public List<ClientsResponse> getAllClients() {
        List<Clients> Clients = ClientRepository.findAll();
        return mapClientsToResponse(Clients);
    }

    public  ClientsResponse  getClientById(long id) {
        
		Optional<Clients> Optional = ClientRepository.findById(id);

		if (Optional.isPresent()) {
			 return mapClientToResponse(Optional.get());
		} else {
			throw new IllegalArgumentException("Client with ID " + id + " not found");
		}
    }

    public ClientsResponse createClient(ClientsRequest ClientRequest) {
        Clients Client = new Clients();
        Client.setName(ClientRequest.getName());
        Client.setLastname(ClientRequest.getLastname());
        Client.setMobile(ClientRequest.getMobile());

        Clients savedClient = ClientRepository.save(Client);
        return mapClientToResponse(savedClient);
    }

    public ClientsResponse updateClient(long id, ClientsRequest updatedClientRequest) {
        Clients existingClient = ClientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client with ID " + id + " not found"));

        existingClient.setName(updatedClientRequest.getName());
        existingClient.setLastname(updatedClientRequest.getLastname());
        existingClient.setMobile(updatedClientRequest.getMobile());

        Clients updatedClient = ClientRepository.save(existingClient);
        return mapClientToResponse(updatedClient);
    }

    public void deleteClient(long id) {
       
		Optional<Clients> Optional = ClientRepository.findById(id);

		if (Optional.isPresent()) {
			 ClientRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Client with ID " + id + " not found");
		}
    }

    private List<ClientsResponse> mapClientsToResponse(List<Clients> Clients) {
        return Clients.stream()
                .map(this::mapClientToResponse)
                .toList();
    }

    private ClientsResponse mapClientToResponse(Clients Client) {
        ClientsResponse response = new ClientsResponse();
        response.setId(Client.getId());
        response.setName(Client.getName());
        response.setLastname(Client.getLastname());
        response.setMobile(Client.getMobile());
        return response;
    }
	
}
