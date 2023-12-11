package com.mibanco.customer.data.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.Client;
import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;
import com.mibanco.customer.services.SearchService;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> implements View.OnClickListener {
    private LayoutInflater layoutInflater;
    //private View.OnClickListener listener;
    private SearchService.OnClientSearchByIdResponseListener listener;
    private List<Client> clientList;

    public ClientAdapter(Context context, List<Client> clientList, SearchService.OnClientSearchByIdResponseListener listener) {
        this.layoutInflater= LayoutInflater.from(context);
        this.clientList = clientList;
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public ClientAdapter.ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_client_by_name,parent, false);
        view.setOnClickListener(this);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientAdapter.ClientViewHolder holder, int position) {
        Client client =  clientList.get(position);
        holder.nameClient.setText(client.getNombreCompleto());
        holder.documentClient.setText(client.getNumeroDocumento());
        holder.tipeDocument.setText(client.getTipoDocumento());
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }



    public class ClientViewHolder extends RecyclerView.ViewHolder {
        TextView nameClient, documentClient, tipeDocument;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            nameClient = itemView.findViewById(R.id.itemclientnamebyname);
            documentClient = itemView.findViewById(R.id.itemclientidbyname);
            tipeDocument = itemView.findViewById(R.id.itemclienttipeidbyname);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(itemView.getContext(), "documento: "+ documentClient.getText().toString(), Toast.LENGTH_SHORT).show();
                    SearchService searchService = new SearchService();
                    searchService.getClientsByDocument(tipeDocument.getText().toString(), documentClient.getText().toString(), itemView.getContext(), listener);
                }
            });
        }
    }
}
