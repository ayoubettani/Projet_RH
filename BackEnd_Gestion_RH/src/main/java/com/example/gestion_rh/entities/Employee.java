package com.example.gestion_rh.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "first name should not be empty")
    private String firstName;

    @NotEmpty(message = "last name should not be empty")
    private String lastName;

    @NotEmpty
    @Column(unique = true)
    private String email;

    private Date joinDate;

    private int nbrEnfant;

    private double nbrHrTravail;

    private double heuresSup;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<DemandeConge> demandeConges;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;
}
