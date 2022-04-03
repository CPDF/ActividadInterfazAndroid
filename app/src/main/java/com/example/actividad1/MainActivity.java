package com.example.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Mostrar la splash screen durante dos segundos
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Theme_Actividad1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //vamos a necesitar varios botones, por lo que usamos lógica de flujo;
        switch (v.getId()) {
            case R.id.register:
                //Activity corresponde con una pantalla de nuestra app;
                //Acá cambiamos al activity register;
                startActivity(new Intent(this, RegisterUser.class));
                break;
        }
    }
}