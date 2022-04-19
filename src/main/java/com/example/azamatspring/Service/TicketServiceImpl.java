package com.example.azamatspring.Service;


import com.example.azamatspring.Entity.Ticket;
import com.example.azamatspring.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {



    private TicketRepository ticketRepository;
    private static int i = 0;
    private static final String props = "schedule.work";

    private static List<Ticket> myTicket = new ArrayList<>();
    private static Long my_def_id = 1L;
    private static final int id = 0;

    static {
        myTicket.add(new Ticket(my_def_id++, "SAM-BR-440",2000));
        myTicket.add(new Ticket(my_def_id++, "ALA-S-321", 15000));
        myTicket.add(new Ticket(my_def_id++, "AKT-F-457", 23000));
    }


    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }



    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Scheduled(initialDelay=1000, fixedRate=3000)
    public void testScheduling() throws InterruptedException {
        boolean flag = true;
        try {
            for (int i = 0; i <myTicket.size(); i++) {
                System.out.println("Started : "+ myTicket.get(i).getPrice());
                int updatePrice = myTicket.get(i).getPrice();
                updatePrice = updatePrice + 500;
                Thread.sleep(3000);

                System.out.println("Finished : "+ updatePrice);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("end");
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
