package mz.org.csaude.idmed.utils.validatorsAnnotations.dateValidators

import java.lang.annotation.Documented
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Documented
@jakarta.validation.Constraint(validatedBy = DateInThePastValidator)
@Target([ElementType.FIELD, ElementType.PARAMETER])
@Retention(RetentionPolicy.RUNTIME)
@interface IDateInThePast {
    String message() default "Apenas datas futuras permitidas"
    Class<?>[] groups() default []
    Class<?>[] payload() default []
}
