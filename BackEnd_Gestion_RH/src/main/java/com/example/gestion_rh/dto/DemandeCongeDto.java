package com.example.gestion_rh.dto;


import com.example.gestion_rh.entities.Conge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DemandeCongeDto {

    private Long id;

    private String description;

    private Date startDate;

    private Date endDate;

    private String etat;

    //@JsonManagedReference
    private EmployeeDto employee;

    //private CongeDto congeDto;


}
