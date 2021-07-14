package br.com.casadocodigo.config.validation;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class IfCountryHasStatesThanStateNotNullValidator implements ConstraintValidator<IfCountryHasStatesThanStateNotNull, CountryStateValidatorInterface> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(IfCountryHasStatesThanStateNotNull constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CountryStateValidatorInterface clientRequest, ConstraintValidatorContext constraintValidatorContext) {
        if(clientRequest.getState_id()!=null){
            return true;
        }
        Query query = entityManager.createQuery("SELECT 1 FROM State s WHERE s.country.id=:id");
        query.setParameter("id",clientRequest.getCountry_id());

        List<?> resultList = query.getResultList();
        Assert.state(resultList.size() <=1, "Deu rum para o atributo");

        //se estiver válido é se a lista estiver fazia.
        return !resultList.isEmpty();
    }
}
