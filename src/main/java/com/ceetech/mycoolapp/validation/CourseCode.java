package com.ceetech.mycoolapp.validation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    public String value() default "LUV";

    public String message() default "Must start with LUV";

    //define default groups
    Class<?>[] groups() default {};

    //define default payload
    Class<? extends Payload>[] payload() default {};


}
