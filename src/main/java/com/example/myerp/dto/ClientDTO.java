package com.example.myerp.dto;

import com.example.myerp.model.Client;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClientDTO {
    private Long id;
    private String name;
    private String email;

    public static ClientDTO fromEntity(Client client) {
        return new ClientDTO(
            client.getId(),
            client.getName(),
            client.getEmail()
        );
    }

}
