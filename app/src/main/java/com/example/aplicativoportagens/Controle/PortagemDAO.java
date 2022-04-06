package com.example.aplicativoportagens.Controle;

import android.util.Log;

import com.example.aplicativoportagens.modelo.Equipamentos;
import com.example.aplicativoportagens.modelo.Portagem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

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
        List<Portagem> bairro = new ArrayList<>();

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Portagem>> call = apiInterface.getBuscarPortagens();
        call.enqueue(new Callback<List<Portagem>>() {
            @Override
            public void onResponse(Call<List<Portagem>> call, Response<List<Portagem>> response) {
                List<Portagem> list = response.body();
                for (int i = 0; i < list.size(); i++) {
                    Log.e(TAG,"onResponse: Portagem "+list.get(i).getNome());
                    bairro.add(list.get(i));
                }
                Log.e(TAG,"onResponse: "+response.code());
            }
            @Override
            public void onFailure(Call<List<Portagem>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
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
