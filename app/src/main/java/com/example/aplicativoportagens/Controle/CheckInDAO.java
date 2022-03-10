package com.example.aplicativoportagens.Controle;

import com.example.aplicativoportagens.modelo.CheckIn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class CheckInDAO {

    public CheckIn salvar(CheckIn v) {

        try {
            Vector<CheckIn> lst = new Vector<CheckIn>();
            try {

                FileInputStream arquivo = new FileInputStream("checkin.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<CheckIn>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            if (v.getId() != 0) {
                for (int i = 0; i < lst.size(); i++) {
                    if (lst.get(i).getId() == v.getId()) {
                        lst.get(i).setHoraFinal(v.getHoraFinal());
                        lst.get(i).setHoraInicial(v.getHoraInicial());
                        lst.get(i).setUsuario(v.getUsuario());
                        lst.get(i).setPortagem(v.getPortagem());
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
            FileOutputStream arquivo = new FileOutputStream("checkin.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);

//            JOptionPane.showMessageDialog(null, " Gravacao bem sucedida ");
        } catch (Exception erro) {

//            JOptionPane.showMessageDialog(null, " Gravacao Falhou " + erro);
        }
        return v;

    }

    public List<CheckIn> buscarTodos() {
        List<CheckIn> bairro = null;
        try {
            Vector<CheckIn> lst = new Vector<CheckIn>();
            FileInputStream arquivo = new FileInputStream("checkin.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<CheckIn>) objecto.readObject();
            bairro = lst;
        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
        }
        return bairro;

    }

    public CheckIn buscarUm(int codigo) {
        CheckIn bairro = null;
        try {
            Vector<CheckIn> lst = new Vector<CheckIn>();
            FileInputStream arquivo = new FileInputStream("checkin.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<CheckIn>) objecto.readObject();
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
            Vector<CheckIn> lst = new Vector<CheckIn>();
            try {
                FileInputStream arquivo = new FileInputStream("checkin.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<CheckIn>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            lst.remove(indice);
            FileOutputStream arquivo = new FileOutputStream("checkin.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);
//            JOptionPane.showMessageDialog(null, " Remocao bem sucedida ");
        } catch (Exception erro) {

//            JOptionPane.showMessageDialog(null, " Remocao Falhou " + erro.getMessage());
        }

    }

}
