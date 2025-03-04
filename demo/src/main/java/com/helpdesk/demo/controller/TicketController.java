package com.helpdesk.demo.controller;
import com.helpdesk.demo.model.Ticket;
import com.helpdesk.demo.service.TicketServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
@Tag(name = "Ticket Controller", description = "Operaciones CRUD para tickets")
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    @PostMapping("/")
    @Operation(summary = "Crear un nuevo ticket", description = "Guarda un nuevo ticket en la base de datos")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    // Obtener todos los tickets
    @GetMapping("/")
    @Operation(summary = "Busca todos los tickets", description = "devuelve todo los tickets guardados en la base de datos")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    // Obtener un ticket por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener un ticket por ID", description = "Devuelve los detalles de un ticket específico")
    @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Éxito, ticket encontrado"),
    @ApiResponse(responseCode = "404", description = "Error, ticket no encontrado")
    })
    public ResponseEntity<Ticket> getTicketById(@PathVariable String id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Actualizar un ticket
    @PutMapping("/{id}")
    @Operation(summary = "Editar un ticket por ID", description = "Edita un ticket especifico por la base de datos")
    public ResponseEntity<Ticket> updateTicket(@PathVariable String id, @RequestBody Ticket ticketDetails) {
        return ResponseEntity.ok(ticketService.updateTicket(id, ticketDetails));
 
    }

    // Eliminar un ticket
    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un ticket por ID", description = "Elimina un ticket espefifco por la base de datos")
    public ResponseEntity<Void> deleteTicket(@PathVariable String id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
    


}
