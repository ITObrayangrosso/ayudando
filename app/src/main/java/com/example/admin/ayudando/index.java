package com.example.admin.ayudando;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class index extends AppCompatActivity {
    private Button registrarse,recuperar,iniciar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        onclickRegistrar();
        onclickRecuperar();
        oncliclIniciar();
    }

    private void onclickRegistrar(){
        registrarse = (Button)findViewById(R.id.registrarse);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ListSong = new Intent(getApplicationContext(), registro.class);
                startActivity(ListSong);
            }
        });
    }
    private void onclickRecuperar(){
        registrarse = (Button)findViewById(R.id.olvidoContraseña);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ListSong = new Intent(getApplicationContext(), recuperar_contrasena.class);
                startActivity(ListSong);
            }
        });
    }
    private void oncliclIniciar(){
        registrarse = (Button)findViewById(R.id.iniciarLogin);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ListSong = new Intent(getApplicationContext(), home.class);
                startActivity(ListSong);
            }
        });
    }

}
