package com.mibanco.customer.ui.ficsearch.details;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.mibanco.customer.R;
import com.mibanco.customer.data.adapters.ClientDataAdapter;
import com.mibanco.customer.data.adapters.ExpendableOfertasAlertasAdapter;
import com.mibanco.customer.databinding.FragmentFicSearchBinding;
import com.mibanco.customer.databinding.FragmentOfertaAlertaBinding;

;import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class OfertaAlertaFragment extends Fragment {
    private ExpandableListView options;
    private ExpendableOfertasAlertasAdapter adapter;
    private ArrayList<String> listOptions;
    private Map<String, ArrayList<String>> mapChild;

    private OfertaAlertaViewModel ficSearchViewModel;
    private FragmentOfertaAlertaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ficSearchViewModel =
                new ViewModelProvider(this).get(OfertaAlertaViewModel.class);

        binding = FragmentOfertaAlertaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        options = binding.expandableListOfertasAlertas;
        listOptions = new ArrayList<>();
        mapChild=new HashMap<>();
        cargarDatosBasicos();


        return root;
    }


    private void cargarDatosBasicos(){
        ArrayList<String> ofertas = new ArrayList<>();
        ArrayList<String> alertas = new ArrayList<>();

        listOptions.add("Ofertas");
        listOptions.add("Alertas");

        ofertas.add("No hay ofertas registradas");
        alertas.add("No hay Alertas registradas");




        mapChild.put(listOptions.get(0), ofertas);


        mapChild.put(listOptions.get(1), alertas);

        adapter = new ExpendableOfertasAlertasAdapter( listOptions, mapChild,getContext());
        options.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}