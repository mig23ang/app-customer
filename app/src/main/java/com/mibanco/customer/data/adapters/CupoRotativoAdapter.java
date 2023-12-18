package com.mibanco.customer.data.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.CupoRotativo;

import java.util.List;

public class CupoRotativoAdapter extends RecyclerView.Adapter<CupoRotativoAdapter.CupoRotativoViewHolder> implements View.OnClickListener {
    private LayoutInflater layoutInflater;

    private List<CupoRotativo> cupoRotativoList;


    public CupoRotativoAdapter(Context context, List<CupoRotativo> cupoRotativoList){
        this.layoutInflater = LayoutInflater.from(context);
        this.cupoRotativoList = cupoRotativoList;
    }


    @NonNull
    @Override
    public CupoRotativoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_cupo_rotativo,parent, false);
        view.setOnClickListener(this);
        return new CupoRotativoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CupoRotativoAdapter.CupoRotativoViewHolder holder, int position) {
        CupoRotativo cupoRotativo = cupoRotativoList.get(position);

    }



    @Override
    public int getItemCount() {
        return cupoRotativoList.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class CupoRotativoViewHolder extends RecyclerView.ViewHolder {
        public CupoRotativoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
