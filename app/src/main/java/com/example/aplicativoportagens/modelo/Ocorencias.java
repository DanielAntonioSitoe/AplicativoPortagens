package com.example.aplicativoportagens.modelo;

import java.util.Date;

public class Ocorencias {
    int id;
    String tipo;
    String descricao;
    String estadoActual;
    String Observacoes;
    String metodoResolucao;
    Date data;
    Usuario usuario;
    Equipamentos equipamentos;

    public Ocorencias(int id, String tipo, String descricao, String estadoActual, String observacoes, String metodoResolucao, Date data, Usuario usuario, Equipamentos equipamentos) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.estadoActual = estadoActual;
        Observacoes = observacoes;
        this.metodoResolucao = metodoResolucao;
        this.data = data;
        this.usuario = usuario;
        this.equipamentos = equipamentos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String observacoes) {
        Observacoes = observacoes;
    }

    public String getMetodoResolucao() {
        return metodoResolucao;
    }

    public void setMetodoResolucao(String metodoResolucao) {
        this.metodoResolucao = metodoResolucao;
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

    public Equipamentos getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Equipamentos equipamentos) {
        this.equipamentos = equipamentos;
    }
}
