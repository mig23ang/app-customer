package com.mibanco.customer.data.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.Alerta;

import java.util.List;

public class AlertaAdapter extends RecyclerView.Adapter<AlertaAdapter.AlertaViewModel> implements View.OnClickListener {

    private LayoutInflater layoutInflater;
    private List<Alerta> alertaList;

    public AlertaAdapter(Context context, List<Alerta> alertaList){
        this.layoutInflater= LayoutInflater.from(context);
        this.alertaList = alertaList;
    }


    @NonNull
    @Override
    public AlertaAdapter.AlertaViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_alerta,parent, false);
        view.setOnClickListener(this);
        return new AlertaAdapter.AlertaViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlertaAdapter.AlertaViewModel holder, int position) {
        Alerta alerta = alertaList.get(position);
        holder.alertType.setText(alerta.getTipo());
        holder.bamcoAlert.setText(alerta.getBanco());
        holder.fechaAlert.setText(alerta.getFecha());

    }

    @Override
    public int getItemCount() {
        return alertaList.size();
    }

    @Override
    public void onClick(View view) {

    }


    public static class AlertaViewModel extends  RecyclerView.ViewHolder {
        TextView alertType, bamcoAlert, fechaAlert;
        public AlertaViewModel(@NonNull View itemView) {
            super(itemView);
            alertType = itemView.findViewById(R.id.alertType);
            bamcoAlert = itemView.findViewById(R.id.bancoAlert);
            fechaAlert = itemView.findViewById(R.id.fechaAlert);
        }
    }
}
