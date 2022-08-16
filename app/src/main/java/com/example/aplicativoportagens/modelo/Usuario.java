package com.example.aplicativoportagens.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
    int id;
    String name;
    double contacto;
    String email;
    String senha;

    public Usuario(int id, String nome, double contacto, String username, String senha) {
        this.id = id;
        this.name = nome;
        this.contacto = contacto;
        this.email = username;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public double getContacto() {
        return contacto;
    }

    public void setContacto(double contacto) {
        this.contacto = contacto;
    }
}
