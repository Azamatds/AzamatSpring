package com.example.azamatspring.JMS;

import com.example.azamatspring.Entity.Ticket;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.Collections;


@Configuration
public class TicketConfig {

    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        val messageConveror = new MappingJackson2MessageConverter();
        messageConveror.setTypeIdPropertyName("context-type");
        messageConveror.setTypeIdMappings(Collections.singletonMap("ticket", Ticket.class));
        return messageConveror;
    }
}
