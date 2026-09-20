package com.example.myerp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myerp.dto.ClientCreateDTO;
import com.example.myerp.dto.ClientDTO;
import com.example.myerp.services.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/client")
public class ClientController {
    
    public ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(
            clientService.getAllClients()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(
            clientService.getClientById(id)
        );
    }
    
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientCreateDTO client) {
        return ResponseEntity.ok(
            clientService.createClient(client)
        );
    }
    


}
