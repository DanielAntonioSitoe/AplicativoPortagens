package com.example.aplicativoportagens.Controle;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.Log;

import com.example.aplicativoportagens.modelo.Solicitacoes;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SolicitacoesDAO {

    public Boolean salvar(Solicitacoes v) {
//        Localizacao local = new Localizacao();
//        try {
//            final String s = local.execute("http://127.0.0.1:8000/api/solicitacoes?data="+v.getData().getDate()+"&descricao="+v.getDescricao()+"&estado="+v.getEstado()+"&user_id="+v.getUsuario().getId()).get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<Solicitacoes> call = apiInterface.getGravarSolicitacoes(v.getDescricao(),v.getEstado(),"2022-03-29",v.getUsuario().getId()+"");
        call.enqueue(new Callback<Solicitacoes>() {
            @Override
            public void onResponse(Call<Solicitacoes> call, Response<Solicitacoes> response) {
                Log.e(TAG,"onResponse: "+response.code());
//                Log.e(TAG,"onResponse: descricao"+response.body().getDescricao());
//                Log.e(TAG,"onResponse: estado"+response.body().getEstado());
//                Log.e(TAG,"onResponse: data"+response.body().getData());
//                Log.e(TAG,"onResponse: user_id"+response.body().getUsuario().getId());
            }

            @Override
            public void onFailure(Call<Solicitacoes> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });


//        try {
//            Vector<Solicitacoes> lst = new Vector<>();
//            try {
//
//                FileInputStream arquivo = new FileInputStream("solicitacoes.arq");
//                ObjectInputStream objecto = new ObjectInputStream(arquivo);
//                lst = (Vector<Solicitacoes>) objecto.readObject();
//            } catch (Exception erro) {
////                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
//            }
//            if (v.getId() != 0) {
//                for (int i = 0; i < lst.size(); i++) {
//                    if (lst.get(i).getId() == v.getId()) {
//                        lst.get(i).setDescricao(v.getDescricao());
//                        lst.get(i).setEstado(v.getEstado());
//                        lst.get(i).setData(v.getData());
//                        lst.get(i).setUsuario(v.getUsuario());
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
//            FileOutputStream arquivo = new FileOutputStream("solicitacoes.arq");
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

    public List<Solicitacoes> buscarTodos() {
        List<Solicitacoes> bairro = null;
        try {
            Vector<Solicitacoes> lst = new Vector<Solicitacoes>();
            FileInputStream arquivo = new FileInputStream("solicitacoes.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Solicitacoes>) objecto.readObject();
            bairro = lst;
        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
        }
        return bairro;

    }

    public Solicitacoes buscarUm(int codigo) {
        Solicitacoes bairro = null;
        try {
            Vector<Solicitacoes> lst = new Vector<Solicitacoes>();
            FileInputStream arquivo = new FileInputStream("solicitacoes.arq");
            ObjectInputStream objecto = new ObjectInputStream(arquivo);
            lst = (Vector<Solicitacoes>) objecto.readObject();
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
            Vector<Solicitacoes> lst = new Vector<Solicitacoes>();
            try {
                FileInputStream arquivo = new FileInputStream("solicitacoes.arq");
                ObjectInputStream objecto = new ObjectInputStream(arquivo);
                lst = (Vector<Solicitacoes>) objecto.readObject();
            } catch (Exception erro) {
//                JOptionPane.showMessageDialog(null, " Erro de Leitura: " + erro.getMessage());
            }
            lst.remove(indice);
            FileOutputStream arquivo = new FileOutputStream("solicitacoes.arq");
            ObjectOutputStream objecto = new ObjectOutputStream(arquivo);
            objecto.writeObject(lst);
//            JOptionPane.showMessageDialog(null, " Remocao bem sucedida ");
        } catch (Exception erro) {

//            JOptionPane.showMessageDialog(null, " Remocao Falhou " + erro.getMessage());
        }

    }



    class Localizacao extends AsyncTask<String,Void,String> {
        //
        //    faz a conexao com o link recebido e retorna uma string com a informacao obtida
        //
        @Override
        protected String doInBackground(String... caminhos){
            StringBuilder resultado = new StringBuilder();
            try
            {
                URL url = new URL(caminhos[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new BufferedReader(new InputStreamReader(inputStream)));

                String linha = "";
                while ((linha = reader.readLine())!=null)
                {
                    resultado.append(linha).append("\n");
                }
                return resultado.toString();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
        }

        //
        //    Pega o resultado retornado na conexao, converte-o em um ficheiro json e extrai os dados da cidade
        //
        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);
//            JSONObject jsonObject;
//            try {
////                jsonObject = new JSONObject(resultado);
////                cidadeAtual = jsonObject.getString("city");
////                adicionar =true;
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
        }


    }

}
