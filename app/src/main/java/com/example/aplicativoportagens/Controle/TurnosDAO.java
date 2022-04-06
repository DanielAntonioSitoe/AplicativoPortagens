package com.example.aplicativoportagens.Controle;

import android.util.Log;

import com.example.aplicativoportagens.modelo.Notificacoes;
import com.example.aplicativoportagens.modelo.Turnos;

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

public class TurnosDAO {

    public void salvar(Turnos v) {

    }

    public List<Turnos> buscarTodos(int id_user) {
        List<Turnos> bairro = new ArrayList<>();
        try {

            ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
            Call<List<Turnos>> call = apiInterface.getBuscarTurnos(id_user);
            call.enqueue(new Callback<List<Turnos>>() {
                @Override
                public void onResponse(Call<List<Turnos>> call, Response<List<Turnos>> response) {
                    List<Turnos> list = response.body();
                    for (int i = 0; i < list.size(); i++) {
                        Log.e(TAG, "onResponse: Data " + list.get(i).getData_inicio());
                        Log.e(TAG, "onResponse: Horas " + list.get(i).getHora_entrada_saida());
                        bairro.add(list.get(i));
                    }
                    Log.e(TAG, "onResponse: " + response.code());
                }

                @Override
                public void onFailure(Call<List<Turnos>> call, Throwable t) {
                    Log.e(TAG, "onFailure: " + t.getMessage());
                }
            });
        }catch (Exception e){
            Log.e(TAG,"ERROR:"+e.getMessage());
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


}
