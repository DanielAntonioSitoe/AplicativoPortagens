package com.example.aplicativoportagens.Controle;

import com.example.aplicativoportagens.modelo.Turnos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class TurnosDAO {

    public Turnos salvar(Turnos v) {

        try {
            Vector<Turnos> lst = new Vector<>();
            try {

                FileInputStream arquivo = new FileInputStream("turnos.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Turnos>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            if (v.getId() != 0) {
                for (int i = 0; i < lst.size(); i++) {
                    if (lst.get(i).getId() == v.getId()) {
                        lst.get(i).setHoraInicio(v.getHoraInicio());
                        lst.get(i).setHoraFim(v.getHoraFim());
                        lst.get(i).setPortagem(v.getPortagem());
                        lst.get(i).setUsuario(v.getUsuario());
                        break;
                    }
                }

            } else {
                if(lst.size()!=0){
                    v.setId(lst.get(lst.size()-1).getId() + 1);
                }else{
                    v.setId(1);
                }
                lst.add(v);
            }
            FileOutputStream arquivo = new FileOutputStream("turnos.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);

//            JOptionPane.showMessageDialog(null, " Gravacao bem sucedida ");
        } catch (Exception erro) {

//            JOptionPane.showMessageDialog(null, " Gravacao Falhou " + erro);
        }
        return v;

    }

    public List<Turnos> buscarTodos() {
        List<Turnos> bairro = null;
        try {
            Vector<Turnos> lst = new Vector<Turnos>();
            FileInputStream arquivo = new FileInputStream("turnos.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Turnos>) objecto.readObject();
            bairro = lst;
        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
        }
        return bairro;

    }

    public Turnos buscarUm(int codigo) {
        Turnos bairro = null;
        try {
            Vector<Turnos> lst = new Vector<Turnos>();
            FileInputStream arquivo = new FileInputStream("turnos.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Turnos>) objecto.readObject();
            for (int i = 0; i < lst.size(); i++) {
                if (lst.get(i).getId() == codigo) {
                    bairro = lst.get(i);
                }
            }
        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
        }
        return bairro;
    }

    public void remover(int indice) {
        try {
            Vector<Turnos> lst = new Vector<Turnos>();
            try {
                FileInputStream arquivo = new FileInputStream("turnos.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Turnos>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            lst.remove(indice);
            FileOutputStream arquivo = new FileOutputStream("turnos.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);
//            JOptionPane.showMessageDialog(null, " Remocao bem sucedida ");
        } catch (Exception erro) {

//            JOptionPane.showMessageDialog(null, " Remocao Falhou " + erro.getMessage());
        }

    }

}
