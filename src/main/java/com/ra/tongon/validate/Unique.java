package com.ra.tongon.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueValueValidator.class})
@Documented
public @interface Unique {
    String message() default "already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field(); // truong can check
    Class<?> entityClass(); // Entity can check
    String idField() default "id";

}
