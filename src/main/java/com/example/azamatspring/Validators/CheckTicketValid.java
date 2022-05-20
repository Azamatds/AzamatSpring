package com.example.azamatspring.Validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = TicketValidator.class)
public @interface CheckTicketValid {
    String message() default "Serial should have ageRestriction, date, name, description, year";
    Class<?>[] groups() default {};
    Class<? extends Payload> []payload() default {};
}