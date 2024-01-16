package com.example.gestion_rh.service;


import com.example.gestion_rh.dto.EmployeeDto;
import com.example.gestion_rh.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAllEmployees();

    Employee saveEmployee(EmployeeDto employeeDto);

    EmployeeDto finEmployeeById(Long id);

    void deleteEmployee(Long id);
}
