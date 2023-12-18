package com.mibanco.customer.ui.ficsearch.details;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mibanco.customer.R;
import com.mibanco.customer.data.adapters.ClientDataAdapter;
import com.mibanco.customer.data.entities.client.fic.Client;
import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;
import com.mibanco.customer.databinding.FragmentDatosBasicosBinding;
import com.mibanco.customer.databinding.FragmentFicSearchBinding;
import com.mibanco.customer.databinding.FragmentSearchBinding;
import com.mibanco.customer.ui.search.ClientMenuViewModel;

;import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DatosBasicosFragment extends Fragment {
    private ExpandableListView options;
    private ClientDataAdapter adapter;
    private ArrayList<String> listOptions;
    private Map<String, ArrayList<String>> mapChild;
    private Map<String, ArrayList<String>> mapChild2;



    TextView fullName, phoneCompany;
    private DatosBasicosViewModel datosBasicosViewModel;
    private FragmentDatosBasicosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        datosBasicosViewModel =
                new ViewModelProvider(this).get(DatosBasicosViewModel.class);

        binding = FragmentDatosBasicosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        fullName = binding.fullName;
        phoneCompany = binding.phoneCompany;


        options = binding.expandableListView;
        listOptions = new ArrayList<>();
        mapChild=new HashMap<>();
        mapChild2=new HashMap<>();




        cargarDatosBasicos();
        ClientMenuViewModel clientMenuViewModel = new ViewModelProvider(requireActivity()).get(ClientMenuViewModel.class);
        clientMenuViewModel.getInformacionPrincipal().observe(getViewLifecycleOwner(), new Observer<InformacionPrincipal>() {
            @Override
            public void onChanged(InformacionPrincipal info) {

            }
        });

        return root;
    }




    private void cargarDatosBasicos(){
        Client datosBasicos = (Client) getArguments().getSerializable("datosBasicos");

        fullName.setText(datosBasicos.getNombreCompleto());
        phoneCompany.setText(datosBasicos.getNegocio() != null ? datosBasicos.getNegocio().getTelefono1() : "-");


        ArrayList<String> informacionPrincipal = new ArrayList<>();
        ArrayList<String> informacionPrincipalData = new ArrayList<>();
        ArrayList<String> datosNegocio = new ArrayList<>();
        ArrayList<String> datosData = new ArrayList<>();
        ArrayList<String> datosDomicilio = new ArrayList<>();
        ArrayList<String> datosDomicilioData = new ArrayList<>();
        ArrayList<String> datosConyude = new ArrayList<>();
        ArrayList<String> datosConyugeData = new ArrayList<>();

        listOptions.add("Información Principal");
        listOptions.add("Información del domicilio");
        listOptions.add("Información del negocio");
        listOptions.add("Información del conyuge");

        informacionPrincipal.add("Nombre completo");
        informacionPrincipalData.add(datosBasicos.getNombreCompleto());
        informacionPrincipal.add("Tipo de documento");
        informacionPrincipalData.add(datosBasicos.getTipoIdentificacion());
        informacionPrincipal.add("Número de documento");
        informacionPrincipalData.add(datosBasicos.getIdentificacion());
        informacionPrincipal.add("Número de cliente");
        informacionPrincipalData.add(datosBasicos.getNumeroCliente());
        informacionPrincipal.add("Correo Electrónico");
        informacionPrincipalData.add(datosBasicos.getCorreoElectronico());
        informacionPrincipal.add("Estado Civil");
        informacionPrincipalData.add(datosBasicos.getEstadoCivil());
        informacionPrincipal.add("Telefono #1");
        informacionPrincipalData.add(datosBasicos.getTelefono1());
        informacionPrincipal.add("Telefono #2");
        informacionPrincipalData.add(datosBasicos.getTelefono2());
        informacionPrincipal.add("Tipo vivienda");
        informacionPrincipalData.add(datosBasicos.getTipoVivienda());
        informacionPrincipal.add("Total Activos");
        informacionPrincipalData.add(datosBasicos.getTotalActivos());
        informacionPrincipal.add("Última Fecha De Actualización De Datos");
        informacionPrincipalData.add(datosBasicos.getUltimaFechaActualizacion());
        informacionPrincipal.add("Funcionario Que Realizó Actualización De Datos");
        informacionPrincipalData.add(datosBasicos.getFuncionarioRealizoActualizacion());
        informacionPrincipal.add("¿Se Requiere Actualización De Datos?");
        informacionPrincipalData.add(datosBasicos.getRequiereActualizacion());


        datosNegocio.add("Dirección De Domicilio");
        datosData.add(datosBasicos.getDomicilio() != null ? datosBasicos.getDomicilio().getDireccion() : "-");
        datosNegocio.add("Tipo De Vivienda");
        datosData.add(datosBasicos.getDomicilio() != null ? datosBasicos.getDomicilio().getTipo() : "-");
        datosNegocio.add("Teléfono #1");
        datosData.add(datosBasicos.getDomicilio() != null ? datosBasicos.getDomicilio().getTelefono1() : "-");
        datosNegocio.add("Teléfono #2");
        datosData.add(datosBasicos.getDomicilio() != null ? datosBasicos.getDomicilio().getTelefono2() : "-");



        datosDomicilio.add("Dirección De Negocio");
        datosDomicilioData.add(datosBasicos.getNegocio() != null ? datosBasicos.getNegocio().getDireccion() : "-");
        datosDomicilio.add("Actividad (CIIU)");
        datosDomicilioData.add(datosBasicos.getNegocio() != null ? datosBasicos.getNegocio().getActividad() : "-");
        datosDomicilio.add("Teléfono #1");
        datosDomicilioData.add(datosBasicos.getNegocio() != null ? datosBasicos.getNegocio().getTelefono1() : "-");



        datosConyude.add("Nombre Completo");
        datosConyugeData.add(datosBasicos.getConyuge() != null ? datosBasicos.getConyuge().getNombre() : "-");
        datosConyude.add("Tipo De Documento");
        datosConyugeData.add(datosBasicos.getConyuge() != null ? datosBasicos.getConyuge().getTipoDocumento() : "-");
        datosConyude.add("Número De Documento");
        datosConyugeData.add(datosBasicos.getConyuge() != null ? datosBasicos.getConyuge().getNumeroDocumento() : "-");

        mapChild.put(listOptions.get(0), informacionPrincipal);
        mapChild2.put(listOptions.get(0), informacionPrincipalData);


        mapChild.put(listOptions.get(1), datosNegocio);
        mapChild2.put(listOptions.get(1), datosData);

        mapChild.put(listOptions.get(2), datosDomicilio);
        mapChild2.put(listOptions.get(2), datosDomicilioData);

        mapChild.put(listOptions.get(3), datosConyude);
        mapChild2.put(listOptions.get(3), datosConyugeData);

        adapter = new ClientDataAdapter( listOptions, mapChild, mapChild2,getContext());
        options.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}