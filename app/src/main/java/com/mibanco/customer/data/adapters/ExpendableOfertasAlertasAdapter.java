package com.mibanco.customer.data.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mibanco.customer.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;

public class ExpendableOfertasAlertasAdapter extends BaseExpandableListAdapter {

    private ArrayList<String> listOptions;

    private Map<String, ArrayList<String>> mapChild;

    private Context context;



    public ExpendableOfertasAlertasAdapter(ArrayList<String> listOptions, Map<String, ArrayList<String>> mapChild, Context context) {
        this.listOptions = listOptions;
        this.mapChild = mapChild;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return listOptions.size();
    }

    @Override
    public int getChildrenCount(int i) {

        return mapChild.get(listOptions.get(i)).size();
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
        String item  = (String) getChild(i, i1);




        view = LayoutInflater.from(context).inflate(R.layout.child_ofertas_alertas, null);
        TextView tittle =  view.findViewById(R.id.titleOA);

        tittle.setText(item);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
