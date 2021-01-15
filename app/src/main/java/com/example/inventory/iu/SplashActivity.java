package com.example.inventory.iu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.inventory.R;
import com.example.inventory.iu.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private static final long WAIT_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    /**
     * EN este método se debe ejecutar todas las operaciones de inicio de la aplicaión
     * como conectase a una base de datos, a un servidor... Simulamos el tiempo de espera
     * con un hilo que duerme 2 segundos y cuando despierta ejecuta el método initLogin
     */
    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Solo si el checkbox remember no esta seleccionado se muestra login y no existe ningun usuario
                initLogin();
            }
        }, WAIT_TIME);
    }

    private void initLogin() {
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));

        //vamos a a llamar, de forma explicita, al método finish() que destruye la activity
        finish();
    }
}
