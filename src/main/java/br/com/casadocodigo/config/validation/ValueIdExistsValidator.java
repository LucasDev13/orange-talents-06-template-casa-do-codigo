package br.com.casadocodigo.config.validation;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ValueIdExistsValidator implements ConstraintValidator<ValueIdExists, Object> {

    private String domainAttribute;
    private Class<?> domain;
    @PersistenceContext
    private EntityManager manager;


    @Override
    public void initialize(ValueIdExists param) {
        domainAttribute = param.fieldName();
        domain = param.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraint) {
        Query query = manager.createQuery("select 1 from "+domain.getName()+ " where " +
                domainAttribute + "=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1,
                "Foi encontrado mais de um " + domain + " com o atributo " + domainAttribute + "com o atributo = " + value);
        return !list.isEmpty();
    }
}
