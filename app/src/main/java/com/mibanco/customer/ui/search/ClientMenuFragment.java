package com.mibanco.customer.ui.search;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;
import com.mibanco.customer.databinding.FragmentClientMenuBinding;
import com.mibanco.customer.databinding.FragmentLibraryBinding;

;


public class ClientMenuFragment extends Fragment {

    LinearLayout datosBasicos, ofertasAlertas, centralesRiesgo, historialPrestamos, cupoRotativo, pasivos, historialContacto, pqr;

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
        datosBasicos = binding.datosBasicos;
        ofertasAlertas = binding.ofertasAlertas;
        centralesRiesgo = binding.centralesRiesgo;
        historialPrestamos = binding.historialPrestamos;
        cupoRotativo = binding.cupoRotativo;
        pasivos = binding.pasivos;
        historialContacto = binding.historialContacto;
        pqr = binding.pqr;


        pqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.pqrFragment);

            }
        });

        historialContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.historialContactoFragment);

            }
        });

        pasivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.pasivosFragment);

            }
        });
        cupoRotativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.cupoRotativoFragment);

            }
        });

        historialPrestamos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.historialPrestamoFragment);
            }
        });

        centralesRiesgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.centralesRiesgoFragment);
            }
        });

        ofertasAlertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.ofertaAlertaFragment);
            }
        });
        datosBasicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.datosBasicosFragment);
            }
        });
        back_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.fragment);
                navController.navigateUp();
            }
        });



        try{

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
            ClientMenuViewModel clientMenuViewModel1 = new ViewModelProvider(getActivity()).get(ClientMenuViewModel.class);
            InformacionPrincipal informacionPrincipal = (InformacionPrincipal) getArguments().getSerializable("clientDetails");
            clientMenuViewModel1.setInformacionPrincipal(informacionPrincipal);

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