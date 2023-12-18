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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.R;
import com.mibanco.customer.data.adapters.ClientAdapter;
import com.mibanco.customer.data.adapters.ClientOptionsAdapter;
import com.mibanco.customer.data.entities.client.fic.Client;
import com.mibanco.customer.data.entities.client.fic.DataClients;
import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;
import com.mibanco.customer.databinding.FragmentClientMenuBinding;
import com.mibanco.customer.databinding.FragmentLibraryBinding;
import com.mibanco.customer.services.ClientService;
import com.mibanco.customer.services.SearchService;

;import java.util.ArrayList;
import java.util.List;


public class ClientMenuFragment extends Fragment implements ClientService.OnClientMenuResponseListener {

    ClientOptionsAdapter clientOptionsAdapter;

    List<Client> clientList;

    RecyclerView recyclerView;

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
        /*title_name_menu_name = binding.titleNameMenuName;
        title_phone_menu_number = binding.titlePhoneMenuNumber;
        back_details = binding.backDetails;
        datosBasicos = binding.datosBasicos;
        ofertasAlertas = binding.ofertasAlertas;
        centralesRiesgo = binding.centralesRiesgo;
        historialPrestamos = binding.historialPrestamos;
        cupoRotativo = binding.cupoRotativo;
        pasivos = binding.pasivos;
        historialContacto = binding.historialContacto;
        pqr = binding.pqr;*/
        recyclerView = binding.recyclerViewClientSelect;
        ClientService clientService = new ClientService();
        clientService.getClientToMenu(getContext(), ClientMenuFragment.this);





/*
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
            title_name_menu_name.setText("Juan Carlos Ramirez");
            title_phone_menu_number.setText(tipoDocumento + " " + documento);
        }*/

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onClientGetSuccess(List<Client> client) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        clientList = new ArrayList<>();

        clientOptionsAdapter = new ClientOptionsAdapter(getContext(), client);
        recyclerView.setAdapter(clientOptionsAdapter);
    }

    @Override
    public void onClientGetError(String message) {

    }
}