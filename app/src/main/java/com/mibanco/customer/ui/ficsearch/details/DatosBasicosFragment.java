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



    TextView tipoDocumeto, documeto, numeroDocumento, nombreCompleto, correo, estadoCivil, activos;
    private DatosBasicosViewModel datosBasicosViewModel;
    private FragmentDatosBasicosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        datosBasicosViewModel =
                new ViewModelProvider(this).get(DatosBasicosViewModel.class);

        binding = FragmentDatosBasicosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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



    //La siguiente función simulará los datos...
    private void cargarDatosBasicos(){
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
        informacionPrincipalData.add("Juan David Orozco");
        informacionPrincipal.add("Tipo de documento");
        informacionPrincipalData.add("Cedula de ciudadania");
        informacionPrincipal.add("Número de documento");
        informacionPrincipalData.add("123,456");
        informacionPrincipal.add("Número de cliente");
        informacionPrincipalData.add("122,233");
        informacionPrincipal.add("Correo Electrónico");
        informacionPrincipalData.add("Mj@Gmail.com");
        informacionPrincipal.add("Estado Civil");
        informacionPrincipalData.add("Soltero");
        informacionPrincipal.add("Telefono #1");
        informacionPrincipalData.add("(310)-000-0000");
        informacionPrincipal.add("Telefono #2");
        informacionPrincipalData.add("(310)-000-0000");
        informacionPrincipal.add("Tipo vivienda");
        informacionPrincipalData.add("Propia");
        informacionPrincipal.add("Total Activos");
        informacionPrincipalData.add(" $250,000,000.00");
        informacionPrincipal.add("Última Fecha De Actualización De Datos");
        informacionPrincipalData.add("-");
        informacionPrincipal.add("Funcionario Que Realizó Actualización De Datos");
        informacionPrincipalData.add("Lina Camargo");
        informacionPrincipal.add("¿Se Requiere Actualización De Datos?");
        informacionPrincipalData.add("No");


        datosNegocio.add("Dirección De Domicilio");
        datosData.add("Cr 14 # 18 - 03 Alto Del Rosario");
        datosNegocio.add("Tipo De Vivienda");
        datosData.add("PROPIA");
        datosNegocio.add("Teléfono #1");
        datosData.add("(310)-000-0000");
        datosNegocio.add("Teléfono #2");
        datosData.add("3111111111");



        datosDomicilio.add("Dirección De Negocio");
        datosDomicilioData.add("Cll 3 # 28 - 28 Los Angeles");
        datosDomicilio.add("Actividad (CIIU)");
        datosDomicilioData.add("1720 - TEJEDURA DE PRODUCTOS TEXTILES");
        datosDomicilio.add("Teléfono #1");
        datosDomicilioData.add("(313)-447-8967");
        datosDomicilio.add("Teléfono #2");
        datosDomicilioData.add("-");


        datosConyude.add("Nombre Completo");
        datosConyugeData.add("-");
        datosConyude.add("Tipo De Documento");
        datosConyugeData.add("-");
        datosConyude.add("Número De Documento");
        datosConyugeData.add("-");

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