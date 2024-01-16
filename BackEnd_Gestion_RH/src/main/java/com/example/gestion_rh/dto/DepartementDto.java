package com.example.gestion_rh.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DepartementDto {

    private Long id;

    private String name;

    private List<EmployeeDto> employeeDtoList;

}
