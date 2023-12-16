package com.mibanco.customer.services;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.mibanco.customer.R;
import com.mibanco.customer.RetrofitClient;
import com.mibanco.customer.common.TokenDataStore;
import com.mibanco.customer.data.entities.UserRequest;
import com.mibanco.customer.response.TokenResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginService {

    private AuthService authService;

    // Constructor para inicializar Retrofit y AuthService
    public LoginService() {
        authService = RetrofitClient.getClient().create(AuthService.class);
    }

    // Método para realizar la solicitud de inicio de sesión
    public void login(String username, String password, Context context, final OnLoginResponseListener listener) {
        Dialog loadingDialog = new Dialog(context,  android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        loadingDialog.setContentView(R.layout.activity_loading);
        loadingDialog.setCancelable(false);
        loadingDialog.show();

        UserRequest userRequest = new UserRequest(username, password);
        try{
            authService.loginUser("hola-mi-id-tyba", "web", "123", userRequest).enqueue(new Callback<TokenResponse>() {
                @Override
                public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                    loadingDialog.dismiss();
                    if (response.isSuccessful() && response.body() != null) {
                        if (listener != null) {
                            listener.onLoginSuccess(response);
                        }
                        //loadingDialog.dismiss();
                    } else {

                        if (response.errorBody() != null) {
                            try {

                                String errorBodyString = response.errorBody().string();
                                //Toast.makeText(context, ""+errorBodyString, Toast.LENGTH_SHORT).show();
                                if (listener != null) {
                                    listener.onCredentialsInvalid(errorBodyString);
                                }
                                //loadingDialog.dismiss();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else{
                            if (listener != null) {
                                listener.onCredentialsInvalid("Si se conecta pero no permite iniciar");
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<TokenResponse> call, Throwable t) {
                    if (listener != null) {
                        listener.onLoginError("Ocurrio un error al iniciar sesión");
                    }
                }
            });

        }catch (Exception e){
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
        }

    }


    public void validate_token(Context context, final OnLoginResponseListener listener){
        TokenDataStore tokenDataStore = new TokenDataStore(context);
        String token = tokenDataStore.getAuthToken();
        if(token != null){
            authService.validateToken(token,"GET", "v1/es/cliente-fic").enqueue(new Callback<Void>() {

                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.isSuccessful()){
                        if(listener != null){
                            listener.onValidateSuccess(response);
                        }
                    }else{
                        try {
                            String errorBodyString = response.errorBody().string();
                            if (listener != null) {
                                listener.onExpiredToken("La sesión expiró");
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }else{
            //No se pondrá ninguna acción, teniendo en cuenta que no necesito nada en caso de no haber un token.
        }
    }

    // Interfaz para notificar al cliente cuando se ha recibido el token
    public interface OnTokenReceivedListener {
        void onTokenReceived(String token);
    }

    public interface OnLoginResponseListener {
        void onLoginSuccess(Response<TokenResponse> response);


        void onValidateSuccess(Response<Void> response);

        void onCredentialsInvalid(String message);


        void onExpiredToken(String message);
        void onLoginError(String message);
    }
}
