package com.mibanco.customer.ui.application;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.mibanco.customer.common.TokenDataStore;
import com.mibanco.customer.databinding.ActivityMenuBinding;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mibanco.customer.R;

import org.w3c.dom.Text;



public class MenuActivity extends AppCompatActivity {
    private static final int NAVIGATION_HOME_ID = R.id.homeFragment;

    ImageView exit;
    TextView saludoUser;
    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try{
            super.onCreate(savedInstanceState);
            getSupportActionBar().hide();




            binding = ActivityMenuBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());


            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.homeFragment, R.id.libraryFragment).build();

            NavController navController = Navigation.findNavController(this, R.id.fragment);

            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);


            binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.homeFragment) {
                    navController.popBackStack(R.id.homeFragment, false);
                    navController.navigate(R.id.homeFragment);
                    return true;
                } else if (item.getItemId() == R.id.libraryFragment) {
                    navController.navigate(R.id.libraryFragment);
                    return true;
                }

                 return false;
            });
            exit = binding.exit;
            //saludoUser = binding.saludoUser;
            TokenDataStore tokenDataStore = new TokenDataStore(this);
            String token = tokenDataStore.getAuthToken();

            //saludoUser.setText(tokenDataStore.getUsernameFromToken("Hola, " + token));

            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TokenDataStore tokenDataStore = new TokenDataStore(MenuActivity.this);
                    tokenDataStore.clearToken();
                    Intent exit = new Intent(MenuActivity.this, LoginActivity.class);
                    startActivity(exit);
                    finish();
                }
            });
        }catch (Exception e){
            Log.e("Error", ""+e);
            //Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
            AlertDialog.Builder Bien = new AlertDialog.Builder(this);
            Bien.setMessage(""+e)
                    .setCancelable(false)
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            AlertDialog Titulo = Bien.create();
            Titulo.setTitle("Datos incorrectos!");
            Titulo.show();
        }

    }
}
