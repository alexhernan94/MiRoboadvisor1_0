package com.example.miroboadvisor1_0.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miroboadvisor1_0.R;
import com.example.miroboadvisor1_0.Usuarios;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {

    private DatabaseReference database;
    private DatabaseReference Usuarios;
    private FirebaseAuth mAuth;

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
                String dni = txtDni.getText().toString();
                String nombre = txtNombre.getText().toString();
                String apellidos = txtApellidos.getText().toString();
                String pais = txtPais.getText().toString();
                String ciudad = txtCiudad.getText().toString();
                String domicilio = txtDomicilio.getText().toString();
                String ocupacion = txtOcupacion.getText().toString();
                String iban = txtIban.getText().toString();
                String telefono = txtTelefono.getText().toString();
                String email = txtEmail.getText().toString();
                String contraseña = txtPass.getText().toString();

                if (dni.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() ||
                        pais.isEmpty() || ciudad.isEmpty() || domicilio.isEmpty() ||
                        ocupacion.isEmpty() || iban.isEmpty() || telefono.isEmpty() ||
                        email.isEmpty() || contraseña.isEmpty()){

                    Toast.makeText(RegistroActivity.this, "Rellene todos los datos", Toast.LENGTH_SHORT).show();

                }else{

                    registrarUsuario(dni, nombre, apellidos, pais, ciudad, domicilio, ocupacion, iban, telefono, email, contraseña);
                    mAuth.createUserWithEmailAndPassword(email,contraseña);

                    Toast.makeText(RegistroActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistroActivity.this, TestActivity.class));
                }
            }
        });
    }

    public void registrarUsuario(String dni, String nombre, String apellidos, String pais, String ciudad, String domicilio, String ocupacion, String iban, String telefono, String email, String contraseña){

        Usuarios usuario = new Usuarios(dni, nombre, apellidos, pais, ciudad, domicilio, ocupacion, iban, telefono, email, contraseña);
        database.child(txtDni.getText().toString()).setValue(usuario);
    }
}
