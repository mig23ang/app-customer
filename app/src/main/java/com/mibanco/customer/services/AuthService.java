package com.mibanco.customer.services;

import com.mibanco.customer.data.entities.UserRequest;
import com.mibanco.customer.response.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthService {

    @Headers({
            "Content-Type: application/json",
    })
    @POST("v1/ms/acceso/autentica/usuario/")
    Call<TokenResponse> loginUser(
            @Header("clientID") String clientID,
            @Header("deviceType") String deviceType,
            @Header("ip") String ip,
            @Body UserRequest request
    );



    @GET("v1/ms/acceso/verifica/usuario/")
    Call<Void> validateToken(
            @Header("jwt") String token,
            @Header("clientAction") String clientAction,
            @Header("resourceRequest") String resourceRequest
    );
}
