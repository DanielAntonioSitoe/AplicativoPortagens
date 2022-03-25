package com.example.aplicativoportagens.modelo;

import java.io.Serializable;
import java.util.List;

public class BuscarEquipamentos implements Serializable {
    private List<Equipamentos> listEquipamentos;

    public List<Equipamentos> getListEquipamentos() {
        return listEquipamentos;
    }

    public void setListEquipamentos(List<Equipamentos> listEquipamentos) {
        this.listEquipamentos = listEquipamentos;
    }
}
