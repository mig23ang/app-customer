package com.mibanco.customer.ui.search;

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
import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;
import com.mibanco.customer.databinding.FragmentClientMenuBinding;
import com.mibanco.customer.databinding.FragmentLibraryBinding;

;


public class ClientMenuFragment extends Fragment {

    TextView title_name_menu_name, title_phone_menu_number, back_details;
    private ClientMenuViewModel clientMenuViewModel;
    private FragmentClientMenuBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        clientMenuViewModel =
                new ViewModelProvider(this).get(ClientMenuViewModel.class);

        binding = FragmentClientMenuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        title_name_menu_name = binding.titleNameMenuName;
        title_phone_menu_number = binding.titlePhoneMenuNumber;
        back_details = binding.backDetails;

        back_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.fragment);
                navController.navigateUp();
            }
        });



        try{
            NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.fragment_fic);
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupWithNavController(binding.navigationDetails, navController);
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
        if (getArguments() != null) {
            InformacionPrincipal informacionPrincipal = (InformacionPrincipal) getArguments().getSerializable("clientDetails");
            clientMenuViewModel.setInformacionPrincipal(informacionPrincipal);

            String documento = getArguments().getString("clientDetailsDocumento");
            String tipoDocumento = getArguments().getString("clientDetailsTipoDocumento");
            title_name_menu_name.setText(informacionPrincipal.getRazonSocial());
            title_phone_menu_number.setText(tipoDocumento + " " + documento);
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}