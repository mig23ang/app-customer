package com.mibanco.customer.ui.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.mibanco.customer.R;
import com.mibanco.customer.databinding.FragmentHomeBinding;
import com.mibanco.customer.databinding.FragmentLibraryBinding;

;


public class LibraryFragment extends Fragment {

    TextView ficSearchClient;
    private LibraryViewModel libraryViewModel;
    private FragmentLibraryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        libraryViewModel =
                new ViewModelProvider(this).get(LibraryViewModel.class);

        binding = FragmentLibraryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ficSearchClient = binding.ficSearchFragment;
        ficSearchClient.setOnClickListener(new View.OnClickListener() {
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