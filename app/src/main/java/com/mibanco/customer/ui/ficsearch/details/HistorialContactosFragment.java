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

import com.mibanco.customer.R;
import com.mibanco.customer.databinding.FragmentCentralesRiesgoBinding;
import com.mibanco.customer.databinding.FragmentFicSearchBinding;
import com.mibanco.customer.databinding.FragmentHistorialContactoBinding;

;


public class HistorialContactosFragment extends Fragment {
    private HistorialContactosoViewModel historialContactosoViewModel;
    private FragmentHistorialContactoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historialContactosoViewModel =
                new ViewModelProvider(this).get(HistorialContactosoViewModel.class);

        binding = FragmentHistorialContactoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}