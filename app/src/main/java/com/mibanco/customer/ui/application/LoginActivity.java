package com.mibanco.customer.ui.application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mibanco.customer.R;
import com.mibanco.customer.common.TokenDataStore;
import com.mibanco.customer.response.TokenResponse;
import com.mibanco.customer.services.LoginService;

import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoginService.OnLoginResponseListener {
    EditText email, password;
    Button start_session;
    TextView lbldocumenterror, lblerrorpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        try {

            email = findViewById(R.id.edit_text_document);
            password = findViewById(R.id.edit_text_password);
            start_session = findViewById(R.id.button_login);
            lbldocumenterror = findViewById(R.id.lbldocumenterror);
            lblerrorpassword = findViewById(R.id.lblerrorpassword);
            start_session.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setStart_session();
                }
            });
            delete_alert(email);
            delete_alert(password);
            validateUser();
        }catch (Exception e){
            //Está es una verificación para entender si hay algún problema en el momento de implementar la vista
            Toast.makeText(this, "Error en login activity"+e, Toast.LENGTH_SHORT).show();
        }

    }

    private void setStart_session(){
        String emailString = email.getText().toString();
        String passwordString = password.getText().toString();
        if(emailString.isEmpty()){
            lbldocumenterror.setVisibility(View.VISIBLE);
        }else if(passwordString.isEmpty()){
            lblerrorpassword.setVisibility(View.VISIBLE);
        }else{
            LoginService loginService = new LoginService();
            loginService.login(email.getText().toString(), password.getText().toString(), this, this);

        }
    }

    private void validateUser(){
        LoginService loginService = new LoginService();
        loginService.validate_token(this, this);

    }

    private void delete_alert(EditText editText){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lbldocumenterror.setVisibility(View.INVISIBLE);
                lblerrorpassword.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public void onLoginSuccess(Response<TokenResponse> response) {
        TokenResponse tokenResponse = response.body();
        String token = tokenResponse.getToken();
        TokenDataStore tokenDataStore = new TokenDataStore(this);
        tokenDataStore.saveToken(token);
        try {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
            AlertDialog.Builder Bien = new AlertDialog.Builder(LoginActivity.this);
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

    }

    @Override
    public void onValidateSuccess(Response<Void> response) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onCredentialsInvalid(String message) {
        TokenDataStore tokenDataStore = new TokenDataStore(this);
        String token = tokenDataStore.getAuthToken();
        lblerrorpassword.setVisibility(View.VISIBLE);

        lblerrorpassword.setText(message);

    }

    @Override
    public void onExpiredToken(String message) {
        lblerrorpassword.setVisibility(View.VISIBLE);

        lblerrorpassword.setText(message);
    }

    @Override
    public void onLoginError(String t) {

        lblerrorpassword.setText(t.toString());
        lblerrorpassword.setVisibility(View.VISIBLE);
    }
}