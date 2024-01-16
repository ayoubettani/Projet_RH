package com.example.gestion_rh.service.impl;

import com.example.gestion_rh.dto.DemandeCongeDto;
import com.example.gestion_rh.entities.DemandeConge;
import com.example.gestion_rh.entities.Employee;
import com.example.gestion_rh.mappers.ConfigMapper;
import com.example.gestion_rh.repository.DemandeCongeReposiory;
import com.example.gestion_rh.repository.EmployeeRepository;
import com.example.gestion_rh.service.DemandeCongeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DemandeCongeServiceImpl implements DemandeCongeService {

    private DemandeCongeReposiory demandeCongeReposiory;
    private ConfigMapper configMapper;
    private EmployeeRepository employeeRepository;


    @Override
    public DemandeConge save(DemandeCongeDto demandeCongeDto) {
        //System.out.println(congeDto.getEmployee().getFirstName());
        DemandeConge demandeConge = configMapper.fromDemandeCongeDto(demandeCongeDto);
        Employee employee = configMapper.fromEmployeeDto(demandeCongeDto.getEmployee());

        demandeConge.setEmployee(employee);
        employeeRepository.save(employee);
        return demandeCongeReposiory.save(demandeConge);
    }

    @Override
    public List<DemandeCongeDto> getAllDemandeConge() {

        List<DemandeConge> demandeCongeList = demandeCongeReposiory.findAll();
        List<DemandeConge> demandeCongesPending = new ArrayList<>();

        for (DemandeConge demandeConge : demandeCongeList){
            if(demandeConge.getEtat().equals("pending")){
                demandeCongesPending.add(demandeConge);
                //System.out.println(conge.getEmployee().getFirstName());
            }
        }
        return demandeCongesPending.stream().map(conge -> configMapper.fromDemandeConge(conge)).collect(Collectors.toList());
    }

    @Override
    public DemandeCongeDto findById(Long id) {
        return configMapper.fromDemandeConge(demandeCongeReposiory.findById(id).get());
    }


}
