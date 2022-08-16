package com.example.aplicativoportagens.Controle;
import android.util.Log;
import com.example.aplicativoportagens.modelo.LogedUser;
import com.example.aplicativoportagens.modelo.Turnos;
import com.example.aplicativoportagens.modelo.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class UsuarioDAO {
    Usuario bairro;

    public Turnos buscarUm(String username, String password) {
        Turnos bairro = new Turnos();

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<Turnos> call = apiInterface.getLogin(username,password);
        call.enqueue(new Callback<Turnos>() {
            @Override
            public void onResponse(Call<Turnos> call, Response<Turnos> response) {
                Turnos u = response.body();
                if(u!=null) {
                    bairro.setId(u.getId());
                    bairro.setUsuario(u.getUsuario());
                    bairro.setPortagem(u.getPortagem());
                    bairro.setData_inicio(u.getData_inicio());
                    bairro.setHora_entrada_saida(u.getHora_entrada_saida());
                    Log.e(TAG, "onResponse: email" + response.body().getId());
                }
            }

            @Override
            public void onFailure(Call<Turnos> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
        return bairro;
    }

    public Usuario getBairro() {
        return bairro;
    }

    public void setBairro(Usuario bairro) {
        this.bairro = bairro;
    }

}
