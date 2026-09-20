package com.example.myerp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myerp.dto.ClientDTO;
import com.example.myerp.error.ErrorException;
import com.example.myerp.model.Client;
import com.example.myerp.dto.ClientCreateDTO;
import com.example.myerp.repository.ClientRepository;

@Service
public class ClientService {
    
    private ClientRepository clientRepository;

    public ClientService( ClientRepository clientRepository ) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO createClient( ClientCreateDTO clientCreateDTO ) {
        
        String name = clientCreateDTO.getName();
        String email = clientCreateDTO.getEmail();
        
        if (name == null || name.isBlank()) {
            throw new ErrorException("El nombre es obligatorio");
        }

        if (name.length() < 2 || name.length() > 100) {
            throw new ErrorException(
                "El nombre debe tener entre 2 y 100 caracteres"
            );
        }

        if (email == null || email.isBlank()) {
            throw new ErrorException("El email es obligatorio");
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new ErrorException("El email no es válido");
        }

        if (email.length() > 255) {
            throw new ErrorException(
                "El email no puede superar los 255 caracteres"
            );
        }

        Client client = new Client();
        client.setName(name);
        client.setEmail(email);

        clientRepository.save(client);

        return ClientDTO.fromEntity(client);
    }

    public ClientDTO getClientById(Long id) {

        return ClientDTO.fromEntity(
            clientRepository.findById(id)
                .orElseThrow(() -> new ErrorException("No existe un client con ese ID"))
        );

    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
            .stream()
            .map(ClientDTO::fromEntity)
            .toList();
    }

}
