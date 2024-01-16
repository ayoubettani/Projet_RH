package com.example.gestion_rh.service.impl;

import com.example.gestion_rh.dto.DepartementDto;
import com.example.gestion_rh.entities.Departement;
import com.example.gestion_rh.entities.Employee;
import com.example.gestion_rh.mappers.ConfigMapper;
import com.example.gestion_rh.repository.DepartementRepository;
import com.example.gestion_rh.service.DepartementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartementServiceImpl implements DepartementService {

    private DepartementRepository departementRepository;
    private ConfigMapper configMapper;


    @Override
    public List<DepartementDto> getAllDepartements() {

        List<Departement> departements = departementRepository.findAll();

        return departements.stream().map((departement) -> configMapper.fromDepartement(departement)).collect(Collectors.toList());
    }

    @Override
    public Departement saveDepartement(DepartementDto departementDto) {
        return departementRepository.save(configMapper.fromDepartementDto(departementDto));
    }

    @Override
    public DepartementDto findById(Long id) {
        return configMapper.fromDepartement(departementRepository.findById(id).get());
    }

}
