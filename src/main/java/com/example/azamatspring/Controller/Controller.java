package com.example.azamatspring.Controller;

import com.example.azamatspring.Entity.Ticket;
import com.example.azamatspring.Errors.CustomErrorException;
import com.example.azamatspring.Errors.ResourceNotFoundException;
import com.example.azamatspring.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private JmsTemplate jmsTemplate;


    @GetMapping("/users")
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ResponseEntity<List<Ticket>> getAllTickets(){
        return new ResponseEntity<>(ticketService.getAllTickets(),HttpStatus.OK);
    }
//
//    @PreAuthorize("isAnonymous()")
//    @GetMapping(value = "/get-tickets")
//    public List<Ticket> getTickets() {
//        return ticketService.getAllTickets();
//    }
//
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PostMapping(value = "/create-tickets")
//    public Ticket createTickets(@RequestBody Ticket ticket) {
//        return ticketService.saveTicket(ticket);
//    }
//
//
//
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @DeleteMapping(value = "/delete_tickets")
//    public void deleteTickets(@RequestParam(value = "id") Long id) {
//        try {
//            ticketService.deleteTicketsById(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



    //JMS
    @PostMapping("/send")
    public void send(@RequestBody Ticket ticket){
        jmsTemplate.convertAndSend("TicketQueue",ticket);
//        jmsTemplate.receiveAndConvert("TicketQueue");
    }

    @PostMapping("/user")
    public ResponseEntity<Void> addTicket(@RequestBody Ticket ticket){
        ticketService.addTickets(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //SORT
    @GetMapping("/{field}")
    public ResponseEntity<List<Ticket>> findBySorting(@PathVariable String field){
        List<Ticket> allProducts = ticketService.findBySorting(field);
        return new ResponseEntity<>(allProducts,HttpStatus.ACCEPTED);
    }

    @GetMapping("/ticketById/{id}")
    public Optional<Ticket> getById(@PathVariable Long id){
        return ticketService.getById(id);
    }

    @PutMapping("/ticket/{id}")
    public ResponseEntity<Ticket> updateEmployee(@PathVariable(value = "id") Long ticketId,
                                                    @RequestBody Ticket ticketDetails) throws ResourceNotFoundException {

        Ticket ticket = Optional.of(ticketService.findById(ticketId))
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found for this id :: " + ticketId));

        ticket.setName(ticketDetails.getName());
        ticket.setPrice(ticketDetails.getPrice());

        final Ticket updatedTicket = ticketService.saveTicket(ticket);
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("/ticket/{id}")
    public ResponseEntity<Void> deleteTicket(
            @PathVariable Long id
    ){
        ticketService.deleteTicketsById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }





}
