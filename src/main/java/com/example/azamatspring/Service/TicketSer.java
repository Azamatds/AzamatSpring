package com.example.azamatspring.Service;

import com.example.azamatspring.Entity.Ticket;
import com.example.azamatspring.Repository.HibRep;
import com.example.azamatspring.Repository.TicketRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketSer implements TicketService{

    private HibRep hibRepos;

    public TicketSer(HibRep hibRepos) {

        this.hibRepos = hibRepos;
    }


    @Override
    public List<Ticket> getAllTickets() {
        return hibRepos.getTickets();
    }

    @Override
    public void addTickets(Ticket ticket) {
            hibRepos.addTickets(ticket);
    }

    @Override
    public void deleteTicketsById(Ticket ticket) {
        hibRepos.deleteTicketsById(ticket);
    }



//    private TicketRep ticketRep;
//
//    @Autowired
//    public TicketSer(TicketRep ticketRep){
//        this.ticketRep = ticketRep;
//    }
//
//    public List<Ticket> getAllTickets(){
//        return ticketRep.findAll();
//    }
//
//    public void addTicket(Ticket ticket){
//        ticketRep.addMyTicket(ticket);
//    }
//
//    public String deleteProduct(int prodId){
//        if(ticketRep.deleteById(prodId)>0){
//            return "ura";
//        }
//        return "error";
//    }

 }
