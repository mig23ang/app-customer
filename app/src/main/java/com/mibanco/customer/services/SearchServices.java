package com.mibanco.customer.services;

import com.mibanco.customer.data.entities.client.TotalClient;
import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SearchServices {

    @GET("v1/es/cliente-fic/nombre/{nombre}")
    Call<TotalClient> getClientsByName(
            @Header("jwt") String token,
            @Path("nombre") String name,
            @Query("page") int page,
            @Query("pageSize") int pageSize
    );


    @GET("v1/es/cliente-fic/{tipoDocumento}/{documento}/1")
    Call<InformacionPrincipal> getClientsById(
            @Header("jwt") String token,
            @Path("tipoDocumento") String tipeDocument,
            @Path("documento") String document
    );


}
