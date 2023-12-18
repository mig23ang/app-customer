package com.mibanco.customer.ui.ficsearch.details;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mibanco.customer.R;
import com.mibanco.customer.data.adapters.CentralesRiesgoAdapter;
import com.mibanco.customer.data.adapters.HistorialPrestamoAdapter;
import com.mibanco.customer.data.entities.client.Client;
import com.mibanco.customer.data.entities.client.fic.HistorialPrestamo;
import com.mibanco.customer.databinding.FragmentFicSearchBinding;
import com.mibanco.customer.databinding.FragmentHistorialPrestamosBinding;
import com.mibanco.customer.databinding.FragmentSearchBinding;
import com.mibanco.customer.services.ClientService;

;import java.util.ArrayList;
import java.util.List;


public class HistorialPrestamoFragment extends Fragment implements ClientService.OnHistorialContactoResponseListener {


    HistorialPrestamoAdapter historialPrestamoAdapter;

    List<HistorialPrestamo> historialPrestamoList;

    RecyclerView recyclerView;


    TextView back;
    private HistorialPrestamoViewModel historialPrestamoViewModel;
    private FragmentHistorialPrestamosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historialPrestamoViewModel =
                new ViewModelProvider(this).get(HistorialPrestamoViewModel.class);

        binding = FragmentHistorialPrestamosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.recyclerHistorialPrestamo;


        ClientService clientService = new ClientService();
        clientService.getHistorialContacto(getContext(), HistorialPrestamoFragment.this);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onClientGetSuccess(List<HistorialPrestamo> historial) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        historialPrestamoList = new ArrayList<>();

        historialPrestamoAdapter = new HistorialPrestamoAdapter(getContext(), historial);
        recyclerView.setAdapter(historialPrestamoAdapter);
    }

    @Override
    public void onClientGetError(String message) {

    }
}