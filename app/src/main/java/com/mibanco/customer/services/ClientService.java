package com.mibanco.customer.services;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.mibanco.customer.R;
import com.mibanco.customer.RetrofitClient;
import com.mibanco.customer.data.entities.client.fic.Client;
import com.mibanco.customer.data.entities.client.fic.CupoRotativo;
import com.mibanco.customer.data.entities.client.fic.DataClients;
import com.mibanco.customer.data.entities.client.fic.HistorialPrestamo;
import com.mibanco.customer.data.entities.client.fic.Pasivo;
import com.mibanco.customer.data.entities.client.fic.datas.DataCupoRotativo;
import com.mibanco.customer.data.entities.client.fic.datas.DataHistorialContacto;
import com.mibanco.customer.data.entities.client.fic.datas.DataHistorialPrestamo;
import com.mibanco.customer.data.entities.client.fic.datas.DataPasivos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientService {
    private SearchServices searchServicesMockable;


    public ClientService() {
        searchServicesMockable = RetrofitClient.getMockebleOther().create(SearchServices.class);
    }


    public void getClientToMenu(Context context, final ClientService.OnClientMenuResponseListener listener) {
        Dialog loadingDialog = new Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        loadingDialog.setContentView(R.layout.activity_loading_search);
        loadingDialog.setCancelable(false);
        loadingDialog.show();


        searchServicesMockable.getClientsMockable().enqueue(new Callback<DataClients>() {

            @Override
            public void onResponse(Call<DataClients> call, Response<DataClients> response) {
                loadingDialog.dismiss();
                DataClients client = response.body();
                if (response.isSuccessful()) {
                    listener.onClientGetSuccess(client.getDatos());
                } else {
                    listener.onClientGetError("Error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<DataClients> call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", " Se obtuvo " + t.getMessage());

                AlertDialog.Builder Bien = new AlertDialog.Builder(context);
                Bien.setMessage("Error al obtener los usuarios" + t.getMessage())
                        .setCancelable(false)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog Titulo = Bien.create();
                Titulo.setTitle("error!");
                Titulo.show();
            }


        });
    }


    public interface OnClientMenuResponseListener {
        void onClientGetSuccess(List<Client> client);

        void onClientGetError(String message);
    }


    public void getHistorialContacto(Context context, final ClientService.OnHistorialContactoResponseListener listener) {
        Dialog loadingDialog = new Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        loadingDialog.setContentView(R.layout.activity_loading_search);
        loadingDialog.setCancelable(false);
        loadingDialog.show();


        searchServicesMockable.getHistorialPrestamo().enqueue(new Callback<DataHistorialPrestamo>() {

            @Override
            public void onResponse(Call<DataHistorialPrestamo> call, Response<DataHistorialPrestamo> response) {
                loadingDialog.dismiss();
                DataHistorialPrestamo client = response.body();
                if (response.isSuccessful()) {
                    listener.onClientGetSuccess(client.getDatos());
                } else {
                    listener.onClientGetError("Error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<DataHistorialPrestamo> call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", " Se obtuvo " + t.getMessage());

                AlertDialog.Builder Bien = new AlertDialog.Builder(context);
                Bien.setMessage("Error al obtener los usuarios" + t.getMessage())
                        .setCancelable(false)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog Titulo = Bien.create();
                Titulo.setTitle("error!");
                Titulo.show();
            }


        });
    }


    public interface OnHistorialContactoResponseListener {
        void onClientGetSuccess(List<HistorialPrestamo> historial);

        void onClientGetError(String message);
    }


    public void getCupoRotativo(Context context, final ClientService.OnCupoRotativoResponseListener listener) {
        Dialog loadingDialog = new Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        loadingDialog.setContentView(R.layout.activity_loading_search);
        loadingDialog.setCancelable(false);
        loadingDialog.show();


        searchServicesMockable.getCupoRotativo().enqueue(new Callback<DataCupoRotativo>() {

            @Override
            public void onResponse(Call<DataCupoRotativo> call, Response<DataCupoRotativo> response) {
                loadingDialog.dismiss();
                DataCupoRotativo client = response.body();
                if (response.isSuccessful()) {
                    listener.onClientGetSuccess(client.getDatos());
                } else {
                    listener.onClientGetError("Error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<DataCupoRotativo> call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", " Se obtuvo " + t.getMessage());

                AlertDialog.Builder Bien = new AlertDialog.Builder(context);
                Bien.setMessage("Error al obtener los usuarios" + t.getMessage())
                        .setCancelable(false)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog Titulo = Bien.create();
                Titulo.setTitle("error!");
                Titulo.show();
            }


        });
    }


    public interface OnCupoRotativoResponseListener {
        void onClientGetSuccess(List<CupoRotativo> cupoRotativos);

        void onClientGetError(String message);
    }





    public void getPasivos(Context context, final ClientService.OnPasivosResponseListener listener){
        Dialog loadingDialog = new Dialog(context,  android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        loadingDialog.setContentView(R.layout.activity_loading_search);
        loadingDialog.setCancelable(false);
        loadingDialog.show();


        searchServicesMockable.getPasivos().enqueue(new Callback<DataPasivos>() {

            @Override
            public void onResponse(Call<DataPasivos> call, Response<DataPasivos> response) {
                loadingDialog.dismiss();
                DataPasivos client = response.body();
                if (response.isSuccessful()) {
                    listener.onClientGetSuccess(client.getPasivos());
                } else {
                    listener.onClientGetError("Error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<DataPasivos> call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", " Se obtuvo "+t.getMessage());

                AlertDialog.Builder Bien = new AlertDialog.Builder(context);
                Bien.setMessage("Error al obtener los usuarios"+t.getMessage())
                        .setCancelable(false)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog Titulo = Bien.create();
                Titulo.setTitle("error!");
                Titulo.show();
            }




        });
    }



    public interface OnPasivosResponseListener {
        void onClientGetSuccess(List<Pasivo> cupoRotativos);

        void onClientGetError(String message);
    }




    public void getHistorialContacto(Context context, final ClientService.OnHistorialContactooResponseListener listener){
        Dialog loadingDialog = new Dialog(context,  android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        loadingDialog.setContentView(R.layout.activity_loading_search);
        loadingDialog.setCancelable(false);
        loadingDialog.show();


        searchServicesMockable.getHistorialContacto().enqueue(new Callback<DataHistorialContacto>() {

            @Override
            public void onResponse(Call<DataHistorialContacto> call, Response<DataHistorialContacto> response) {
                loadingDialog.dismiss();
                /*DataHistorialContacto client = response.body();
                if (response.isSuccessful()) {
                    listener.onClientGetSuccess(client.getHistorialContacto());
                } else {
                    listener.onClientGetError("Error en la respuesta");
                }*/
            }

            @Override
            public void onFailure(Call<DataHistorialContacto> call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", " Se obtuvo "+t.getMessage());

                AlertDialog.Builder Bien = new AlertDialog.Builder(context);
                Bien.setMessage("Error al obtener los usuarios"+t.getMessage())
                        .setCancelable(false)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog Titulo = Bien.create();
                Titulo.setTitle("error!");
                Titulo.show();
            }




        });
    }



    public interface OnHistorialContactooResponseListener {
        void onClientGetSuccess(List<Pasivo> cupoRotativos);

        void onClientGetError(String message);
    }


}
