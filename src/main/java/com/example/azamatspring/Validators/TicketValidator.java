package com.example.azamatspring.Validators;

import com.example.azamatspring.Entity.Ticket;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TicketValidator implements ConstraintValidator<CheckTicketValid,Ticket> {
    @Override
    public void initialize(CheckTicketValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Ticket ticket, ConstraintValidatorContext constraintValidatorContext) {
        boolean res =true;
        if(ticket.getName().trim().isEmpty() || ticket.getPrice()<0){
            res = false;
        }
        return res;
    }
}

