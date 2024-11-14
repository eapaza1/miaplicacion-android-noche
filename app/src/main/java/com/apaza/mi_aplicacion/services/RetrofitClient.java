package com.apaza.mi_aplicacion.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String URL_BASE="https://fakestoreapi.com/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstace(){

        if (retrofit==null){
            retrofit= new Retrofit.Builder().baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
