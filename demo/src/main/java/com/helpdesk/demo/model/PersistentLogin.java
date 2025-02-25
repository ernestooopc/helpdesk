package com.helpdesk.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "persistent_logins")
public class PersistentLogin {

    @Id
    private String series; // ID del token (clave primaria)
    private String username;
    private String token;
    private LocalDateTime lastUsed;

    public PersistentLogin() {}

    public PersistentLogin(String series, String username, String token, LocalDateTime lastUsed) {
        this.series = series;
        this.username = username;
        this.token = token;
        this.lastUsed = lastUsed;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(LocalDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }

    
    
}
