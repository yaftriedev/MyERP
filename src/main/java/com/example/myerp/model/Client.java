package com.example.myerp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="client_sequence")
    @SequenceGenerator(name="client_sequence", sequenceName="client_sequence", allocationSize=100)
    private Long id;
    
    private String name;

    private String email;

}