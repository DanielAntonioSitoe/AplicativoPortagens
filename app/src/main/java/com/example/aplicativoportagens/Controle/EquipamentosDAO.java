package com.example.aplicativoportagens.Controle;
import android.widget.Toast;

import com.example.aplicativoportagens.MainActivity;
import com.example.aplicativoportagens.modelo.Equipamentos;
import com.google.android.material.snackbar.Snackbar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class EquipamentosDAO {

    public Equipamentos salvar(Equipamentos v) {

        try {
            Vector<Equipamentos> lst = new Vector<>();
            try {

                FileInputStream arquivo = new FileInputStream("equipamentos.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Equipamentos>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            if (v.getId() != 0) {
                for (int i = 0; i < lst.size(); i++) {
                    if (lst.get(i).getId() == v.getId()) {
                        lst.get(i).setDescricao(v.getDescricao());
                        lst.get(i).setTipo(v.getTipo());
                        lst.get(i).setEstado(v.getEstado());
                        lst.get(i).setLocalizacao(v.getLocalizacao());
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
            FileOutputStream arquivo = new FileOutputStream("equipamentos.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);

//            JOptionPane.showMessageDialog(null, " Gravacao bem sucedida ");
        } catch (Exception erro) {
            erro.printStackTrace();

//            JOptionPane.showMessageDialog(null, " Gravacao Falhou " + erro);
        }
        return v;

    }

    public List<Equipamentos> buscarTodos() {
        List<Equipamentos> bairro = null;
        try {
            Vector<Equipamentos> lst = new Vector<Equipamentos>();
            FileInputStream arquivo = new FileInputStream("equipamentos.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Equipamentos>) objecto.readObject();
            bairro = lst;
        } catch (Exception erro) {
            Snackbar.make(null, "Falha", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            erro.printStackTrace();
        }
        return bairro;

    }

    public Equipamentos buscarUm(int codigo) {
        Equipamentos bairro = null;
        try {
            Vector<Equipamentos> lst = new Vector<Equipamentos>();
            FileInputStream arquivo = new FileInputStream("equipamentos.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Equipamentos>) objecto.readObject();
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
    public List<Equipamentos> buscarPorLocalizacao(String localizacao) {
        List<Equipamentos> bairros = null;
        try {
            Vector<Equipamentos> lst = new Vector<Equipamentos>();
            FileInputStream arquivo = new FileInputStream("equipamentos.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Equipamentos>) objecto.readObject();
            for (int i = 0; i < lst.size(); i++) {
                if (lst.get(i).getLocalizacao().equalsIgnoreCase(localizacao)) {
                    bairros.add(lst.get(i));
                }
            }
        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            erro.printStackTrace();
        }
        return bairros;
    }

    public void remover(int indice) {
        try {
            Vector<Equipamentos> lst = new Vector<Equipamentos>();
            try {
                FileInputStream arquivo = new FileInputStream("equipamentos.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Equipamentos>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            lst.remove(indice);
            FileOutputStream arquivo = new FileOutputStream("equipamentos.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);
//            JOptionPane.showMessageDialog(null, " Remocao bem sucedida ");
        } catch (Exception erro) {
            erro.printStackTrace();

//            JOptionPane.showMessageDialog(null, " Remocao Falhou " + erro.getMessage());
        }

    }

}
