package com.mibanco.customer.common;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberTextWatcher implements TextWatcher {

    private EditText editText;
    private NumberFormat numberFormat;

    public NumberTextWatcher(EditText editText) {
        this.editText = editText;
        // Especificar el Locale.US para asegurar el uso de punto como separador decimal
        this.numberFormat = new DecimalFormat("#,###", new DecimalFormatSymbols(Locale.JAPAN));
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        // No se necesita implementación antes de cambiar el texto
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        // No se necesita implementación mientras se cambia el texto
    }

    @Override
    public void afterTextChanged(Editable editable) {
        editText.removeTextChangedListener(this);

        // Elimina cualquier coma existente para evitar problemas al agregar nuevos puntos
        String originalString = editable.toString().replaceAll(",", "");

        double doubleValue;

        try {
            // Convierte el texto a un número double
            doubleValue = Double.parseDouble(originalString);
        } catch (NumberFormatException e) {
            doubleValue = 0;
        }

        // Aplica el formato de puntos de miles al número
        String formattedString = numberFormat.format(doubleValue);

        // Establece el texto formateado en el EditText
        editText.setText(formattedString);

        // Mueve el cursor al final del texto formateado
        editText.setSelection(formattedString.length());

        editText.addTextChangedListener(this);
    }
}
