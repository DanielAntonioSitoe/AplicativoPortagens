package com.example.aplicativoportagens.modelo;

import java.util.Date;

public class Turnos {
    int id;
    Date horaInicio;
    Date horaFim;
    Usuario usuario;
    Portagem portagem;

    public Turnos(int id, Date horaInicio, Date horaFim, Usuario usuario, Portagem portagem) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.usuario = usuario;
        this.portagem = portagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
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
