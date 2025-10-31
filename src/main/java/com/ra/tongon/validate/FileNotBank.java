package com.ra.tongon.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {FileNotBankValidator.class})
public @interface FileNotBank {
    String message() default "File Not Bank";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
