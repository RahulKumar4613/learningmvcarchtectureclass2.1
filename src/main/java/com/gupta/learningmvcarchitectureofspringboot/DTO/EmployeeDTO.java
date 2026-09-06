package com.gupta.learningmvcarchitectureofspringboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private int age;
    private String address;
    private LocalDate dob;
    private Boolean isActive;


}
