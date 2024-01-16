package com.example.gestion_rh.web;

import com.example.gestion_rh.dto.DepartementDto;
import com.example.gestion_rh.dto.EmployeeDto;
import com.example.gestion_rh.entities.Departement;
import com.example.gestion_rh.entities.Employee;
import com.example.gestion_rh.service.DepartementService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/departements")
@CrossOrigin("*")
public class DepartementRestController {

    private DepartementService departementService;


    @GetMapping
    public List<DepartementDto> getAllDepartements(){

        return departementService.getAllDepartements();
    }

    @PostMapping("/new")
    public Departement addDepartement(@RequestBody DepartementDto departementDto){

        return departementService.saveDepartement(departementDto);
    }

    @GetMapping("/{id}")
    public DepartementDto getdepartement(@PathVariable Long id){
        return departementService.findById(id);
    }

    @PostMapping("/{id}")
    public Departement updateDepartement(@PathVariable Long id, @RequestBody DepartementDto departementDto){

        DepartementDto oldDepartementDto = departementService.findById(id);

        oldDepartementDto.setName(departementDto.getName());
        return departementService.saveDepartement(oldDepartementDto);


    }



}
