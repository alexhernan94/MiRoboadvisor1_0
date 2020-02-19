package com.example.miroboadvisor1_0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miroboadvisor1_0.model.EmailPasswordAuth;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText txtEmail;
    private EditText txtPass;
    private Button btnLogin;
    private Button btnRegister;
    private Button btnForgotPass;

    private String email = "";
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        txtEmail = (EditText) findViewById(R.id.editTextEmail);
        txtPass = (EditText) findViewById(R.id.editTextPass);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnForgotPass = (Button) findViewById(R.id.btn_newPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Both fields must be completed", Toast.LENGTH_SHORT).show();
                }
                else if(password.length()>=6) {
                    Toast.makeText(MainActivity.this, "Password less than 6 characteres", Toast.LENGTH_SHORT).show();
                }
                else{
                    mAuth.signInWithEmailAndPassword(email, password);
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = txtEmail.getText().toString();
                password = txtPass.getText().toString();

                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Both fields must be completed", Toast.LENGTH_SHORT).show();
                }
                else if(password.length()>=6) {
                        Toast.makeText(MainActivity.this, "Password less than 6 characteres", Toast.LENGTH_SHORT).show();
                    }
                else{
                    mAuth.createUserWithEmailAndPassword(email, password);
                }
            }
        });

        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.sendPasswordResetEmail(email);
            }
        });
    }

}
