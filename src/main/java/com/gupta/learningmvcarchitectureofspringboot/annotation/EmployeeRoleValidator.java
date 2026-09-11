package com.gupta.learningmvcarchitectureofspringboot.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        List<String> roles=List.of("User","Admin");

        return roles.contains(value);
    }
}
