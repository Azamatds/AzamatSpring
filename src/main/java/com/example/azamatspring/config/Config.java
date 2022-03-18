//package com.example.azamatspring.config;
//
//import com.example.azamatspring.Entity.Ticket;
//import org.springframework.context.annotation.*;
//
//@Configuration
//public class Config {
//
//    @Bean(initMethod = "init" ,
//            destroyMethod = "destroy")
//    @Lazy
////    @Scope("singleton")
//    public Ticket ticket1(){
//        Ticket ticket = new Ticket();
//        ticket.setId(1L);
//        ticket.setPrice(20000);
//        return ticket;
//    }
//
//    @Bean(initMethod = "init" ,
//            destroyMethod = "destroy")
//    @Lazy
//    @Scope("prototype")
//    public Ticket ticket2(){
//        Ticket ticket = new Ticket();
//        ticket.setName("tick");
//        return ticket;
//    }
//
//
//
//}
