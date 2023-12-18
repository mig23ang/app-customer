package com.mibanco.customer.ui.ficsearch.details;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.R;
import com.mibanco.customer.data.adapters.CentralesRiesgoAdapter;
import com.mibanco.customer.data.adapters.ClientOptionsAdapter;
import com.mibanco.customer.data.entities.client.fic.CentralRiesgo;
import com.mibanco.customer.data.entities.client.fic.Client;
import com.mibanco.customer.databinding.FragmentCentralesRiesgoBinding;
import com.mibanco.customer.databinding.FragmentFicSearchBinding;

;import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class CentralesRiesgoFragment extends Fragment {
    TextView fullName, phoneCompany;
    CentralesRiesgoAdapter centralesRiesgoAdapter;

    List<CentralRiesgo> centralRiesgoList;

    RecyclerView recyclerView;
    private CentralesRiesgoViewModel ficSearchViewModel;
    private FragmentCentralesRiesgoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ficSearchViewModel =
                new ViewModelProvider(this).get(CentralesRiesgoViewModel.class);

        binding = FragmentCentralesRiesgoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.recyclerCentralesRiesgo;
        fullName = binding.fullName;
        phoneCompany = binding.phoneCompany;

        cargarlista();

        return root;
    }

    private void cargarlista() {

        Client datosBasicos = (Client) getArguments().getSerializable("datosBasicos");
        List<CentralRiesgo> centralRiesgos = datosBasicos.getCentralesRiesgo();
        fullName.setText(datosBasicos.getNombreCompleto());
        phoneCompany.setText(datosBasicos.getNegocio() != null ? datosBasicos.getNegocio().getTelefono1() : "-");


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        centralRiesgoList = new ArrayList<>();

        centralesRiesgoAdapter = new CentralesRiesgoAdapter(getContext(), centralRiesgos);
        recyclerView.setAdapter(centralesRiesgoAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}