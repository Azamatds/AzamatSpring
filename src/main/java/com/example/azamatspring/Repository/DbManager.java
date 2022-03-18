//package com.example.azamatspring.Repository;
//
//import com.example.azamatspring.Entity.Ticket;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@NoArgsConstructor
//public class DbManager {
//    private static final List<Ticket> ticketListist = new ArrayList<>();
//
//    private static Long my_def_id = 1L;
//    private static final int id = 0;
//
//    static {
//        ticketListist.add(new Ticket(my_def_id++, "SAM-BR-440",2000));
//        ticketListist.add(new Ticket(my_def_id++, "ALA-S-321", 15000));
//    }
//
//    public List<Ticket> getTicketList() {
//        return ticketListist;
//    }
//
//    public void getThrowException(){
//        System.out.println(ticketListist.get(3).getName());
//    }
//
//    public String returnLastNameTickets(){
//        return ticketListist.get(ticketListist.size()-1).getName();
//    }
//
//
//}