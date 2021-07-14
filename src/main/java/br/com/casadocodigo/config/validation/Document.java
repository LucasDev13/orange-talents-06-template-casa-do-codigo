package br.com.casadocodigo.config.validation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;

@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR)
@ReportAsSingleViolation
@Constraint(validatedBy = { })
@Documented
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Document {
    String message() default "Isso não é um CPF ou CNPJ válido";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
