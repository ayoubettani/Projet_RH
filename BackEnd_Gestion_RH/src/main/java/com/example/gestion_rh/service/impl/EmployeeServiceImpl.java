package com.example.gestion_rh.service.impl;


import com.example.gestion_rh.dto.EmployeeDto;
import com.example.gestion_rh.entities.Employee;
import com.example.gestion_rh.mappers.ConfigMapper;
import com.example.gestion_rh.repository.EmployeeRepository;
import com.example.gestion_rh.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ConfigMapper configMapper;

    @Override
    public List<EmployeeDto> findAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> configMapper.fromEmployee(employee)).collect(Collectors.toList());
    }

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {

        return employeeRepository.save(configMapper.fromEmployeeDto(employeeDto));
    }

    @Override
    public EmployeeDto finEmployeeById(Long id) {
        return configMapper.fromEmployee(employeeRepository.findById(id).get());
    }

    @Override
    public void deleteEmployee(Long id) {
         employeeRepository.deleteById(id);
    }
}
