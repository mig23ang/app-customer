package com.mibanco.customer.ui.ficsearch.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mibanco.customer.databinding.FragmentCupoRotativoBinding;

;


public class CupoRotativoFragment extends Fragment {
    TextView back;
    private CupoRotativoViewModel cupoRotativoViewModel;
    private FragmentCupoRotativoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cupoRotativoViewModel =
                new ViewModelProvider(this).get(CupoRotativoViewModel.class);

        binding = FragmentCupoRotativoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}