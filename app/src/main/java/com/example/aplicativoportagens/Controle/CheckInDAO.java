package com.example.aplicativoportagens.Controle;

import android.util.Log;

import com.example.aplicativoportagens.modelo.CheckIn;
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

public class CheckInDAO {

    public CheckIn salvar(CheckIn v) {

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<CheckIn> call = apiInterface.getGravarCheckIn(v.getUsuario().getId(),v.getPortagem().getId(),"2020-01-03","2020-01-03");
        call.enqueue(new Callback<CheckIn>() {
            @Override
            public void onResponse(Call<CheckIn> call, Response<CheckIn> response) {
                Log.e(TAG,"onResponse: "+response.code());
//                Log.e(TAG,"onResponse: descricao"+response.body().getDescricao());
//                Log.e(TAG,"onResponse: estado"+response.body().getEstado());
//                Log.e(TAG,"onResponse: data"+response.body().getData());
//                Log.e(TAG,"onResponse: user_id"+response.body().getUsuario().getId());
            }

            @Override
            public void onFailure(Call<CheckIn> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
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
