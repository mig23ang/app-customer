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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mibanco.customer.R;
import com.mibanco.customer.databinding.FragmentFicSearchBinding;
import com.mibanco.customer.databinding.FragmentHistorialPrestamosBinding;
import com.mibanco.customer.databinding.FragmentSearchBinding;

;


public class HistorialPrestamoFragment extends Fragment {
    TextView back;
    private HistorialPrestamoViewModel historialPrestamoViewModel;
    private FragmentHistorialPrestamosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historialPrestamoViewModel =
                new ViewModelProvider(this).get(HistorialPrestamoViewModel.class);

        binding = FragmentHistorialPrestamosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}