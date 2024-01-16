package com.example.gestion_rh.dto;


import com.example.gestion_rh.entities.DemandeConge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CongeDto {

    private Long id;

    private String description;

    private Date startDate;

    private Date endDate;

    //private DemandeCongeDto demandeCongeDto;
}
