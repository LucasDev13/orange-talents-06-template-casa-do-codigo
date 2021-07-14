package br.com.casadocodigo.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {IfCountryHasStatesThanStateNotNullValidator.class})
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface IfCountryHasStatesThanStateNotNull {
    String message() default "É necessário selecionar um estado para esse país!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
