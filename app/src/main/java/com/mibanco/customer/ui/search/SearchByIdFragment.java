package com.mibanco.customer.ui.search;

import android.content.ClipData;
import android.content.Context;
import android.media.RouteListingPreference;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.mibanco.customer.R;
import com.mibanco.customer.data.entities.client.fic.InformacionPrincipal;
import com.mibanco.customer.databinding.FragmentLibraryBinding;
import com.mibanco.customer.databinding.FragmentSearchByIdBinding;
import com.mibanco.customer.services.SearchService;

;import java.util.ArrayList;
import java.util.List;


public class SearchByIdFragment extends Fragment implements SearchService.OnClientSearchByIdResponseListener {

    Spinner tipeDocument;
    Button btnsearchbyid;

    EditText documentEditTextSearch;

    private SearchByIdViewModel searchByIdViewModel;
    private FragmentSearchByIdBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchByIdViewModel =
                new ViewModelProvider(this).get(SearchByIdViewModel.class);

        binding = FragmentSearchByIdBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tipeDocument = binding.spinnerDocumentType;
        itemsTipeDocument(tipeDocument, getContext());
        documentEditTextSearch = binding.documentEditTextSearch;

        btnsearchbyid = binding.btnsearchbyid;
        btnsearchbyid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(documentEditTextSearch.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "No hay un documento que buscar", Toast.LENGTH_LONG).show();
                }else{
                    Item selectSpinner = (Item) tipeDocument.getSelectedItem();
                    String tipeDocument = selectSpinner.getInternalValue();
                    String document = documentEditTextSearch.getText().toString();
                    SearchService searchService = new SearchService();
                    searchService.getClientsByDocument(tipeDocument, document, getContext(), SearchByIdFragment.this);
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


    private void itemsTipeDocument(Spinner spinner, Context context)
    {

        String[] documentTypesValues = getResources().getStringArray(R.array.document_types_values);
        String[] documentTypesDisplay = getResources().getStringArray(R.array.document_types);


        List<Item> items = new ArrayList<>();
        for (int i = 0; i < documentTypesValues.length; i++) {
            items.add(new Item(documentTypesValues[i], documentTypesDisplay[i]));
        }


        ArrayAdapter<Item> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);

    }

    @Override
    public void onClientGetSuccess(InformacionPrincipal informacionPrincipal, String tipoDocumento, String documento) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("clientDetails", informacionPrincipal);
        bundle.putString("clientDetailsTipoDocumento", tipoDocumento);
        bundle.putString("clientDetailsDocumento", documento);
        Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.clientMenuFragment, bundle);

    }

    @Override
    public void onClientGetError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public class Item {
        private String internalValue;
        private String displayValue;

        public Item(String internalValue, String displayValue) {
            this.internalValue = internalValue;
            this.displayValue = displayValue;
        }

        public String getInternalValue() {
            return internalValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }

        @Override
        public String toString() {
            return displayValue;
        }
    }


}


