package com.mibanco.customer.data.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.Alerta;
import com.mibanco.customer.data.entities.client.fic.Oferta;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpendableOfertasAlertasAdapter extends BaseExpandableListAdapter {

    OfertaAdapter ofertaAdapter;
    AlertaAdapter alertaAdapter;


    private ArrayList<String> listOptions;

    private Map<String, List<Oferta>> mapChild;

    private Map<String, List<Alerta>> mapChild2;

    private Context context;





    public ExpendableOfertasAlertasAdapter(ArrayList<String> listOptions, Map<String, List<Oferta>> mapChild,  Map<String, List<Alerta>> mapChild2, Context context) {
        this.listOptions = listOptions;
        this.mapChild = mapChild;
        this.mapChild2 = mapChild2;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return listOptions.size();
    }

    @Override
    public int getChildrenCount(int i) {
        /*
        Se establece 1 solo por que se están repitiendo las listas de alertas
        y ofertas, esto restringe esa repetición
        */
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return listOptions.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mapChild.get(listOptions.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String tituloOpcion = (String) getGroup(i);
        view = LayoutInflater.from(context).inflate(R.layout.group_ofertas_alertas, null);
        TextView tittle = (TextView) view.findViewById(R.id.textTitleOA);
        tittle.setText(tituloOpcion);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.child_ofertas_alertas, null);
        }

        String groupName = listOptions.get(i);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerOfertas);
        if(groupName.equals("Ofertas")){
            List<Oferta> ofertas = mapChild.get(groupName);



            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));


            ofertaAdapter = new OfertaAdapter(view.getContext(), ofertas);
            recyclerView.setAdapter(ofertaAdapter);

        }else if(groupName.equals("Alertas")){
            List<Alerta> alertaList = mapChild2.get(groupName);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));


            alertaAdapter = new AlertaAdapter(view.getContext(), alertaList);
            recyclerView.setAdapter(alertaAdapter);
        }




        return view;
    }


    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
