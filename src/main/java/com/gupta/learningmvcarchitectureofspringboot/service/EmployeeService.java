package com.gupta.learningmvcarchitectureofspringboot.service;

import aj.org.objectweb.asm.commons.Remapper;
import com.gupta.learningmvcarchitectureofspringboot.DTO.EmployeeDTO;
import com.gupta.learningmvcarchitectureofspringboot.entities.EmployeeEntity;
import com.gupta.learningmvcarchitectureofspringboot.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {



    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;

    }

    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity employeeEntity1 = employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntity1, EmployeeDTO.class);
    }

    public EmployeeDTO findById(Long id) {
        EmployeeEntity employeeEntity1=employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity1,EmployeeDTO.class);
    }

    public List<EmployeeDTO> findAll() {

       List<EmployeeEntity> employeeEntity1= employeeRepository.findAll();

       ArrayList<EmployeeDTO> employeeDTO=new ArrayList<>();

       for(EmployeeEntity employeeEntity:employeeEntity1){


           employeeDTO.add(modelMapper.map(employeeEntity, EmployeeDTO.class));
       }
       return employeeDTO;

    }


}
