package com.eazybytes.eazyschool.validations;

import com.eazybytes.eazyschool.annotation.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements
        ConstraintValidator<PasswordValidator,String> {
    List<String>weakPasswords;
    String password;
    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        weakPasswords= Arrays.asList("12345","password","qwerty");
    }

    @Override
    public boolean isValid(String passwordField, ConstraintValidatorContext constraintValidatorContext) {
        return passwordField!=null && (!weakPasswords.contains(passwordField));
    }
}
