//package com.example.azamatspring.Controler;
//
//import com.example.azamatspring.Entity.Ticket;
//import com.example.azamatspring.Service.TicketService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class Controller {
//
//    @Autowired
//    private  TicketService ticketService;
//
//    public Controller(TicketService ticketService) {
//        this.ticketService = ticketService;
//    }
//
//    public void setTicketService(TicketService ticketService) {
//        this.ticketService = ticketService;
//    }
//
//
//
//    @GetMapping("/tickets")
//    public List<Ticket> getAllTickets(){
//        return  ticketService.getAllTickets();
//    }
//
//    @PostMapping("/saveticket")
//    public String addTicket( @RequestBody Ticket ticket){
//       ticketService.saveTicket(ticket);
//       return "added ticket";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteByid(@PathVariable("id") Long id){
//        ticketService.deleteCarsById(id);
//
//    }
//
//
//}
