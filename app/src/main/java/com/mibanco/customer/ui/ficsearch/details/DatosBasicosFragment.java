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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;
import com.mibanco.customer.databinding.FragmentDatosBasicosBinding;
import com.mibanco.customer.databinding.FragmentFicSearchBinding;
import com.mibanco.customer.databinding.FragmentSearchBinding;
import com.mibanco.customer.ui.search.ClientMenuViewModel;

;


public class DatosBasicosFragment extends Fragment {
    TextView tipoDocumeto, documeto, numeroDocumento, nombreCompleto, correo, estadoCivil, activos;
    private DatosBasicosViewModel datosBasicosViewModel;
    private FragmentDatosBasicosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        datosBasicosViewModel =
                new ViewModelProvider(this).get(DatosBasicosViewModel.class);

        binding = FragmentDatosBasicosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tipoDocumeto = binding.tipeDocument;
        documeto = binding.document;
        numeroDocumento = binding.numberClient;
        nombreCompleto = binding.numberClient;
        correo = binding.email;
        estadoCivil = binding.estadoCivil;
        activos = binding.totalActivos;

        ClientMenuViewModel clientMenuViewModel = new ViewModelProvider(requireActivity()).get(ClientMenuViewModel.class);
        InformacionPrincipal informacionPrincipal = clientMenuViewModel.getInformacionPrincipal().getValue();
        if(informacionPrincipal != null){
            nombreCompleto.setText(informacionPrincipal.getRazonSocial());
            estadoCivil.setText(informacionPrincipal.getEstadoCivil());
            activos.setText(informacionPrincipal.getTotalActivos());
        }else{
            Toast.makeText(getContext(), "Los datos compartidos aún no se ven...", Toast.LENGTH_SHORT).show();
        }

        clientMenuViewModel.getInformacionPrincipal().observe(getViewLifecycleOwner(), new Observer<InformacionPrincipal>() {
            @Override
            public void onChanged(InformacionPrincipal info) {
                nombreCompleto.setText(info.getRazonSocial());
                estadoCivil.setText(info.getEstadoCivil());
                activos.setText(info.getTotalActivos());
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}