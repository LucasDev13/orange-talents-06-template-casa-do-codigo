package br.com.casadocodigo.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {StateBelongsToCountryValidator.class})
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface StateBelongsToCountry {
    String message() default "Esse estado não pertence ao país cadastrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
