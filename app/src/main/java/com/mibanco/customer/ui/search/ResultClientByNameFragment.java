package com.mibanco.customer.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mibanco.customer.databinding.FragmentLibraryBinding;
import com.mibanco.customer.databinding.FragmentResultClientByNameBinding;

;


public class ResultClientByNameFragment extends Fragment {
    private ResultClientByNameViewModel resultClientByNameViewModel;
    private FragmentResultClientByNameBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        resultClientByNameViewModel =
                new ViewModelProvider(this).get(ResultClientByNameViewModel.class);

        binding = FragmentResultClientByNameBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}