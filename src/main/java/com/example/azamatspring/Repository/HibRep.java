package com.example.azamatspring.Repository;

import com.example.azamatspring.Entity.Ticket;

import java.util.List;

public interface HibRep {
    List<Ticket> getTickets();
    void addTickets(Ticket ticket);
    void deleteTicketsById(Ticket ticket);
}
