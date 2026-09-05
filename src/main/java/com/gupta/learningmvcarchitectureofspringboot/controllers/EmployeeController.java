package com.gupta.learningmvcarchitectureofspringboot.controllers;

import com.gupta.learningmvcarchitectureofspringboot.DTO.EmployeeDTO;
import com.gupta.learningmvcarchitectureofspringboot.entities.EmployeeEntity;
import com.gupta.learningmvcarchitectureofspringboot.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeDetails(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }


    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }


}
