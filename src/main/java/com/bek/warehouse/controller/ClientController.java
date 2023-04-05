package com.bek.warehouse.controller;

import com.bek.warehouse.entity.Client;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public Result addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @GetMapping
    public Result getAllClient() {
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public Result getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @PutMapping("/{id}")
    public Result editClient(@PathVariable Integer id, @RequestBody Client client) {
        return clientService.editClient(id, client);
    }

    @DeleteMapping("/{id}")
    public Result deleteClient(@PathVariable Integer id) {
        return clientService.deleteClient(id);
    }

}
