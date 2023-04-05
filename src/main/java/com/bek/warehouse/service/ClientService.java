package com.bek.warehouse.service;

import com.bek.warehouse.entity.Client;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Result addClient(Client client) {
        if ((clientRepository.existsByPhoneNumber(client.getPhoneNumber())) && (client.getPhoneNumber() == null)) {
            return new Result("Phone number is already exist or empty", false);
        }
        Client savedClient = clientRepository.save(client);
        return new Result("Saved!!!", true, savedClient);
    }

    public Result getAllClient() {
        return new Result("All client", true, clientRepository.findAll());
    }

    public Result getClientById(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
//        return optionalClient.isPresent()?new Result("Client by id",true,optionalClient.get()):new Result("Client not found",false);
        return optionalClient.map(client -> new Result("Client by id", true, client)).orElseGet(() -> new Result("Client not found", false));
    }

    public Result editClient(Integer id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client editingClient = optionalClient.get();
            if ((editingClient.getPhoneNumber().equals(client.getPhoneNumber())) && client.getPhoneNumber() == null) {
                editingClient.setName(client.getName());
                editingClient.setActive(client.isActive());
            } else {
                editingClient.setName(client.getName());
                editingClient.setActive(client.isActive());
                editingClient.setPhoneNumber(client.getPhoneNumber());
            }
            Client editedClient = clientRepository.save(editingClient);
            return new Result("Edited", true, editedClient);
        }
        return new Result("Not Edited", false);
    }

    public Result deleteClient(Integer id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return new Result("Deleted ", true);
        }
        return new Result("Client not found", false);
    }
}

