package com.mibanco.customer.data.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.CentralRiesgo;

import org.w3c.dom.Text;

import java.util.List;

public class CentralesRiesgoAdapter extends RecyclerView.Adapter<CentralesRiesgoAdapter.CentralrisgoViewHolder> implements View.OnClickListener {

    private LayoutInflater layoutInflater;
    private List<CentralRiesgo> centralRiesgoList;

    public CentralesRiesgoAdapter(Context context, List<CentralRiesgo> centralRiesgoList){
        this.centralRiesgoList = centralRiesgoList;
        this.layoutInflater= LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public CentralesRiesgoAdapter.CentralrisgoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_central_riesgo,parent, false);
        view.setOnClickListener(this);
        return new CentralrisgoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CentralesRiesgoAdapter.CentralrisgoViewHolder holder, int position) {
        CentralRiesgo centralRiesgo = centralRiesgoList.get(position);
        holder.personaCentralRiesgo.setText(centralRiesgo.getPersona());
        holder.fechaConsultaCentralRiesgo.setText(centralRiesgo.getFechaConsultaReciente());
        holder.resultadoCentralRiesgo.setText(centralRiesgo.getResultadoConsultaReciente());
        holder.vbConsulta.setText(centralRiesgo.getVbConsulta());
    }

    @Override
    public int getItemCount() {
        return centralRiesgoList.size();
    }

    @Override
    public void onClick(View view) {

    }


    public static class CentralrisgoViewHolder extends RecyclerView.ViewHolder {

        TextView personaCentralRiesgo, fechaConsultaCentralRiesgo, resultadoCentralRiesgo, vbConsulta;

        public CentralrisgoViewHolder(@NonNull View itemView) {
            super(itemView);
            personaCentralRiesgo = itemView.findViewById(R.id.person_central_riesgo);
            fechaConsultaCentralRiesgo = itemView.findViewById(R.id.fechaConsultaRecienteCentralRiesgo);
            resultadoCentralRiesgo = itemView.findViewById(R.id.resultadoConsultaRecienteCentralRiesgo);
            vbConsulta = itemView.findViewById(R.id.vbConsultaCentralRiesgo);

        }
    }
}
