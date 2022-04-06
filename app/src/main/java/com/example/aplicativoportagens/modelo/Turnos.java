package com.example.aplicativoportagens.modelo;

import java.util.Date;

public class Turnos {
    int id;
    String data_inicio;
    String hora_entrada_saida;
    Usuario usuario;
    String portagem_id;

    public Turnos(int id, String data_inicio, String hora_entrada_saida, Usuario usuario, String portagem) {
        this.id = id;
        this.data_inicio = data_inicio;
        this.hora_entrada_saida = hora_entrada_saida;
        this.usuario = usuario;
        this.portagem_id = portagem;
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
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPortagem() {
        return portagem_id;
    }

    public void setPortagem(String portagem) {
        this.portagem_id = portagem;
    }
}
