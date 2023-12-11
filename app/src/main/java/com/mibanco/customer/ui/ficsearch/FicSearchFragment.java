package com.mibanco.customer.ui.ficsearch;

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
import com.mibanco.customer.databinding.FragmentSearchBinding;

;


public class FicSearchFragment extends Fragment {
    TextView back;
    private FicSearchViewModel ficSearchViewModel;
    private FragmentFicSearchBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ficSearchViewModel =
                new ViewModelProvider(this).get(FicSearchViewModel.class);

        binding = FragmentFicSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        back = binding.back;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.fragment);
                navController.navigateUp();
            }
        });
        try{
            NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.fragment_search);
            NavController navController = navHostFragment.getNavController();
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.searchByIdFragment, R.id.searchByNameFragment).build();
            NavigationUI.setupWithNavController(binding.navigationSearch, navController);
        }catch (Exception e){
            Log.e("Error",""+e);
            AlertDialog.Builder Bien = new AlertDialog.Builder(getContext());
            Bien.setMessage(""+e)
                    .setCancelable(false)
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            AlertDialog Titulo = Bien.create();
            Titulo.setTitle("error!");
            Titulo.show();
        }


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}