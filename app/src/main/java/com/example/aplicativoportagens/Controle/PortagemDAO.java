package com.example.aplicativoportagens.Controle;

import com.example.aplicativoportagens.modelo.Portagem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class PortagemDAO {

    public Portagem salvar(Portagem v) {

        try {
            Vector<Portagem> lst = new Vector<>();
            try {

                FileInputStream arquivo = new FileInputStream("portagem.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Portagem>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
                erro.printStackTrace();
            }
            if (v.getId() != 0) {
                for (int i = 0; i < lst.size(); i++) {
                    if (lst.get(i).getId() == v.getId()) {
                        lst.get(i).setNome(v.getNome());
                        lst.get(i).setCordenadaX(v.getCordenadaX());
                        lst.get(i).setCordenadaY(v.getCordenadaY());
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
            FileOutputStream arquivo = new FileOutputStream("portagem.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);

//            JOptionPane.showMessageDialog(null, " Gravacao bem sucedida ");
        } catch (Exception erro) {

//            JOptionPane.showMessageDialog(null, " Gravacao Falhou " + erro);
            erro.printStackTrace();
        }
        return v;

    }

    public List<Portagem> buscarTodos() {
        List<Portagem> bairro = null;
        try {
            Vector<Portagem> lst = new Vector<Portagem>();
            FileInputStream arquivo = new FileInputStream("portagem.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Portagem>) objecto.readObject();
            bairro = lst;
        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            erro.printStackTrace();
        }
        return bairro;

    }

    public Portagem buscarUm(int codigo) {
        Portagem bairro = null;
        try {
            Vector<Portagem> lst = new Vector<Portagem>();
            FileInputStream arquivo = new FileInputStream("portagem.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Portagem>) objecto.readObject();
            for (int i = 0; i < lst.size(); i++) {
                if (lst.get(i).getId() == codigo) {
                    bairro = lst.get(i);
                }
            }
        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            erro.printStackTrace();
        }
        return bairro;
    }

    public void remover(int indice) {
        try {
            Vector<Portagem> lst = new Vector<Portagem>();
            try {
                FileInputStream arquivo = new FileInputStream("portagem.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Portagem>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            lst.remove(indice);
            FileOutputStream arquivo = new FileOutputStream("portagem.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);
//            JOptionPane.showMessageDialog(null, " Remocao bem sucedida ");
        } catch (Exception erro) {

//            JOptionPane.showMessageDialog(null, " Remocao Falhou " + erro.getMessage());
            erro.printStackTrace();
        }

    }

}
