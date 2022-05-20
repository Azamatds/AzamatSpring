package com.example.azamatspring.Aspect;

import com.example.azamatspring.Entity.Ticket;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class TicketAspect {

    @Before("execution(public *  getTicketList(..))")
    public void beforeAdvice2(){
        System.out.println("Before advice");
    }

    @AfterReturning(pointcut = "execution(public *  getTicketList(..))",returning = "tickets")
    public void afterAdvice( List<Ticket> tickets){
        for (int i = 0; i <tickets.size() ; i++) {
            if(tickets.get(i).getName()!= null) {
                System.out.println(i + " " + tickets.get(i).getName());
            }else{
                System.out.println("OOPPSS");
            }
        }
        System.out.println("Advice AfterReturning was completed.");
    }

    @AfterThrowing(pointcut = "execution(public *  getThrowException(..))",throwing = "exception")
    public void afterAdviceTrowing(Throwable exception){
        System.out.println("afterAdviceTrowing " + " исключение " + exception);
    }

    @After("execution(public *  getTicketList(..))")
    public void afterMethod(){
        System.out.println("After advice");
    }

    @Around("execution(public *  returnLastNameTickets(..))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        Object target = null;
        try {
            target = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("success around method");
        return  target;
    }

}

//    @Before("execution(public void com.example.azamatspring.aspect.GetAOP.getAop())")
//    public void beforeAdvice(){
//        System.out.println("Before advice");
//    }

//    @Pointcut("execution(public * com.example.azamatspring.Service.TicketServiceImpl.getAllTickets())")
//    public void point(){
//
//    }
//
//    @Before("point()")
//    public void beforeAdvice(){
//        System.out.println("Before advice");
//    }