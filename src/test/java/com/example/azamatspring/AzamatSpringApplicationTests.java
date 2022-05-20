package com.example.azamatspring;

import com.example.azamatspring.Service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class AzamatSpringApplicationTests {

    @Autowired
    TicketService ticketService;


    @Test
    void contextLoads() {

    }

    @Test
    void test1(){
        Assert.isTrue(ticketService.getById(1L).get().getPrice() == 3000,"equal");

    }


}
