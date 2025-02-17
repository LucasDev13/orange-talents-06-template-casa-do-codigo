package br.com.casadocodigo.config.validation;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object>{

    private String domainAttribute;
    private Class<?> domain;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue param) {
        domainAttribute = param.fieldName();
        domain = param.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from "+domain.getName()+" where " +
                domainAttribute + "=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();//DEU ERRO AQUI
        Assert.state(list.size() <= 1,
                 "Foi encontrado mais de um " + domain+" com o atributo" + domainAttribute);
        return list.isEmpty();
    }
}
