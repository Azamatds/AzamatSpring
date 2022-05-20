package com.example.azamatspring.Service;

import com.example.azamatspring.Entity.Ticket;
import com.example.azamatspring.Errors.CustomErrorException;
import com.example.azamatspring.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService,CasService,AdminService {

    @Autowired
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
    public void update(Ticket ticket) {
        ticketRepository.save((Ticket)ticket);
    }



    @Override
    public Optional<Ticket> getById(Long id){
        Optional<Ticket> tickets = ticketRepository.findById(id);
        if(tickets.isPresent() || !tickets.isEmpty()){
            return tickets;
        }
                throw new CustomErrorException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "User with id=" + id + " not found",
                (Long) id
        );


    }


    @Override
    public void deleteTicketsById(Long id) {
            ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> findBySorting(String field){
        return ticketRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    @Override
    public Ticket findById(Long id){
        return ticketRepository.findById(id).get();
    }

    @Override
    public Ticket saveTicket(Ticket ticket){
      return ticketRepository.save(ticket);
    }






}
