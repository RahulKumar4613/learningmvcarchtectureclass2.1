package com.gupta.learningmvcarchitectureofspringboot.DTO;

import com.gupta.learningmvcarchitectureofspringboot.annotation.EmployeeAgeValidation;
import com.gupta.learningmvcarchitectureofspringboot.annotation.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
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
    @NotEmpty(message="Name cannot be empty")
    private String name;
    @Min(value=18, message="Age can not be less than 18")
    @Max(value=50, message="Age can not be greater than 50")
    @Positive(message="age can be positive number only")
    @EmployeeAgeValidation
    private Integer age;
  //  @Pattern(regexp="^(ADMIN|USER)$", message="Role must be either ADMIN or USER")
    @EmployeeRoleValidation
    private String role;
    private String address;
    @PastOrPresent(message="date can not be in future")
    private LocalDate dob;
    @NotNull(message="salary is mandatory field")
    @Digits(integer=6,fraction=2,message="only 6 digit and 2 fraction are allowed")
    private Double salary;
    private Boolean isActive;


}
