package com.springrest.springrest.validators;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<Employee, String>  {
	
	List<String> gender = Arrays.asList("m", "f", "o");

	

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return gender.contains(value);
	}
	

}
