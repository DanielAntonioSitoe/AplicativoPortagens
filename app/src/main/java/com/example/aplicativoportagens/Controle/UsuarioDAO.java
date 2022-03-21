package com.example.aplicativoportagens.Controle;

import android.util.Log;

import com.example.aplicativoportagens.modelo.Ocorencias;
import com.example.aplicativoportagens.modelo.Usuario;

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

public class UsuarioDAO {

    public Usuario salvar(Usuario v) {

        try {
            Vector<Usuario> lst = new Vector<>();
            try {

                FileInputStream arquivo = new FileInputStream("usuario.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Usuario>) objecto.readObject();
            } catch (Exception erro) {
                erro.printStackTrace();
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            if (v.getId() != 0) {
                for (int i = 0; i < lst.size(); i++) {
                    if (lst.get(i).getId() == v.getId()) {
                        lst.get(i).setNome(v.getNome());
                        lst.get(i).setContacto(v.getContacto());
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
            FileOutputStream arquivo = new FileOutputStream("usuario.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);

//            JOptionPane.showMessageDialog(null, " Gravacao bem sucedida ");
        } catch (Exception erro) {
            erro.printStackTrace();

//            JOptionPane.showMessageDialog(null, " Gravacao Falhou " + erro);
        }
        return v;

    }

    public List<Usuario> buscarTodos() {
        List<Usuario> bairro = null;
        try {
            Vector<Usuario> lst = new Vector<Usuario>();
            FileInputStream arquivo = new FileInputStream("usuario.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Usuario>) objecto.readObject();
            bairro = lst;
        } catch (Exception erro) {
            erro.printStackTrace();
//            JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
        }
        return bairro;

    }

    public Usuario buscarUm(String username, String password) {
        Usuario bairro = new Usuario();

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<Usuario> call = apiInterface.getLogin(username,password);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Log.e(TAG,"onResponse: "+response.code());
                Usuario u = response.body();
                bairro.setId(u.getId());
                bairro.setNome(u.getNome());
                bairro.setContacto(u.getContacto());
                bairro.setSenha(u.getSenha());
                bairro.setUsername(u.getUsername());
//                Log.e(TAG,"onResponse: descricao"+response.body().getDescricao());
//                Log.e(TAG,"onResponse: estado"+response.body().getEstado());
//                Log.e(TAG,"onResponse: data"+response.body().getData());
//                Log.e(TAG,"onResponse: user_id"+response.body().getUsuario().getId());
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });

//        try {
//            Vector<Usuario> lst = new Vector<Usuario>();
//            FileInputStream arquivo = new FileInputStream("usuario.arq");
//            ObjectInputStream objecto = new ObjectInputStream(arquivo);
//            lst = (Vector<Usuario>) objecto.readObject();
//            for (int i = 0; i < lst.size(); i++) {
//                if (lst.get(i).getId() == codigo) {
//                    bairro = lst.get(i);
//                }
//            }
//        } catch (Exception erro) {
//            erro.printStackTrace();
////            JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
//        }
        return bairro;
    }

    public void remover(int indice) {
        try {
            Vector<Usuario> lst = new Vector<Usuario>();
            try {
                FileInputStream arquivo = new FileInputStream("usuario.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Usuario>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            lst.remove(indice);
            FileOutputStream arquivo = new FileOutputStream("usuario.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);
//            JOptionPane.showMessageDialog(null, " Remocao bem sucedida ");
        } catch (Exception erro) {
            erro.printStackTrace();

//            JOptionPane.showMessageDialog(null, " Remocao Falhou " + erro.getMessage());
        }

    }

}
