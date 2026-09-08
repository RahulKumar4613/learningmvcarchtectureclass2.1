package com.gupta.learningmvcarchitectureofspringboot.service;


import com.gupta.learningmvcarchitectureofspringboot.DTO.EmployeeDTO;
import com.gupta.learningmvcarchitectureofspringboot.entities.EmployeeEntity;
import com.gupta.learningmvcarchitectureofspringboot.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        EmployeeEntity employeeEntity1 = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity1, EmployeeDTO.class);
    }

    public List<EmployeeDTO> findAll() {

        List<EmployeeEntity> employeeEntity1 = employeeRepository.findAll();

        ArrayList<EmployeeDTO> employeeDTO = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeEntity1) {


            employeeDTO.add(modelMapper.map(employeeEntity, EmployeeDTO.class));
        }
        return employeeDTO;

    }

    public boolean IsExist(Long id){
        return employeeRepository.existsById(id);
    }


    public EmployeeDTO updateById(Long id, EmployeeDTO employeeDTO) {

        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);

        boolean isexist= IsExist(id);

        if (isexist) {
            employeeEntity.setId(id);
        }
        EmployeeEntity employeeEntity1 = employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntity1, EmployeeDTO.class);

        
    }

    public boolean deleteById(Long id) {
        boolean isexist= IsExist(id);
        if(!isexist)
            return false;
        employeeRepository.deleteById(id);
        return true;
    }

    @PatchMapping(path="/{id}")
    public EmployeeDTO updateByIdPatch(@RequestBody Map<String, Object> updates,@PathVariable Long id){

        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        if(employeeEntity==null){
            throw new IllegalArgumentException("Employee not found with id: " + id);
        }

        updates.forEach((field, value) -> {
            // Use reflection to find the field in the EmployeeEntity class
            Field field1 = ReflectionUtils.findField(EmployeeEntity.class, field);
            if (field1 == null) {
                return ;
            }
            // Make the field accessible for modification
            field1.setAccessible(true);
            // Set the new value for the field in the employeeEntity object
            ReflectionUtils.setField(field1, employeeEntity, value);
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);

    }
}
