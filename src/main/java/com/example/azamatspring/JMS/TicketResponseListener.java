package com.example.azamatspring.JMS;

import com.example.azamatspring.Entity.Ticket;
import com.example.azamatspring.Repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Slf4j
@Component
public class TicketResponseListener {

    @Autowired
    private TicketRepository ticketRepository;

    @JmsListener(destination = "TicketQueue")
    public void receiveMessage(Ticket ticket) {
        System.out.println("Received <" + ticket + ">");
        ticketRepository.save(ticket);
    }
}

