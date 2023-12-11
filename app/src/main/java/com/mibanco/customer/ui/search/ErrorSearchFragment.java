package com.mibanco.customer.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mibanco.customer.databinding.FragmentErrorSeachBinding;
import com.mibanco.customer.databinding.FragmentLibraryBinding;

;


public class ErrorSearchFragment extends Fragment {
    private ErrorSearchViewModel ErrorSearchViewModel;
    private FragmentErrorSeachBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ErrorSearchViewModel =
                new ViewModelProvider(this).get(ErrorSearchViewModel.class);

        binding = FragmentErrorSeachBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}