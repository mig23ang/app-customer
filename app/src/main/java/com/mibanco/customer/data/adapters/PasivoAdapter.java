package com.mibanco.customer.data.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.Pasivo;

import java.io.Serializable;
import java.util.List;

public class PasivoAdapter extends RecyclerView.Adapter<PasivoAdapter.PasivoViewHolder> implements View.OnClickListener {


    private LayoutInflater layoutInflater;

    private List<Pasivo> pasivoList;


    public PasivoAdapter(Context context, List<Pasivo> pasivoList)
    {
        this.layoutInflater = LayoutInflater.from(context);

        this.pasivoList = pasivoList;

    }
    @NonNull
    @Override
    public PasivoAdapter.PasivoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_pasivo,parent, false);
        view.setOnClickListener(this);
        return new PasivoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PasivoAdapter.PasivoViewHolder holder, int position) {
        Pasivo pasivo = pasivoList.get(position);
        holder.numeroProducto.setText(pasivo.getNumeroProducto());
        holder.capitalPasivo.setText(""+pasivo.getCapital());
        holder.estadoPasivo.setText(pasivo.getEstado());
        holder.tipoProducto.setText("Producto: "+pasivo.getTipoProducto());
        holder.detalleTipoProducto.setText(pasivo.getDetalleTipoProducto());
        holder.fechaApertura.setText(pasivo.getFechaApertura());
        holder.fechaCierre.setText(pasivo.getFechaCierre());
        holder.interesPasivo.setText(""+pasivo.getIntereses());
        holder.otrosPasivos.setText(""+pasivo.getOtros());
        holder.saldoTotal.setText(""+pasivo.getSaldoTotal());
    }

    @Override
    public int getItemCount() {
        return pasivoList.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class PasivoViewHolder extends RecyclerView.ViewHolder {
        TextView numeroProducto, capitalPasivo, estadoPasivo, tipoProducto, detalleTipoProducto, fechaApertura, fechaCierre, interesPasivo, otrosPasivos,saldoTotal;

        public PasivoViewHolder(@NonNull View itemView) {
            super(itemView);

            numeroProducto = itemView.findViewById(R.id.numeroProducto);
            capitalPasivo = itemView.findViewById(R.id.capitalPasivo);
            estadoPasivo = itemView.findViewById(R.id.estadoPasivo);
            tipoProducto = itemView.findViewById(R.id.tipoProducto);
            detalleTipoProducto = itemView.findViewById(R.id.detalleTipoProducto);
            fechaApertura = itemView.findViewById(R.id.fechaAperturaPasivo);
            fechaCierre = itemView.findViewById(R.id.fechaCierre);
            interesPasivo = itemView.findViewById(R.id.interesesPasivo);
            otrosPasivos = itemView.findViewById(R.id.otrosPasivos);
            saldoTotal = itemView.findViewById(R.id.saldoTotalPasivo);

        }
    }
}
