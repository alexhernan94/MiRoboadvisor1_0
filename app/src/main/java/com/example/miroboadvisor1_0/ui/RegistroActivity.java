package com.example.miroboadvisor1_0.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miroboadvisor1_0.R;
import com.example.miroboadvisor1_0.Usuarios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {

    private static final String TAG = "caca";
    private DatabaseReference database;
    private DatabaseReference Usuarios;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    private EditText txtDni;
    private EditText txtNombre;
    private EditText txtApellidos;
    private EditText txtPais;
    private EditText txtCiudad;
    private EditText txtDomicilio;
    private EditText txtOcupacion;
    private EditText txtIban;
    private EditText txtTelefono;
    private EditText txtEmail;
    private EditText txtPass;

    private Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        database = FirebaseDatabase.getInstance().getReference("Usuario");
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        txtDni = (EditText) findViewById(R.id.editTextDni);
        txtNombre = (EditText) findViewById(R.id.editTextNombre);
        txtApellidos = (EditText) findViewById(R.id.editTextApellidos);
        txtPais = (EditText) findViewById(R.id.editTextPais);
        txtCiudad = (EditText) findViewById(R.id.editTextCiudad);
        txtDomicilio = (EditText) findViewById(R.id.editTextDomicilio);
        txtOcupacion = (EditText) findViewById(R.id.editTextOcupacion);
        txtIban = (EditText) findViewById(R.id.editTextIban);
        txtTelefono = (EditText) findViewById(R.id.editTextTelefono);
        txtEmail = (EditText) findViewById(R.id.editTextEmail);
        txtPass = (EditText) findViewById(R.id.editTextContraseña);

        btn_test = (Button) findViewById(R.id.btn_test);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String dni = txtDni.getText().toString();
                final String nombre = txtNombre.getText().toString();
                final String apellidos = txtApellidos.getText().toString();
                final String pais = txtPais.getText().toString();
                final String ciudad = txtCiudad.getText().toString();
                final String domicilio = txtDomicilio.getText().toString();
                final String ocupacion = txtOcupacion.getText().toString();
                final String iban = txtIban.getText().toString();
                final String telefono = txtTelefono.getText().toString();
                final String email = txtEmail.getText().toString();
                final String contraseña = txtPass.getText().toString();

                if (dni.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() ||
                        pais.isEmpty() || ciudad.isEmpty() || domicilio.isEmpty() ||
                        ocupacion.isEmpty() || iban.isEmpty() || telefono.isEmpty() ||
                        email.isEmpty() || contraseña.isEmpty()){

                    Toast.makeText(RegistroActivity.this, "Rellene todos los datos", Toast.LENGTH_SHORT).show();

                }else{

                   // mAuth.createUserWithEmailAndPassword(email, contraseña);
                    //mUser = mAuth.getCurrentUser();


                    mAuth.createUserWithEmailAndPassword(email, contraseña)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        //Logica luego de loguearse
                                        mUser = mAuth.getCurrentUser();
                                        Log.e(mUser.getEmail(), "eeeeeeeeeeeee");
                                        Log.e(mUser.getUid(), "aaaaaaaaaaa");
                                        registrarUsuario(dni, nombre, apellidos, pais, ciudad, domicilio, ocupacion, iban, telefono, email, contraseña);
                                    } else {

                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                                        Toast.makeText(RegistroActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                    Toast.makeText(RegistroActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistroActivity.this, MainActivity.class));
                }
            }
        });
    }

    public void registrarUsuario(String dni, String nombre, String apellidos, String pais, String ciudad, String domicilio, String ocupacion, String iban, String telefono, String email, String contraseña){

        Usuarios usuario = new Usuarios(dni, nombre, apellidos, pais, ciudad, domicilio, ocupacion, iban, telefono, email, contraseña);
        database.child(mUser.getUid()).setValue(usuario);
    }
}
