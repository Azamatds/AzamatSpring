package com.example.azamatspring.Service;

import com.example.azamatspring.Entity.Ticket;
import com.example.azamatspring.Repository.TicketRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TicketServiceImplTest {
    @Mock
    TicketRepository ticketRepository;

    @InjectMocks
    TicketServiceImpl ticketServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllTickets() {
        when(ticketRepository.findAll()).thenReturn(
                Stream.of(new Ticket("Saq-238",34000),new Ticket("SSS-333",333333)).collect(
                        Collectors.toList()));
        assertEquals(2,ticketServiceImpl.getAllTickets().size());
    }

    @Test
    void testAddTickets() {
        ticketServiceImpl.addTickets(new Ticket(Long.valueOf(1), "name", 0));
    }

    @Test
    void testUpdate() {
        ticketServiceImpl.update(new Ticket(Long.valueOf(1), "name", 0));
    }

    @Test
    void testGetById() {
        Ticket ticketTest = new Ticket(1L,"Asv-230",2000);
        Long id = 1L;
        when(ticketRepository.findById(ticketTest.getId()))
                .thenReturn(Optional.of(ticketTest));

        Optional<Ticket> ticketServiceImplById = ticketServiceImpl.getById(id);

        Assertions.assertEquals(Optional.of(ticketTest), ticketServiceImplById);

    }

    @Test
    void testDeleteTicketsById() {
        Long id = 1L;
        ticketServiceImpl.deleteTicketsById(id);
        verify(ticketRepository,times(1)).deleteById(id);
    }

    @Test
    void testFindBySorting() {
        List<Ticket> result = ticketServiceImpl.findBySorting("field");
        Assertions.assertEquals(Arrays.<Ticket>asList(new Ticket(Long.valueOf(1), "name", 0)), result);
    }

    @Test
    void testFindById() {
       Long id = 1L;
       Ticket ticket = new Ticket(id,"SAD-381",22000);
        when(ticketRepository.findById(ticket.getId()))
                .thenReturn(Optional.of(ticket));
    }

    @Test
    void testSaveTicket() {
        Ticket ticket = new Ticket("XCV-382",12000);
        when(ticketRepository.save(ticket)).thenReturn(ticket);
        assertEquals(ticket,ticketServiceImpl.saveTicket(ticket));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme