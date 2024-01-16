package com.example.gestion_rh.mappers;

import com.example.gestion_rh.dto.CongeDto;
import com.example.gestion_rh.dto.DemandeCongeDto;
import com.example.gestion_rh.dto.DepartementDto;
import com.example.gestion_rh.dto.EmployeeDto;
import com.example.gestion_rh.entities.Conge;
import com.example.gestion_rh.entities.DemandeConge;
import com.example.gestion_rh.entities.Departement;
import com.example.gestion_rh.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConfigMapper {

    private final ModelMapper modelMapper = new ModelMapper();
    public EmployeeDto fromEmployee(Employee employee){
        return this.modelMapper.map(employee, EmployeeDto.class);
    }

    public Employee fromEmployeeDto(EmployeeDto employeeDto){
        return this.modelMapper.map(employeeDto,Employee.class);
    }

    public DemandeCongeDto fromDemandeConge(DemandeConge demandeConge){
        return this.modelMapper.map(demandeConge, DemandeCongeDto.class);
    }

    public DemandeConge fromDemandeCongeDto(DemandeCongeDto demandeCongeDto){
        return this.modelMapper.map(demandeCongeDto, DemandeConge.class);
    }

    public Conge fromCongeDto(CongeDto congeDto){
        return this.modelMapper.map(congeDto, Conge.class);
    }

    public CongeDto fromConge(Conge conge){
        return this.modelMapper.map(conge, CongeDto.class);
    }

    public Departement fromDepartementDto(DepartementDto departementDto){
        return this.modelMapper.map(departementDto, Departement.class);
    }

    public DepartementDto fromDepartement(Departement departement){
        return this.modelMapper.map(departement, DepartementDto.class);
    }


}
