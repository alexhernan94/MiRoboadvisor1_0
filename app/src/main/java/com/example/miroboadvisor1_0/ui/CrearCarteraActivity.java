package com.example.miroboadvisor1_0.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.miroboadvisor1_0.R;

public class CrearCarteraActivity extends AppCompatActivity {

    private Spinner ocupacionItem;
    private Spinner perdidaItem;
    private Button btn_crear_cartera;

    private String item_ocupacion;
    private String item_perdida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cartera);

        btn_crear_cartera = (Button)findViewById(R.id.btn_crear_cartera);
        ocupacionItem = (Spinner)findViewById(R.id.ocupacionItem);
        perdidaItem = (Spinner)findViewById(R.id.perdidaItem);

        ocupacionItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               item_ocupacion = parent.getItemAtPosition(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        perdidaItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item_perdida = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_crear_cartera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrearCarteraActivity.this, PrincipalActivity.class));
            }
        });

    }
}
