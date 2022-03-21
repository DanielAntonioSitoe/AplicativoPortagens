package com.example.aplicativoportagens.Controle;

import com.example.aplicativoportagens.modelo.Equipamentos;
import com.example.aplicativoportagens.modelo.Ocorencias;
import com.example.aplicativoportagens.modelo.Solicitacoes;
import com.example.aplicativoportagens.modelo.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("/api/solicitacoes")
    Call<Solicitacoes> getGravarSolicitacoes(@Field("descricao") String descricao,
                                                  @Field("estado") String estado,
                                                  @Field("data") String data,
                                                  @Field("user_id") String idusuario);

    @FormUrlEncoded
    @POST("/api/equipamento_user")
    Call<Ocorencias> getGravarOcorencias(@Field("descricao") String descricao,
                                         @Field("tipo") String tipo,
                                         @Field("estado_actual") String estado,
                                         @Field("data") String data,
                                         @Field("observacao") String observacoes,
                                         @Field("metodo_resolucao") String resolucao,
                                         @Field("user_id") String idusuario,
                                         @Field("equipamento_id") String idEquipameno);

    @FormUrlEncoded
    @POST("/api/user_log")
    Call<Usuario> getLogin(@Field("email") String email,
                                      @Field("password") String password);

    @GET("api/equipamentos")
    Call<List<Equipamentos>> getBuscarEquipamentos();

}
