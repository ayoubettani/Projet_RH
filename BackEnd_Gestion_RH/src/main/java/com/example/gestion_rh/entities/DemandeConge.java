package com.example.gestion_rh.entities;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DemandeConge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Date startDate;

    private Date endDate;

    private String etat;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    //@OneToOne
    //@JoinColumn(name = "conge_id", unique = true)
    //private Conge conge;



}
