package com.helpdesk.demo.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.helpdesk.demo.model.Ticket;
import com.helpdesk.demo.repository.TicketRepository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String>{
    List<Ticket> findByStatus(String status);

}
