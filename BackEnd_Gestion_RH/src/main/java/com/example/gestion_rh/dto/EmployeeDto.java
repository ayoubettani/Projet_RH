package com.example.gestion_rh.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {

    private Long id;
    @NotEmpty(message = "first name should not be empty")
    private String firstName;
    @NotEmpty(message = "last name should not be empty")
    private String lastName;
    @NotEmpty
    private String email;

    private Date joinDate;

    private int nbrEnfant;

    private double nbrHrTravail;

    private double heuresSup;

    @JsonBackReference
    private List<DemandeCongeDto> demandeCongeDtoList;

    private DepartementDto departementDto;
}
