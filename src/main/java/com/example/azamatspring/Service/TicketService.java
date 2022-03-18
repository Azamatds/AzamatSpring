package com.example.azamatspring.Service;

import com.example.azamatspring.Entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTickets();

    void addTickets(Ticket ticket);

    void deleteTicketsById(Ticket ticket);

}
