package com.helpdesk.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.helpdesk.demo.model.Ticket;

@Service
public interface TicketService {
    Ticket createTicket(Ticket ticket);
    List<Ticket> getAllTickets();
    Optional<Ticket> getTicketById(String id);
    Ticket updateTicket(String id, Ticket ticket);
    void deleteTicket(String id);
}
