package br.com.casadocodigo.config.validation;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class StateExistsInThisCountryValidator implements ConstraintValidator<StateExistsInThisCountry, UniqueInThatRelationInterface> {

    private String uniqueField;
    private Class<?> uniqueClass;
    private Class<?> relationClass;
    private String relationName;
    private String relationField;


    @PersistenceContext
    private EntityManager manager;


    @Override
    public void initialize(StateExistsInThisCountry constraintAnnotation) {
        uniqueField = constraintAnnotation.uniqueField();
        uniqueClass = constraintAnnotation.uniqueClass();
        relationName = constraintAnnotation.relationName();
        relationClass = constraintAnnotation.relationClass();
        relationField = constraintAnnotation.relationField();

    }

    @Override
    public boolean isValid(UniqueInThatRelationInterface o, ConstraintValidatorContext constraint) {
        Query query = manager.createQuery("SELECT s FROM "+ uniqueClass.getName() +" s WHERE s."+ uniqueField
                +"=:value AND s."+relationName+"."+relationField+"=:id");
        query.setParameter("value",o.getUniqueValue());
        query.setParameter("id",o.getRelationValue());

        List<?> resultList = query.getResultList();

        Assert.state(resultList.size() <= 1, "Foi encontrado mais de um valor igual.");

        return resultList.isEmpty();
    }
}
