package com.apaza.mi_aplicacion.services;

import com.apaza.mi_aplicacion.entidades.EProducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {

    @GET("products")
    Call<List<EProducto>> getProductos();

}
