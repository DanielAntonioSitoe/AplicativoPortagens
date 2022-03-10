package com.example.aplicativoportagens.Controle;

import com.example.aplicativoportagens.modelo.Notificacoes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class NotificacoesDAO {

    public Notificacoes salvar(Notificacoes v) {

        try {
            Vector<Notificacoes> lst = new Vector<>();
            try {

                FileInputStream arquivo = new FileInputStream("notificacoes.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Notificacoes>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            if (v.getId() != 0) {
                for (int i = 0; i < lst.size(); i++) {
                    if (lst.get(i).getId() == v.getId()) {
                        lst.get(i).setTema(v.getTema());
                        lst.get(i).setDescricao(v.getDescricao());
                        lst.get(i).setEstado(v.getEstado());
                        lst.get(i).setData(v.getData());
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
            FileOutputStream arquivo = new FileOutputStream("notificacoes.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);

//            JOptionPane.showMessageDialog(null, " Gravacao bem sucedida ");
        } catch (Exception erro) {

//            JOptionPane.showMessageDialog(null, " Gravacao Falhou " + erro);
        }
        return v;

    }

    public List<Notificacoes> buscarTodos() {
        List<Notificacoes> bairro = null;
        try {
            Vector<Notificacoes> lst = new Vector<Notificacoes>();
            FileInputStream arquivo = new FileInputStream("notificacoes.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Notificacoes>) objecto.readObject();
            bairro = lst;
        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
        }
        return bairro;

    }

    public Notificacoes buscarUm(int codigo) {
        Notificacoes bairro = null;
        try {
            Vector<Notificacoes> lst = new Vector<Notificacoes>();
            FileInputStream arquivo = new FileInputStream("notificacoes.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Notificacoes>) objecto.readObject();
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
            Vector<Notificacoes> lst = new Vector<Notificacoes>();
            try {
                FileInputStream arquivo = new FileInputStream("notificacoes.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Notificacoes>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            lst.remove(indice);
            FileOutputStream arquivo = new FileOutputStream("notificacoes.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);
//            JOptionPane.showMessageDialog(null, " Remocao bem sucedida ");
        } catch (Exception erro) {

//            JOptionPane.showMessageDialog(null, " Remocao Falhou " + erro.getMessage());
        }

    }

}
