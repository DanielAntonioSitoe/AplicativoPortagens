package com.example.aplicativoportagens.modelo;

import java.util.Date;

public class Notificacoes {
    int id;
    String tema;
    String descricao;
    String estado;
    Date data;
    Usuario usuario;

    public Notificacoes(int id, String tema, String descricao, String estado, Date data, Usuario usuario) {
        this.id = id;
        this.tema = tema;
        this.descricao = descricao;
        this.estado = estado;
        this.data = data;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
