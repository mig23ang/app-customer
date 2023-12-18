package com.mibanco.customer.ui.ficsearch.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.data.adapters.CupoRotativoAdapter;
import com.mibanco.customer.data.adapters.HistorialPrestamoAdapter;
import com.mibanco.customer.data.entities.client.fic.Client;
import com.mibanco.customer.data.entities.client.fic.CupoRotativo;
import com.mibanco.customer.databinding.FragmentCupoRotativoBinding;
import com.mibanco.customer.services.ClientService;

;import java.util.ArrayList;
import java.util.List;


public class CupoRotativoFragment extends Fragment implements ClientService.OnCupoRotativoResponseListener {

    CupoRotativoAdapter cupoRotativoAdapter;

    List<CupoRotativo> cupoRotativoList;

    RecyclerView recyclerView;


    TextView back, fullName, phoneCompany;
    private CupoRotativoViewModel cupoRotativoViewModel;
    private FragmentCupoRotativoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cupoRotativoViewModel =
                new ViewModelProvider(this).get(CupoRotativoViewModel.class);

        binding = FragmentCupoRotativoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.recyclerCupoRotativo;
        fullName = binding.fullName;
        phoneCompany = binding.phoneCompany;

        ClientService clientService = new ClientService();
        clientService.getCupoRotativo(getContext(), CupoRotativoFragment.this);

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onClientGetSuccess(List<CupoRotativo> cupoRotativos) {
        Client datosBasicos = (Client) getArguments().getSerializable("datosBasicos");

        fullName.setText(datosBasicos.getNombreCompleto());
        phoneCompany.setText(datosBasicos.getNegocio() != null ? datosBasicos.getNegocio().getTelefono1() : "-");


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        cupoRotativoList = new ArrayList<>();

        cupoRotativoAdapter = new CupoRotativoAdapter(getContext(), cupoRotativos);
        recyclerView.setAdapter(cupoRotativoAdapter);
    }

    @Override
    public void onClientGetError(String message) {

    }
}