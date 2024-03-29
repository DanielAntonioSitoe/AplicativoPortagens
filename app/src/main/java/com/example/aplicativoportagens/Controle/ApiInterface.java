package com.example.aplicativoportagens.Controle;

import com.example.aplicativoportagens.modelo.CheckIn;
import com.example.aplicativoportagens.modelo.Equipamentos;
import com.example.aplicativoportagens.modelo.LogedUser;
import com.example.aplicativoportagens.modelo.Notificacoes;
import com.example.aplicativoportagens.modelo.Ocorencias;
import com.example.aplicativoportagens.modelo.Portagem;
import com.example.aplicativoportagens.modelo.Solicitacoes;
import com.example.aplicativoportagens.modelo.Turnos;
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
    @POST("/api/check_in")
    Call<CheckIn> getGravarCheckIn(@Field("user_id") int user_id,
                                      @Field("portagem_id") int portagem_id,
                                      @Field("data_inicio")String data_inicio,
                                      @Field("data_fim") String data_fim);

    @FormUrlEncoded
    @POST("/api/user_log")
    Call<Turnos> getLogin(@Field("email") String email,
                             @Field("password") String password);

    @GET("api/equipamentos")
    Call<List<Equipamentos>> getBuscarEquipamentos();

    @FormUrlEncoded
    @POST("api/localizacao_equipamento")
    Call<List<Equipamentos>> getBuscarEquipamentos2(@Field("cabine") String cabine,
                                                    @Field("portagem_id") int portagem_id);

    @GET("api/portagens")
    Call<List<Portagem>> getBuscarPortagens();

    @FormUrlEncoded
    @POST("api/notificacoes_user")
    Call<List<Notificacoes>> getBuscarNotificacoes(@Field("user_id") int user_id);

    @FormUrlEncoded
    @POST("api/turno_user")
    Call<List<Turnos>> getBuscarTurnos(@Field("user_id") int user_id);

}
