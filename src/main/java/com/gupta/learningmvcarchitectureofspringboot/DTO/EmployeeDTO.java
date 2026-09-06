package com.gupta.learningmvcarchitectureofspringboot.DTO;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private int age;
    private String address;
    private LocalDate dob;
    private Boolean isActive;

    public EmployeeDTO(Long id, String name, int age, String address, LocalDate dob, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.dob = dob;
        this.isActive = isActive;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
