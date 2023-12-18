package com.mibanco.customer.data.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.Oferta;

import java.util.List;

public class OfertaAdapter extends RecyclerView.Adapter<OfertaAdapter.OfertaViewHolder> implements View.OnClickListener {

    TextView categoryOfertDetails, oferttypedetails, plazoOfertaDetails, tipoLigaOfertaDetails, condicionesGarantiaOfertaDetails, MontoOfertaDetails;
    private LayoutInflater layoutInflater;
    private List<Oferta> ofertaList;

    public OfertaAdapter(Context context, List<Oferta> ofertaList) {
        this.layoutInflater= LayoutInflater.from(context);
        this.ofertaList = ofertaList;
    }

    @Override
    public void onClick(View view) {

        BottomSheetDialog dialog = new BottomSheetDialog(view.getContext());
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_dialog_details, null);
        categoryOfertDetails = inflate.findViewById(R.id.categoryOfertDetails);
        oferttypedetails = inflate.findViewById(R.id.ofertTypeDetails);
        plazoOfertaDetails = inflate.findViewById(R.id.plazoOfertaDetails);
        tipoLigaOfertaDetails = inflate.findViewById(R.id.tipoLigaOfertaDetails);
        condicionesGarantiaOfertaDetails = inflate.findViewById(R.id.condicionGarantiaOfertdetails);
        MontoOfertaDetails = inflate.findViewById(R.id.montoOfertaDetails);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.show();

    }

    @NonNull
    @Override
    public OfertaAdapter.OfertaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_oferta,parent, false);
        view.setOnClickListener(this);
        return new OfertaAdapter.OfertaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfertaAdapter.OfertaViewHolder holder, int position) {
        Oferta oferta = ofertaList.get(position);
        holder.categotyOfert.setText(oferta.getCategoria());
        holder.optionOfert.setText(oferta.getOpcion());

        //holder.itemView.setOnClickListener(view -> onItemClicked(position, holder.itemView));
        //holder.monto.setText(oferta.getMonto());
        //holder.plazo.setText(oferta.getPlazo());

    }

    private void onItemClicked(int position, View view) {


    }

    @Override
    public int getItemCount() {
        return ofertaList.size();
    }


    public static class OfertaViewHolder extends  RecyclerView.ViewHolder {
        TextView categotyOfert, optionOfert, monto, plazo;
        ConstraintLayout item_click;

        public OfertaViewHolder(@NonNull View itemView) {
            super(itemView);
            categotyOfert = itemView.findViewById(R.id.categoryOfert);
            optionOfert = itemView.findViewById(R.id.optionOfert);
            monto = itemView.findViewById(R.id.montoOferta);
            plazo = itemView.findViewById(R.id.plazo);
            item_click = itemView.findViewById(R.id.item_ofert_click);

        }
    }
}
