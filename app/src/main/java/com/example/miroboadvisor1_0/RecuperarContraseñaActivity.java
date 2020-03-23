package com.example.miroboadvisor1_0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RecuperarContraseñaActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText txtEmail;
    private Button btnNewPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_pass);

        mAuth = FirebaseAuth.getInstance();

        txtEmail = (EditText) findViewById(R.id.editTextEmail);
        btnNewPass = (Button) findViewById(R.id.btn_newPass);

        btnNewPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txtEmail.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Escriba su email de registro", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.sendPasswordResetEmail(email);
                Toast.makeText(getApplication(), "Email enviado correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
