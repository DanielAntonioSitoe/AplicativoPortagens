package com.example.aplicativoportagens.Controle;
import android.util.Log;
import com.example.aplicativoportagens.modelo.Equipamentos;
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
        List<Equipamentos> bairro = new ArrayList<>();

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Equipamentos>> call = apiInterface.getBuscarEquipamentos();
        call.enqueue(new Callback<List<Equipamentos>>() {
            @Override
            public void onResponse(Call<List<Equipamentos>> call, Response<List<Equipamentos>> response) {
                List<Equipamentos> list = response.body();
                for (int i = 0; i < list.size(); i++) {
                    Log.e(TAG,"onResponse: descricao"+list.get(i).getDescricao());
                Log.e(TAG,"onResponse: estado"+list.get(i).getEstado());
                    bairro.add(list.get(i));
                }
                Log.e(TAG,"onResponse: "+response.code());
            }
            @Override
            public void onFailure(Call<List<Equipamentos>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
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
