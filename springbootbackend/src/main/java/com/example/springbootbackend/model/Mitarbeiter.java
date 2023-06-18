package com.example.springbootbackend.model;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="mitarbeiter")
public class Mitarbeiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String Position;
    @Column(name = "letzte_verkauf")
    private String letzteVerkauf;

    
    
}
