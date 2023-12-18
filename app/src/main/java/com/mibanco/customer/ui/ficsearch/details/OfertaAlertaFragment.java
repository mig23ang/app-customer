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
import com.mibanco.customer.data.entities.client.fic.Alerta;
import com.mibanco.customer.data.entities.client.fic.Client;
import com.mibanco.customer.data.entities.client.fic.Oferta;
import com.mibanco.customer.databinding.FragmentFicSearchBinding;
import com.mibanco.customer.databinding.FragmentOfertaAlertaBinding;

;import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OfertaAlertaFragment extends Fragment {
    private ExpandableListView options;
    private ExpendableOfertasAlertasAdapter adapter;
    private ArrayList<String> listOptions;
    private Map<String, List<Oferta>> mapChild;
    private Map<String, List<Alerta>> mapChild2;

    private OfertaAlertaViewModel ficSearchViewModel;
    private FragmentOfertaAlertaBinding binding;


    TextView fullName, phoneCompany;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ficSearchViewModel =
                new ViewModelProvider(this).get(OfertaAlertaViewModel.class);

        binding = FragmentOfertaAlertaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        fullName = binding.fullName;
        phoneCompany = binding.phoneCompany;
        options = binding.expandableListOfertasAlertas;
        listOptions = new ArrayList<>();
        mapChild=new HashMap<>();
        mapChild2=new HashMap<>();
        cargarDatosBasicos();


        return root;
    }


    private void cargarDatosBasicos() {
        Client datosBasicos = (Client) getArguments().getSerializable("datosBasicos");
        fullName.setText(datosBasicos.getNombreCompleto());
        phoneCompany.setText(datosBasicos.getNegocio() != null ? datosBasicos.getNegocio().getTelefono1() : "-");
        List<Oferta> ofertaList = datosBasicos.getOfertasAlertas().getOfertas();
        List<Alerta> alertaList = datosBasicos.getOfertasAlertas().getAlertas();

        listOptions.add("Ofertas");
        listOptions.add("Alertas");

        mapChild.clear();
        mapChild.put(listOptions.get(0), ofertaList);
        mapChild2.put(listOptions.get(1), alertaList);

        adapter = new ExpendableOfertasAlertasAdapter(listOptions, mapChild, mapChild2,getContext());
        options.setAdapter(adapter);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}