package com.example.gestion_rh.service;

import com.example.gestion_rh.dto.DemandeCongeDto;
import com.example.gestion_rh.entities.DemandeConge;

import java.util.List;

public interface DemandeCongeService {
    DemandeConge save(DemandeCongeDto demandeCongeDto);

    List<DemandeCongeDto> getAllDemandeConge();

    DemandeCongeDto findById(Long id);
}
