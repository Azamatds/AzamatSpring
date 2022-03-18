package com.example.azamatspring.Repository;

import com.example.azamatspring.Entity.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TicketRep implements HibRep {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Ticket> getTickets() {
        return sessionFactory.getCurrentSession().createQuery("from Ticket ",Ticket.class).getResultList();
    }



    @Override
    public void addTickets(Ticket ticket) {
        sessionFactory.getCurrentSession().save(ticket);
    }

    @Override
    public void deleteTicketsById(Ticket ticket) {
        sessionFactory.getCurrentSession().delete(ticket);

    }











//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Ticket> findAll(){
//        return jdbcTemplate.query(
//                "SELECT * FROM myticket",
//                (r,rowNumber) -> new Ticket(r.getLong("ID"),r.getString("name"),
//                        r.getInt("price")));
////        );
//    }
//
//
//
//    public int addMyTicket(Ticket ticket){
//        return jdbcTemplate.update(
//                "INSERT INTO myticket(name,price) values (? , ?)",
//                ticket.getName(),ticket.getPrice()
//        );
//    }
//
//
//
//    public int deleteById(int id){
//        return jdbcTemplate.update(
//                "DELETE FROM myticket WHERE id = ?",id);
//
//    }


}
