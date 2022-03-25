package com.example.aplicativoportagens.modelo;

public class Equipamentos {
    int id;
    String descricao;
    String tipo;
    String estado;
    String localizacao;
    Portagem portagem;

    public Equipamentos(int id, String descricao, String tipo, String estado, String localizacao, Portagem portagem) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.estado = estado;
        this.localizacao = localizacao;
        this.portagem = portagem;
    }

    public Equipamentos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Portagem getPortagem() {
        return portagem;
    }

    public void setPortagem(Portagem portagem) {
        this.portagem = portagem;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
