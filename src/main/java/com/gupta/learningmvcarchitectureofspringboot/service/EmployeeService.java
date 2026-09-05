package com.gupta.learningmvcarchitectureofspringboot.service;

import com.gupta.learningmvcarchitectureofspringboot.entities.EmployeeEntity;
import com.gupta.learningmvcarchitectureofspringboot.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {



    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity findById(Long id) {
        return employeeRepository.findById(id).orElse(null);

    }

    public List<EmployeeEntity> findAll() {

        return employeeRepository.findAll();
    }


}
