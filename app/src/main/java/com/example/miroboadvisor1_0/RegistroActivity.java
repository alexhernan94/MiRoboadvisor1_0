package com.example.miroboadvisor1_0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {

    private FirebaseDatabase database;

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

        database = FirebaseDatabase.getInstance();


        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference myRef = database.getReference(txtDni.getText().toString());

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

                cargaDatos(myRef, dni, nombre, apellidos, pais, ciudad, domicilio, ocupacion, iban, telefono, email, contraseña);

                Toast.makeText(RegistroActivity.this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargaDatos(DatabaseReference myRef, String dni, String nombre, String apellidos, String pais, String ciudad, String domicilio, String ocupacion, String iban, String telefono, String email, String contraseña) {

        Map<String, Object> datosUsuario = new HashMap<>();

        if (Validaciones.validarDNI(dni) || Validaciones.validarNIE(dni)){
            datosUsuario.put("DNI", dni);
        }else {
            Toast.makeText(RegistroActivity.this, "DNI o NIE incorrecto", Toast.LENGTH_SHORT).show();
        }
        datosUsuario.put("Nombre", nombre);
        datosUsuario.put("Apelllidos", apellidos);
        datosUsuario.put("Pais", pais);
        datosUsuario.put("Ciudad", ciudad);
        datosUsuario.put("Domicilio", domicilio);
        datosUsuario.put("Ocupacion", ocupacion);
        if(Validaciones.validarIBAN(iban)){
            datosUsuario.put("IBAN", iban);
        }else{
            Toast.makeText(RegistroActivity.this, "IBAN incorrecto", Toast.LENGTH_SHORT).show();
        }
        if(telefono.length()==9){
            datosUsuario.put("Telefono", telefono);
        }else {
            Toast.makeText(RegistroActivity.this, "Telefono incorrecto", Toast.LENGTH_SHORT).show();
        }
        datosUsuario.put("Email", email);
        datosUsuario.put("Contraseña", contraseña);

        myRef.setValue(datosUsuario);
    }
}
