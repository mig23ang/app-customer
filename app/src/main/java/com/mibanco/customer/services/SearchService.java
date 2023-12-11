package com.mibanco.customer.services;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.mibanco.customer.R;
import com.mibanco.customer.RetrofitClient;
import com.mibanco.customer.common.TokenDataStore;
import com.mibanco.customer.data.entities.client.Client;
import com.mibanco.customer.data.entities.client.TotalClient;
import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;
import com.mibanco.customer.response.TokenResponse;
import com.mibanco.customer.ui.search.SearchByNameFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchService {
    private SearchServices searchServices;

    public SearchService(){
        searchServices = RetrofitClient.getClientEs().create(SearchServices.class);
    }

    public void getClientsByName(String name, Context context, final OnClientSearchResponseListener listener){
        Dialog loadingDialog = new Dialog(context,  android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        loadingDialog.setContentView(R.layout.activity_loading_search);
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        TokenDataStore tokenDataStore = new TokenDataStore(context);
        String token = tokenDataStore.getAuthToken();

        searchServices.getClientsByName(token, name, 1, 10).enqueue(new Callback<TotalClient>() {

            @Override
            public void onResponse(Call<TotalClient> call, Response<TotalClient> response) {
                loadingDialog.dismiss();
                TotalClient totalClient = response.body();
                if (response.isSuccessful() && totalClient != null) {
                    listener.onClientGetSuccess(totalClient.getTotalClientes(), totalClient.getClientes());
                } else {
                    //listener.onClientGetError("Error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<TotalClient> call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", ""+t.getMessage());
            }
        });
    }

    public interface OnClientSearchResponseListener {
        void onClientGetSuccess(String totalClientes, List<Client> clientes);

        void onClientGetError(Throwable t);
    }


    public interface OnClientSearchByIdResponseListener {
        void onClientGetSuccess(InformacionPrincipal informacionPrincipal, String tipoDocumento, String documento);

        void onClientGetError(String message);
    }

    public void getClientsByDocument(String tipeDocument, String document, Context context, final OnClientSearchByIdResponseListener listener){
        Dialog loadingDialog = new Dialog(context,  android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        loadingDialog.setContentView(R.layout.activity_loading_search);
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        TokenDataStore tokenDataStore = new TokenDataStore(context);
        String token = tokenDataStore.getAuthToken();

        searchServices.getClientsById(token, tipeDocument, document).enqueue(new Callback<InformacionPrincipal>() {

            @Override
            public void onResponse(Call<InformacionPrincipal> call, Response<InformacionPrincipal> response) {
                loadingDialog.dismiss();
                if(response.isSuccessful())
                {
                    InformacionPrincipal informacionPrincipal = response.body();
                    if(listener != null){
                        listener.onClientGetSuccess(informacionPrincipal, tipeDocument, document);
                    }
                }else{
                    if(listener != null){
                        listener.onClientGetError("No se pudieron obtener los datos del cliente.");
                    }
                }

            }

            @Override
            public void onFailure(Call<InformacionPrincipal> call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", ""+t.getMessage());
                if(listener != null){
                    listener.onClientGetError("Hubo un error al conectarse al servidor");
                }
            }
        });
    }

}
