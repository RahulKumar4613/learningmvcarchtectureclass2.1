package com.gupta.learningmvcarchitectureofspringboot.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeAgeValidator implements ConstraintValidator<EmployeeAgeValidation,Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {



        for (int i = 2; i < value / 2; i++) {
            if (value % i == 0)
                return false;
        }

        return true;
    }

}


