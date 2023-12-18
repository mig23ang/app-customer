package com.mibanco.customer;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mibanco.customer.devtemporaly.UnsafeOkHttpClient;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL_MOCKABLE = "https://demo5888600.mockable.io/";

    private static final String URL_AUTENTICACION = "https://apiqa.mibanco.com.co/v1/ms/acceso/";

    private static final String URL_FIC = "https://apidev.mibanco.com.co/v1/es/cliente-fic/";

    private static Retrofit retrofit = null;

    private static Retrofit retrofitt = null;



    public static Retrofit getMockeble(){
        OkHttpClient unsafeOkHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();

            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_MOCKABLE)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(unsafeOkHttpClient)
                    .build();

        return retrofit;
    }

    public static Retrofit getMockebleOther(){
        OkHttpClient unsafeOkHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();

            Gson gson = new GsonBuilder().setLenient().create();
            retrofitt = new Retrofit.Builder()
                    .baseUrl("https://demo5888600.mockable.io/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(unsafeOkHttpClient)
                    .build();

        return retrofitt;
    }


    public static Retrofit getClient() {
        OkHttpClient unsafeOkHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();

            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_AUTENTICACION)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(unsafeOkHttpClient)
                    .build();

        return retrofit;
    }

    public static Retrofit getClientEs() {
        OkHttpClient unsafeOkHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();

            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_FIC)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(unsafeOkHttpClient)
                    .build();

        return retrofit;
    }

    public static Retrofit getClientDev() {
        OkHttpClient unsafeOkHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();

            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_FIC)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(unsafeOkHttpClient)
                    .build();

        return retrofit;
    }
}
