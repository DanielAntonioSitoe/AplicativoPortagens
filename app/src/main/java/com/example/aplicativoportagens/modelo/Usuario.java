package com.example.aplicativoportagens.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
    int id;
    String nome;
    double contacto;
    String username;
    String senha;

    public Usuario(int id, String nome, double contacto, String username, String senha) {
        this.id = id;
        this.nome = nome;
        this.contacto = contacto;
        this.username = username;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getContacto() {
        return contacto;
    }

    public void setContacto(double contacto) {
        this.contacto = contacto;
    }
}
