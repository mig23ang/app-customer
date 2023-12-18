package com.mibanco.customer.data.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.Client;
import com.mibanco.customer.data.entities.client.fic.DataClients;
import com.mibanco.customer.services.SearchService;

import java.util.List;

public class ClientOptionsAdapter extends RecyclerView.Adapter<ClientOptionsAdapter.ClientViewHolder> implements View.OnClickListener{


    private LayoutInflater layoutInflater;
    private List<Client> clientList;


    public ClientOptionsAdapter(Context context, List<Client> clientList) {
        this.layoutInflater= LayoutInflater.from(context);
        this.clientList = clientList;
    }


    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public ClientOptionsAdapter.ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_client_menu,parent, false);
        view.setOnClickListener(this);
        return new ClientOptionsAdapter.ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientOptionsAdapter.ClientViewHolder holder, int position) {
        Client client =  clientList.get(position);
        holder.nameClientMenu.setText(client.getNombreCompleto());
        holder.phoneCompanyClientMenu.setText("Teléfono del negocio: "+ client.getTelefono1());
        holder.datosBasicosclientMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    int clickedPosition = holder.getAdapterPosition();
                    Client clickedClient = clientList.get(clickedPosition);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("datosBasicos", clickedClient);
                    Navigation.findNavController(view)
                            .navigate(R.id.datosBasicosFragment, bundle);

                }catch (Exception e){
                    Toast.makeText(view.getContext(), "Opción no disponible", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.ofertasAlertasClientMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(client.getOfertasAlertas() != null){
                        int clickedPosition = holder.getAdapterPosition();
                        Client clickedClient = clientList.get(clickedPosition);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("datosBasicos", clickedClient);
                        Navigation.findNavController(view)
                                .navigate(R.id.ofertaAlertaFragment, bundle);
                    }else{
                        Toast.makeText(view.getContext(), "Opción no disponible", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(view.getContext(), "Opción no disponible", Toast.LENGTH_SHORT).show();
                }
            }


        });



        holder.centralesRiesgoClientMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(client.getCentralesRiesgo() != null) {
                        int clickedPosition = holder.getAdapterPosition();
                        Client clickedClient = clientList.get(clickedPosition);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("datosBasicos", clickedClient);
                        Navigation.findNavController(view)
                                .navigate(R.id.centralesRiesgoFragment, bundle);
                    }else{
                        Toast.makeText(view.getContext(), "Opción no disponible", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(view.getContext(), "Opción no disponible", Toast.LENGTH_SHORT).show();
                }

            }
        });

        holder.historialPrestamosClientMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{


                    int clickedPosition = holder.getAdapterPosition();
                    Client clickedClient = clientList.get(clickedPosition);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("datosBasicos", clickedClient);
                    Navigation.findNavController(view)
                            .navigate(R.id.historialPrestamoFragment, bundle);

                }catch (Exception e){
                    Toast.makeText(view.getContext(), "Opción no disponible", Toast.LENGTH_SHORT).show();
                }

            }
        });



        holder.cupoRotativoClientMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{


                    int clickedPosition = holder.getAdapterPosition();
                    Client clickedClient = clientList.get(clickedPosition);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("datosBasicos", clickedClient);
                    Navigation.findNavController(view)
                            .navigate(R.id.cupoRotativoFragment, bundle);

                }catch (Exception e){
                    Toast.makeText(view.getContext(), "Opción no disponible", Toast.LENGTH_SHORT).show();
                }

            }
        });




        holder.pasivosClientMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int clickedPosition = holder.getAdapterPosition();
                    Client clickedClient = clientList.get(clickedPosition);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("datosBasicos", clickedClient);
                    Navigation.findNavController(view)
                            .navigate(R.id.pasivosFragment, bundle);

                }catch (Exception e){
                    Toast.makeText(view.getContext(), "Opción no disponible", Toast.LENGTH_SHORT).show();
                }

            }
        });


        //holder.phoneCompanyClientMenu.setText(client.getNegocio().getTelefono1());
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    public static class ClientViewHolder extends RecyclerView.ViewHolder {
        TextView nameClientMenu, phoneCompanyClientMenu, datosBasicosclientMenu;
        TextView ofertasAlertasClientMenu, centralesRiesgoClientMenu, historialPrestamosClientMenu;
        TextView cupoRotativoClientMenu, pasivosClientMenu, historialContactosClientMenu;
        TextView pqrClientMenu;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            nameClientMenu = itemView.findViewById(R.id.name_client_menu);
            phoneCompanyClientMenu = itemView.findViewById(R.id.phone_company_client_menu);
            datosBasicosclientMenu = itemView.findViewById(R.id.datosBasicosClientMenu);
            ofertasAlertasClientMenu = itemView.findViewById(R.id.ofertasAlertasClientMenu);
            centralesRiesgoClientMenu = itemView.findViewById(R.id.centralesRiesgoClientMenu);
            historialPrestamosClientMenu = itemView.findViewById(R.id.historialPrestamosClientMenu);
            cupoRotativoClientMenu = itemView.findViewById(R.id.cupoRotativoClientMenu);
            pasivosClientMenu = itemView.findViewById(R.id.pasivosClientMenu);
            historialContactosClientMenu = itemView.findViewById(R.id.historialContactoClientMenu);
            pqrClientMenu = itemView.findViewById(R.id.pqrClientMenu);
        
            datosBasicosclientMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                }
            });
        }
    }

}
