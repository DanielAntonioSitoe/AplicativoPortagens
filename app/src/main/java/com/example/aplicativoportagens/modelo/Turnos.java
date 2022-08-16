package com.example.aplicativoportagens.modelo;

import java.io.Serializable;
import java.util.Date;

public class Turnos implements Serializable{
    int id;
    String data_inicio;
    String hora_entrada_saida;
    Usuario user;
    Portagem portagem;

    public Turnos(int id, String data_inicio, String hora_entrada_saida, Usuario usuario, Portagem portagem) {
        this.id = id;
        this.data_inicio = data_inicio;
        this.hora_entrada_saida = hora_entrada_saida;
        this.user = usuario;
        this.portagem = portagem;
    }

    public Turnos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getHora_entrada_saida() {
        return hora_entrada_saida;
    }

    public void setHora_entrada_saida(String hora_entrada_saida) {
        this.hora_entrada_saida = hora_entrada_saida;
    }

    public Usuario getUsuario() {
        return user;
    }

    public void setUsuario(Usuario usuario) {
        this.user = usuario;
    }

    public Portagem getPortagem() {
        return portagem;
    }

    public void setPortagem(Portagem portagem) {
        this.portagem = portagem;
    }
}
