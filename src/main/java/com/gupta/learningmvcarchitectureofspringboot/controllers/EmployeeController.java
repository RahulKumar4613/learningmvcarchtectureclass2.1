package com.gupta.learningmvcarchitectureofspringboot.controllers;

import com.gupta.learningmvcarchitectureofspringboot.DTO.EmployeeDTO;
import com.gupta.learningmvcarchitectureofspringboot.entities.EmployeeEntity;
import com.gupta.learningmvcarchitectureofspringboot.repositories.EmployeeRepository;
import com.gupta.learningmvcarchitectureofspringboot.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

   private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }


    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeDetails(@PathVariable Long id) {
        return employeeService.findById(id);
    }


    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.save(employee);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.findAll();
    }


}
