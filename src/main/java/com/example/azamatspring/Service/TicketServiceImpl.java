package com.example.azamatspring.Service;


import com.example.azamatspring.Entity.Ticket;
import com.example.azamatspring.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {



    private TicketRepository ticketRepository;


    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }



    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public void addTickets(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicketsById(Ticket ticket) {
            ticketRepository.delete(ticket);
    }






}
