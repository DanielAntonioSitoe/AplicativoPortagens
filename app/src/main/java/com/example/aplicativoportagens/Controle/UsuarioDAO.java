package com.example.aplicativoportagens.Controle;
import android.util.Log;
import com.example.aplicativoportagens.modelo.LogedUser;
import com.example.aplicativoportagens.modelo.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class UsuarioDAO {
    Usuario bairro;

    public Usuario buscarUm(String username, String password) {
        bairro = new Usuario();

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<LogedUser> call = apiInterface.getLogin(username,password);
        call.enqueue(new Callback<LogedUser>() {
            @Override
            public void onResponse(Call<LogedUser> call, Response<LogedUser> response) {
                Log.e(TAG,"onResponse: "+response.code());
                Usuario u = response.body().getUser();
                if(u!=null) {
                    bairro.setId(u.getId());
                    bairro.setNome(u.getNome());
                    bairro.setUsername(u.getUsername());
                    Log.e(TAG, "onResponse: email" + response.body().getStatus());
                    Log.e(TAG, "onResponse: nome" + response.body().getUser().getNome());
                }
            }

            @Override
            public void onFailure(Call<LogedUser> call, Throwable t) {
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
