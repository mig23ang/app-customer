package com.mibanco.customer.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mibanco.customer.R;
import com.mibanco.customer.data.adapters.ClientAdapter;
import com.mibanco.customer.data.entities.client.Client;
import com.mibanco.customer.data.entities.client.TotalClient;
import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;
import com.mibanco.customer.databinding.FragmentLibraryBinding;
import com.mibanco.customer.databinding.FragmentResultClientByIdBinding;
import com.mibanco.customer.services.SearchService;

;import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;


public class ResultClientByIdFragment extends Fragment implements SearchService.OnClientSearchByIdResponseListener {

    ClientAdapter clientAdapter;

    List<Client> list;

    RecyclerView recyclerView;

    TextView back_fick, countResultClients;
    private ResultClientByIdViewModel resultClientByIdViewModel;
    private FragmentResultClientByIdBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        resultClientByIdViewModel =
                new ViewModelProvider(this).get(ResultClientByIdViewModel.class);

        binding = FragmentResultClientByIdBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        back_fick = binding.backFic;
        back_fick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.fragment);
                navController.navigateUp();
            }
        });
        countResultClients = binding.countResultClients;
        recyclerView = binding.recyclerViewClients;

        resultClientByIdViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
                list = new ArrayList<>();
                if (getArguments() != null) {
                    String totalClientes = getArguments().getString("totalClientKey");
                    countResultClients.setText("Resultados encontrados ("+totalClientes+")");
                    List<Client> clientes = (List<Client>) getArguments().getSerializable("clientesKey");
                    clientAdapter = new ClientAdapter(getContext(), clientes, ResultClientByIdFragment.this);
                    recyclerView.setAdapter(clientAdapter);
                }

            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onClientGetSuccess(InformacionPrincipal informacionPrincipal, String tipoDocumento, String documento) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("clientDetails", informacionPrincipal);
        bundle.putString("clientDetailsTipoDocumento", tipoDocumento);
        bundle.putString("clientDetailsDocumento", documento);
        Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.clientMenuFragment, bundle);

        //Toast.makeText(getContext(), ""+informacionPrincipal.getRazonSocial(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClientGetError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}