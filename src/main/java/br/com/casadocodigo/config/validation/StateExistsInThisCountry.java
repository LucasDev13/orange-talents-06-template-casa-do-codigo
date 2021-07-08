package br.com.casadocodigo.config.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {StateExistsInThisCountryValidator.class})
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface StateExistsInThisCountry {
    String message() default "Não se pode ter entidades igual com a mesma relação!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String uniqueField();

    Class<?> uniqueClass();

    Class<?> relationClass();

    String relationName();

    String relationField();
}
