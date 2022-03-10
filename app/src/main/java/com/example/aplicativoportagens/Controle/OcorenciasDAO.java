package com.example.aplicativoportagens.Controle;

import com.example.aplicativoportagens.modelo.Ocorencias;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class OcorenciasDAO {

    public Ocorencias salvar(Ocorencias v) {

        try {
            Vector<Ocorencias> lst = new Vector<>();
            try {

                FileInputStream arquivo = new FileInputStream("ocorencias.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Ocorencias>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            if (v.getId() != 0) {
                for (int i = 0; i < lst.size(); i++) {
                    if (lst.get(i).getId() == v.getId()) {
                        lst.get(i).setTipo(v.getTipo());
                        lst.get(i).setDescricao(v.getDescricao());
                        lst.get(i).setEstadoActual(v.getEstadoActual());
                        lst.get(i).setObservacoes(v.getObservacoes());
                        lst.get(i).setData(v.getData());
                        lst.get(i).setUsuario(v.getUsuario());
                        lst.get(i).setEquipamentos(v.getEquipamentos());
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
            FileOutputStream arquivo = new FileOutputStream("ocorencias.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);

//            JOptionPane.showMessageDialog(null, " Gravacao bem sucedida ");
        } catch (Exception erro) {

//            JOptionPane.showMessageDialog(null, " Gravacao Falhou " + erro);
        }
        return v;

    }

    public List<Ocorencias> buscarTodos() {
        List<Ocorencias> bairro = null;
        try {
            Vector<Ocorencias> lst = new Vector<Ocorencias>();
            FileInputStream arquivo = new FileInputStream("ocorencias.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Ocorencias>) objecto.readObject();
            bairro = lst;
        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
        }
        return bairro;

    }

    public Ocorencias buscarUm(int codigo) {
        Ocorencias bairro = null;
        try {
            Vector<Ocorencias> lst = new Vector<Ocorencias>();
            FileInputStream arquivo = new FileInputStream("ocorencias.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Ocorencias>) objecto.readObject();
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
            Vector<Ocorencias> lst = new Vector<Ocorencias>();
            try {
                FileInputStream arquivo = new FileInputStream("ocorencias.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Ocorencias>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            lst.remove(indice);
            FileOutputStream arquivo = new FileOutputStream("ocorencias.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);
//            JOptionPane.showMessageDialog(null, " Remocao bem sucedida ");
        } catch (Exception erro) {

//            JOptionPane.showMessageDialog(null, " Remocao Falhou " + erro.getMessage());
        }

    }

}
