package com.mibanco.customer.data.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.Contacto;

import java.util.List;

public class HistorialContactoAdapter extends RecyclerView.Adapter<HistorialContactoAdapter.HistorialContactoViewHolder> implements View.OnClickListener {
    private LayoutInflater layoutInflater;
    private List<Contacto> contactoList;

    public HistorialContactoAdapter(Context context, List<Contacto> contactoList){
        this.layoutInflater = LayoutInflater.from(context);
        this.contactoList = contactoList;
    }
    @NonNull
    @Override
    public HistorialContactoAdapter.HistorialContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_historial_contacto,parent, false);
        view.setOnClickListener(this);
        return new HistorialContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistorialContactoAdapter.HistorialContactoViewHolder holder, int position) {
        Contacto contacto = contactoList.get(position);
        holder.tipoHistorialContacto.setText(""+contacto.getTipoContacto());
        holder.comentariosHistorialContacto.setText(""+contacto.getResultadoComentarios());
        holder.fechaHistroialContacto.setText(""+contacto.getFecha());

    }

    @Override
    public int getItemCount() {
        return contactoList.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class HistorialContactoViewHolder extends RecyclerView.ViewHolder {

        TextView tipoHistorialContacto, comentariosHistorialContacto, fechaHistroialContacto;
        public HistorialContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            tipoHistorialContacto = itemView.findViewById(R.id.tipoHistorialContacto);
            comentariosHistorialContacto = itemView.findViewById(R.id.resultadoComentariosHistorialContacto);
            fechaHistroialContacto = itemView.findViewById(R.id.fechaHistorialContacto);

        }
    }
}
