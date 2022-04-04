package com.example.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class LoginUser extends AppCompatActivity implements View.OnClickListener {

    private TextView banner, loginUser;
    private EditText editTextEmail, editTextPassword;
    private ProgressBar progressBar;
    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        DB = new DBHelper(this);

        //asignamos las propiedades definidas en la vista
        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        loginUser = (Button) findViewById((R.id.loginUser));
        loginUser.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.loginUser:
                loginUser();
                break;
        }
    }

    private void loginUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //validación de datos

        if(password.isEmpty()){
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editTextEmail.setError("email required");
            editTextEmail.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        Boolean checkuser = DB.checkUserNamePassword(email, password);

            if(checkuser==true){
                Toast.makeText(this, "Login exitoso.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), UserMenu.class);
                startActivity(intent);
                progressBar.setVisibility(View.GONE);
            }else
            {
                Toast.makeText(this, "No existe usuario o password erroneo.", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
    }

}