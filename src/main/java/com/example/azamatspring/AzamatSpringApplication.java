package com.example.azamatspring;

import com.example.azamatspring.Entity.Ticket;
import com.example.azamatspring.Service.TicketServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AzamatSpringApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AzamatSpringApplication.class, args);
        TicketServiceImpl ticketService = applicationContext.getBean(TicketServiceImpl.class);
        Ticket ticket = new Ticket("bro-221",15000);
        ticketService.addTickets(ticket);
        System.out.println(ticketService.getAllTickets());



    }

}
