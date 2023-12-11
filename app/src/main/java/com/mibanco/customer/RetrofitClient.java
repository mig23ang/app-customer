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

    private static final String BASE_URL = "https://apiqa.mibanco.com.co/";

    private static final String BASE_URL_ES = "https://apiqa.mibanco.com.co/";
    private static final String BASE_URL_DEV = "https://apidev.mibanco.com.co/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        OkHttpClient unsafeOkHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        if (retrofit == null) {
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(unsafeOkHttpClient)
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getClientEs() {
        OkHttpClient unsafeOkHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        if (retrofit == null) {
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_ES)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(unsafeOkHttpClient)
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getClientDev() {
        OkHttpClient unsafeOkHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        if (retrofit == null) {
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_DEV)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(unsafeOkHttpClient)
                    .build();
        }
        return retrofit;
    }
}
