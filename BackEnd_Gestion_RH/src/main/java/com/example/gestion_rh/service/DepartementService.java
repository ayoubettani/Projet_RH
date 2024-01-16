package com.example.gestion_rh.service;

import com.example.gestion_rh.dto.DepartementDto;
import com.example.gestion_rh.entities.Departement;

import java.util.List;

public interface DepartementService {
    List<DepartementDto> getAllDepartements();

    Departement saveDepartement(DepartementDto departementDto);

    DepartementDto findById(Long id);
}
