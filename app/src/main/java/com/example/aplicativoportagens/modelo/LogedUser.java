package com.example.aplicativoportagens.modelo;

import java.util.List;

public class LogedUser {
    String status;
    String key;
    Usuario user;

    public LogedUser(String status, String key, Usuario user) {
        this.status = status;
        this.key = key;
        this.user = user;
    }

    public LogedUser() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
