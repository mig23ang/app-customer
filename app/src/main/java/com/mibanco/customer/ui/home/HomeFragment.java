package com.mibanco.customer.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


import com.mibanco.customer.R;
import com.mibanco.customer.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    TextView fichaIntegralCliente, probarMenu;


    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        probarMenu = binding.probarsinapi;
        fichaIntegralCliente = binding.btnhomelastvisited;


        probarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("clientDetailsTipoDocumento", "CC");
                bundle.putString("clientDetailsDocumento", "123456789");
                Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.clientMenuFragment, bundle);

            }
        });
        fichaIntegralCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.ficSearchFragment);
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