package com.helpdesk.demo.service;
import com.helpdesk.demo.model.Ticket;
import com.helpdesk.demo.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    
    @Autowired
    private TicketRepository ticketRepository ;

    //CREAR UN NUEVO TICKET//
    public Ticket createTicket(Ticket ticket){
        ticket.setStatus(("Abierto")); //Estado inicial
        ticket.setCreatedAt(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    //Obtener todos los tickets
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    // Obtener un ticket por ID

    public Optional<Ticket> getTicketById(String id) {
        return ticketRepository.findById(id);
    }

    // Actualizar un ticket
    
    public Ticket updateTicket(String id, Ticket ticketDetails) {
        return ticketRepository.findById(id).map(ticket -> {
            ticket.setTitle(ticketDetails.getTitle());
            ticket.setDescription(ticketDetails.getDescription());
            ticket.setStatus(ticketDetails.getStatus());
            ticket.setPriority(ticketDetails.getPriority());
            ticket.setAssignedTo(ticketDetails.getAssignedTo());
            return ticketRepository.save(ticket);
        }).orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
    }

    // Eliminar un ticket
    public void deleteTicket(String id){
        ticketRepository.deleteById(id);
    }


}
