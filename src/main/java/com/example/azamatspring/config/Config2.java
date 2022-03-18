//package com.example.azamatspring.config;
//
//import com.example.azamatspring.Repository.DbManager;
//import com.example.azamatspring.Service.TicketServiceImpl;
//import org.springframework.context.annotation.*;
//
//@Configuration
//@ComponentScan
//@EnableAspectJAutoProxy
//public class Config2 {
//    @Bean(name = "ticketService")
//    @DependsOn(value = "ticketDb")
//    public TicketServiceImpl ticketService(){
//        return new TicketServiceImpl(dbManagerTicket());
//    }
//
//    @Bean(name = "ticketDb")
//    public DbManager dbManagerTicket(){
//        return new DbManager();
//    }
//}
