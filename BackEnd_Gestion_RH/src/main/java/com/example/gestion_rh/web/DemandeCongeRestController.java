package com.example.gestion_rh.web;


import com.example.gestion_rh.dto.DemandeCongeDto;
import com.example.gestion_rh.entities.Conge;
import com.example.gestion_rh.entities.DemandeConge;
import com.example.gestion_rh.service.DemandeCongeService;
import com.example.gestion_rh.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/demandeconges")
@CrossOrigin("*")
public class DemandeCongeRestController {

    private DemandeCongeService demandeCongeService;
    private EmployeeService employeeService;

    @PostMapping("/new")
    public DemandeConge newDemanade(@RequestBody DemandeCongeDto demandeCongeDto, @RequestParam Long employeeId) {
        demandeCongeDto.setEmployee(employeeService.finEmployeeById((employeeId)));
        demandeCongeDto.setEtat("pending");
        return demandeCongeService.save(demandeCongeDto);
    }

    @GetMapping()
    public List<DemandeCongeDto> getAllDemandeConges(){
        return demandeCongeService.getAllDemandeConge();
    }

    @GetMapping("/{id}")
    public DemandeCongeDto getDemandeConge(@PathVariable Long id){
        return demandeCongeService.findById(id);
    }

    @PostMapping("/{id}/action")
    public DemandeConge updateEtat(@PathVariable Long id,@RequestBody DemandeCongeDto demandeCongeDto){

        DemandeCongeDto oldDemandeCongeDto = demandeCongeService.findById(id);
        oldDemandeCongeDto.setEtat(demandeCongeDto.getEtat());
        return demandeCongeService.save(oldDemandeCongeDto);
    }






}
