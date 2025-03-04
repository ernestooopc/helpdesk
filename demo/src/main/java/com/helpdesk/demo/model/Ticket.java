package com.helpdesk.demo.model;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;



@Document(collection = "tickets")
@Schema(description = "Entidad que representa un ticket de soporte")
public class Ticket {

    @Id
    @Schema(description = "ID del ticket", example = "67a588fce93d0f71abcbe50f")
    private String id;

    @Schema(description = "Titulo del problema", example = "Problema con Correo")
    private String title; // Título del ticket
    @Schema(description = "Descripción del problema", example = "No funciona el correo")
    private String description; // Descripción del problema
    @Schema(description = "Estado del problema", example = "Abierto")
    private String status; // Estado: "Abierto", "En Proceso", "Cerrado"
    @Schema(description = "Prioridad del problema", example = "Alta")
    private String priority; // Prioridad: "Baja", "Media", "Alta"    
    private String assignedTo; // Usuario asignado (ID del soporte)
    private String createdBy; // Usuario que creó el ticket (ID del cliente)
    private LocalDateTime createdAt; // Fecha de creación

    public Ticket(String id, String title, String description, String status, String priority, String assignedTo,
            String createdBy, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignedTo = assignedTo;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    

    



}
