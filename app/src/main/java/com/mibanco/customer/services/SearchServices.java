package com.mibanco.customer.services;

import com.mibanco.customer.data.entities.client.TotalClient;
import com.mibanco.customer.data.entities.client.fic.Client;
import com.mibanco.customer.data.entities.client.fic.DataClients;
import com.mibanco.customer.data.entities.client.fic.HistorialPrestamo;
import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;
import com.mibanco.customer.data.entities.client.fic.datas.DataCupoRotativo;
import com.mibanco.customer.data.entities.client.fic.datas.DataHistorialContacto;
import com.mibanco.customer.data.entities.client.fic.datas.DataHistorialPrestamo;
import com.mibanco.customer.data.entities.client.fic.datas.DataPasivos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SearchServices {

    @GET("nombre/{nombre}")
    Call<TotalClient> getClientsByName(
            @Header("jwt") String token,
            @Path("nombre") String name,
            @Query("page") int page,
            @Query("pageSize") int pageSize
    );


    @GET("{tipoDocumento}/{documento}/1")
    Call<InformacionPrincipal> getClientsById(
            @Header("jwt") String token,
            @Path("tipoDocumento") String tipeDocument,
            @Path("documento") String document
    );



    @GET("clients")
    Call<DataClients> getClientsMockable();


    @GET("loan-history")
    Call<DataHistorialPrestamo> getHistorialPrestamo();




    @GET("revolving-quota")
    Call<DataCupoRotativo> getCupoRotativo();



    @GET("passive")
    Call<DataPasivos> getPasivos();


    @GET("contact-history")
    Call<DataHistorialContacto> getHistorialContacto();
}
