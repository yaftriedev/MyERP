package com.example.myerp.dto;

import com.example.myerp.model.Client;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClientCreateDTO {
    private String name;
    private String email;

    public static ClientCreateDTO fromEntity(Client client) {
        return new ClientCreateDTO(
            client.getName(),
            client.getEmail()
        );
    }

}