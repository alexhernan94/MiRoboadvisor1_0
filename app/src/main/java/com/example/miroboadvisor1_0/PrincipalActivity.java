package com.example.miroboadvisor1_0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PrincipalActivity extends AppCompatActivity {

    private FirebaseUser mUser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mAuth = FirebaseAuth.getInstance();

        String usuario = mAuth.getCurrentUser().getEmail();

        Toast.makeText(PrincipalActivity.this, "Bienvenido " + usuario, Toast.LENGTH_SHORT).show();

    }
}
