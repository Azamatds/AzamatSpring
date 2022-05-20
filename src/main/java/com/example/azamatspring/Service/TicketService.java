package com.example.azamatspring.Service;

import com.example.azamatspring.Entity.Ticket;

import java.util.List;
import java.util.Optional;


public interface TicketService extends AdminService,CasService {


    void update(Ticket ticket);



    Ticket findById(Long id);

    Ticket saveTicket(Ticket ticket);

    List<Ticket> findBySorting(String field);

    Optional<Ticket> getById(Long id);


}
