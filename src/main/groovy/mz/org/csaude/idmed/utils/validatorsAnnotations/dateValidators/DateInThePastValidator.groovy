package mz.org.csaude.idmed.utils.validatorsAnnotations.dateValidators

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

import java.time.LocalDateTime

@Singleton
class DateInThePastValidator implements ConstraintValidator<IDateInThePast, LocalDateTime> {

    @Override
    boolean isValid(LocalDateTime startDate, ConstraintValidatorContext context) {
        startDate == null || startDate <= new LocalDateTime()
//        return startDate != null ? startDate <= new Date() : null
    }
}
