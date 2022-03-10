package com.example.aplicativoportagens.modelo;

public class Usuario {
    int id;
    String nome;
    double contacto;

    public Usuario(int id, String nome, double contacto) {
        this.id = id;
        this.nome = nome;
        this.contacto = contacto;
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
