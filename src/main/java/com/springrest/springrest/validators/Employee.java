package com.springrest.springrest.validators;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
//import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {GenderValidator.class})
public @interface Employee {
	
	String message() default "Gender should be m, f, o.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
