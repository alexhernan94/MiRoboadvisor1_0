package com.example.miroboadvisor1_0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText txtEmail;
    private EditText txtPass;
    private Button btnLogin;
    private Button btnRegister;
    private Button btnForgotPass;

    private String email = "";
    private String password = "";

    Autenticaciones a = new Autenticaciones();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //Referenciamos los objetos
        txtEmail = (EditText) findViewById(R.id.editTextEmail);
        txtPass = (EditText) findViewById(R.id.editTextPass);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnForgotPass = (Button) findViewById(R.id.btn_newPass);


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a.LoginEmail();
                startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a.LoginEmail();
                startActivity(new Intent(MainActivity.this, RegistroActivity.class));
            }
        });

        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a.LoginEmail();
                startActivity(new Intent(MainActivity.this, RecuperarContraseñaActivity.class));
            }
        });
    }
}