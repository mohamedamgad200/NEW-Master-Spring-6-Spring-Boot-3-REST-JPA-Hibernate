package com.eazybytes.eazyschool.validations;

import com.eazybytes.eazyschool.annotation.FieldsValueMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {
    String field;
    String fieldMatch;

    @Override
    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field=constraintAnnotation.field();
        this.fieldMatch=constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue=new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue=new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
        if(field!=null)
        {
            return fieldValue.equals(fieldMatchValue);
        }else
        {
            return fieldMatchValue==null;
        }

    }
}
