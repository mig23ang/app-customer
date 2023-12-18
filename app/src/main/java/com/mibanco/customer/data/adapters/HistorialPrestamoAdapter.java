package com.mibanco.customer.data.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.HistorialPrestamo;

import java.util.List;


public class HistorialPrestamoAdapter extends RecyclerView.Adapter<HistorialPrestamoAdapter.HistorialPrestamoViewHolder> implements View.OnClickListener {

    private LayoutInflater layoutInflater;

    private List<HistorialPrestamo> historialPrestamoList;

    public HistorialPrestamoAdapter(Context context, List<HistorialPrestamo> historialPrestamoList){
        this.historialPrestamoList = historialPrestamoList;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public HistorialPrestamoAdapter.HistorialPrestamoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_historial_prestamo,parent, false);
        view.setOnClickListener(this);
        return new HistorialPrestamoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistorialPrestamoAdapter.HistorialPrestamoViewHolder holder, int position) {
        HistorialPrestamo historialPrestamo = historialPrestamoList.get(position);

        holder.numeroPrestamo.setText(historialPrestamo.getNumeroPrestamo());

        holder.producto.setText(historialPrestamo.getNombreProducto());

        holder.estado.setText(historialPrestamo.getEstado());

        //holder.montoDesembolsado.setText(historialPrestamo.getMontoDesembolsado());

        holder.fechaDesembolso.setText(historialPrestamo.getFechaDesembolso());


    }

    @Override
    public int getItemCount() {
        return historialPrestamoList.size();
    }

    @Override
    public void onClick(View view) {

    }

    public static class HistorialPrestamoViewHolder extends RecyclerView.ViewHolder {

        TextView numeroPrestamo, producto,estado,montoDesembolsado, fechaDesembolso;

        public HistorialPrestamoViewHolder(@NonNull View itemView) {
            super(itemView);
            numeroPrestamo = itemView.findViewById(R.id.numeroPrestamo);
            producto = itemView.findViewById(R.id.producto);
            estado = itemView.findViewById(R.id.estado);
            montoDesembolsado = itemView.findViewById(R.id.montoDesmbolsado);
            fechaDesembolso =itemView.findViewById(R.id.fechaDesembolso);

        }
    }
}
