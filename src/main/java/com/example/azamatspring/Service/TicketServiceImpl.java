//package com.example.azamatspring.Service;
//
//
//import com.example.azamatspring.Entity.Ticket;
//import com.example.azamatspring.Repository.DbManager;
//import com.example.azamatspring.Repository.TicketRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//
//import java.util.List;
//
//
//public class TicketServiceImpl implements TicketService {
//
//    private final DbManager dbManagerticlet;
//
////    private TicketRepository ticketRepository;
//
//
//
//    public TicketServiceImpl(DbManager dbManagerticlet) {
//
//        this.dbManagerticlet = dbManagerticlet;
//    }
//
//    @Value("${text}")
//    private String text;
//
//    public String getText() {
//        return text;
//    }
//
//    @Override
//    public List<Ticket> getAllTickets() {
//        return dbManagerticlet.getTicketList();
//    }
//
//    @Override
//    public void saveTicket(Ticket ticket) {
////        ticketRepository.save(ticket);
//    }
//
//    @Override
//    public void deleteCarsById(Long id) {
////        ticketRepository.deleteById(id);
//    }
//
//
//
//
//}
