package com.example.aplicativoportagens.Controle;

import android.util.Log;

import com.example.aplicativoportagens.modelo.Ocorencias;
import com.example.aplicativoportagens.modelo.Solicitacoes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class OcorenciasDAO {

    public Boolean salvar(Ocorencias v) {

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<Ocorencias> call = apiInterface.getGravarOcorencias(v.getDescricao(),v.getTipo(),v.getEstadoActual(),
                "2020-01-03",v.getObservacoes(),v.getMetodoResolucao(),
                v.getUsuario().getId()+"","1");
        call.enqueue(new Callback<Ocorencias>() {
            @Override
            public void onResponse(Call<Ocorencias> call, Response<Ocorencias> response) {
                Log.e(TAG,"onResponse: "+response.code());
//                Log.e(TAG,"onResponse: descricao"+response.body().getDescricao());
//                Log.e(TAG,"onResponse: estado"+response.body().getEstado());
//                Log.e(TAG,"onResponse: data"+response.body().getData());
//                Log.e(TAG,"onResponse: user_id"+response.body().getUsuario().getId());
            }

            @Override
            public void onFailure(Call<Ocorencias> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });


//        try {
//            Vector<Ocorencias> lst = new Vector<>();
//            try {
//
//                FileInputStream arquivo = new FileInputStream("ocorencias.arq");
//                ObjectInputStream objecto = new ObjectInputStream(arquivo);
//                lst = (Vector<Ocorencias>) objecto.readObject();
//            } catch (Exception erro) {
////                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
//            }
//            if (v.getId() != 0) {
//                for (int i = 0; i < lst.size(); i++) {
//                    if (lst.get(i).getId() == v.getId()) {
//                        lst.get(i).setTipo(v.getTipo());
//                        lst.get(i).setDescricao(v.getDescricao());
//                        lst.get(i).setEstadoActual(v.getEstadoActual());
//                        lst.get(i).setObservacoes(v.getObservacoes());
//                        lst.get(i).setData(v.getData());
//                        lst.get(i).setUsuario(v.getUsuario());
//                        lst.get(i).setEquipamentos(v.getEquipamentos());
//                        break;
//                    }
//                }
//
//            } else {
//                if(lst.size()!=0){
//                    v.setId(lst.get(lst.size()-1).getId() + 1);
//                }else{
//                    v.setId(1);
//                }
//                lst.add(v);
//            }
//            FileOutputStream arquivo = new FileOutputStream("ocorencias.arq");
//            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
//            objecto.writeObject(lst);
//
////            JOptionPane.showMessageDialog(null, " Gravacao bem sucedida ");
//        } catch (Exception erro) {
//
////            JOptionPane.showMessageDialog(null, " Gravacao Falhou " + erro);
//        }
        return true;

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
