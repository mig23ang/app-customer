package com.mibanco.customer.ui.search;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.Client;
import com.mibanco.customer.data.entities.client.TotalClient;
import com.mibanco.customer.databinding.FragmentLibraryBinding;
import com.mibanco.customer.databinding.FragmentSearchByNameBinding;
import com.mibanco.customer.response.TokenResponse;
import com.mibanco.customer.services.SearchService;
import com.mibanco.customer.services.SearchServices;

;import java.io.Serializable;
import java.util.List;

import retrofit2.Response;


public class SearchByNameFragment extends Fragment implements SearchService.OnClientSearchResponseListener {
    EditText edittextname;
    TextView alertSearch;
    Button btnSearch, btnClear;

    private OnButtonClick buttonClickListener;
    private SearchByNameViewModel searchByNameViewModel;
    private FragmentSearchByNameBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchByNameViewModel =
                new ViewModelProvider(this).get(SearchByNameViewModel.class);

        binding = FragmentSearchByNameBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        edittextname = binding.edittextname;
        btnSearch = binding.btnsearchbyname;
        btnClear = binding.btnclearbyname;
        alertSearch = binding.lblerrorname;
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edittextname.setText("");
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edittextname.getText().toString().isEmpty()){
                    alertSearch.setVisibility(View.VISIBLE);
                }else{
                    SearchService searchService = new SearchService();
                    searchService.getClientsByName(edittextname.getText().toString(), getContext(), SearchByNameFragment.this);
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
    public void onClientGetSuccess(String totalClientes, List<Client> clientes) {
        Log.d("TotalClientes", totalClientes);
        for (Client client : clientes) {
            Log.d("Cliente", client.getNombreCompleto());

        }

        Bundle bundle = new Bundle();

        bundle.putSerializable("totalClientKey", ""+totalClientes);
        bundle.putSerializable("clientesKey", (Serializable) clientes);
        Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.resultClientByIdFragment, bundle);
    }

    @Override
    public void onClientGetError(Throwable t) {

    }


    public interface OnButtonClick {
        void onButtonClicked();
    }
}