package com.example.aplicativoportagens.modelo;

import java.util.Date;

public class CheckIn {
    int id;
    Date horaInicial;
    Date horaFinal;
    Usuario usuario;
    Portagem portagem;

    public CheckIn(int id, Date horaInicial, Date horaFinal, Usuario usuario, Portagem portagem) {
        this.id = id;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.usuario = usuario;
        this.portagem = portagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Portagem getPortagem() {
        return portagem;
    }

    public void setPortagem(Portagem portagem) {
        this.portagem = portagem;
    }
}
