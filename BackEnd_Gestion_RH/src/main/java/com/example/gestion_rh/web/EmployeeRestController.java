package com.example.gestion_rh.web;


import com.example.gestion_rh.dto.EmployeeDto;
import com.example.gestion_rh.entities.Employee;
import com.example.gestion_rh.service.DepartementService;
import com.example.gestion_rh.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private DepartementService departementService;

    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
         return employeeService.findAllEmployees();
    }

    @PostMapping("/new")
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto,@RequestParam Long departementId){
        employeeDto.setDepartementDto(departementService.findById(departementId));
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id){
        return employeeService.finEmployeeById(id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto oldEmployeeDto = employeeService.finEmployeeById(id);
        oldEmployeeDto.setFirstName(employeeDto.getFirstName());
        oldEmployeeDto.setLastName(employeeDto.getLastName());
        oldEmployeeDto.setEmail(employeeDto.getEmail());
        oldEmployeeDto.setJoinDate(employeeDto.getJoinDate());
        oldEmployeeDto.setNbrEnfant(employeeDto.getNbrEnfant());
        oldEmployeeDto.setNbrHrTravail(employeeDto.getNbrHrTravail());
        oldEmployeeDto.setHeuresSup(employeeDto.getHeuresSup());
        return employeeService.saveEmployee(oldEmployeeDto);
    }






}
