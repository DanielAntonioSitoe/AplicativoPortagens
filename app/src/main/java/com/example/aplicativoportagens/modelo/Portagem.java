package com.example.aplicativoportagens.modelo;

public class Portagem {
    int id;
    String nome;
    double cordenadaX;
    double cordenadaY;

    public Portagem(int id, String nome, double cordenadaX, double cordenadaY) {
        this.id = id;
        this.nome = nome;
        this.cordenadaX = cordenadaX;
        this.cordenadaY = cordenadaY;
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

    public double getCordenadaX() {
        return cordenadaX;
    }

    public void setCordenadaX(double cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public double getCordenadaY() {
        return cordenadaY;
    }

    public void setCordenadaY(double cordenadaY) {
        this.cordenadaY = cordenadaY;
    }
}
