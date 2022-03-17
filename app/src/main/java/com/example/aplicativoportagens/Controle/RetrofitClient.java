package com.example.aplicativoportagens.Controle;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public  static Retrofit retrofit;
    public static Retrofit getRetrofitInstance(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl("http://192.168.58.1/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
