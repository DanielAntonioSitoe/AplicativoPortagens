package com.example.aplicativoportagens.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BuscarEquipamentos {
    @SerializedName("result")
    @Expose
    private List<Equipamentos> listEquipamentos;

    public List<Equipamentos> getListEquipamentos() {
        return listEquipamentos;
    }

    public void setListEquipamentos(List<Equipamentos> listEquipamentos) {
        this.listEquipamentos = listEquipamentos;
    }
}
