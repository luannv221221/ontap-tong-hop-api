package com.ra.tongon.validate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class UniqueValueValidator implements ConstraintValidator<Unique, Object> {
    @PersistenceContext
    private EntityManager em;
    private String field;
    private Class<?> entityClass;
    private String idField;
    @Override
    public void initialize(Unique constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.entityClass = constraintAnnotation.entityClass();
        this.idField = constraintAnnotation.idField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        BeanWrapper beanWrapper = new BeanWrapperImpl(o);
        Object fieldValue = beanWrapper.getPropertyValue(field);
        Object idValue = beanWrapper.getPropertyValue(idField);
        String jpql = "SELECT COUNT(e) FROM "
                + entityClass.getSimpleName() + " e WHERE e." + field + " = :fieldValue";
        if(idValue != null){
            jpql += " AND e." + idField + " <> :idValue";
        }
        var query = em.createQuery(jpql).setParameter("fieldValue", fieldValue);
        if(idValue != null){
            query.setParameter("idValue", idValue);
        }
        Long count = (Long) query.getSingleResult();
        System.out.println(count);
        if(count != 0){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    constraintValidatorContext.getDefaultConstraintMessageTemplate())
                    .addPropertyNode(field).addConstraintViolation();
        }
        return count  == 0;
    }
}
