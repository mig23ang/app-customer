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
import com.mibanco.customer.data.adapters.HistorialPrestamoAdapter;
import com.mibanco.customer.data.adapters.PasivoAdapter;
import com.mibanco.customer.data.entities.client.fic.Client;
import com.mibanco.customer.data.entities.client.fic.Pasivo;
import com.mibanco.customer.databinding.FragmentCentralesRiesgoBinding;
import com.mibanco.customer.databinding.FragmentFicSearchBinding;
import com.mibanco.customer.databinding.FragmentPasivosBinding;
import com.mibanco.customer.services.ClientService;

;import java.util.ArrayList;
import java.util.List;


public class PasivosFragment extends Fragment implements ClientService.OnPasivosResponseListener {

    TextView fullName, phoneCompany;

    PasivoAdapter pasivoAdapter;

    List<Pasivo> pasivoList;

    RecyclerView recyclerView;



     private PasivosViewModel pasivosViewModel;
    private FragmentPasivosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pasivosViewModel =
                new ViewModelProvider(this).get(PasivosViewModel.class);

        binding = FragmentPasivosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.recyclerPasivos;
        fullName = binding.fullName;
        phoneCompany = binding.phoneCompany;

        ClientService clientService = new ClientService();

        clientService.getPasivos(getContext(), PasivosFragment.this);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onClientGetSuccess(List<Pasivo> pasivo) {

        Client datosBasicos = (Client) getArguments().getSerializable("datosBasicos");
        fullName.setText(datosBasicos.getNombreCompleto());
        phoneCompany.setText(datosBasicos.getNegocio() != null ? datosBasicos.getNegocio().getTelefono1() : "-");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        pasivoList = new ArrayList<>();

        pasivoAdapter = new PasivoAdapter(getContext(), pasivo);
        recyclerView.setAdapter(pasivoAdapter);
    }

    @Override
    public void onClientGetError(String message) {

    }
}