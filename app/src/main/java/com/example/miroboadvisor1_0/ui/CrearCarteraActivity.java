package com.example.miroboadvisor1_0.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    private Button btn_ayuda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cartera);

        btn_crear_cartera = (Button)findViewById(R.id.btn_crear_cartera);
        btn_ayuda = (Button)findViewById(R.id.btn_ayuda);
        ocupacionItem = (Spinner)findViewById(R.id.ocupacionItem);
        perdidaItem = (Spinner)findViewById(R.id.perdidaItem);

        ocupacionItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               //ocupacionItem = parent.getItemAtPosition(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        perdidaItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //perdidaItem = parent.getItemAtPosition(position).toString();
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

        btn_ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v);
            }
        });
    }

    public void PopUp(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("- 1000€ de máximo a invertir\n" +
                "\n" +
                "- Máxima pérdida: cuánto se está dispuesto a perder el primer año de lo que se invierte\n" +
                "\n" +
                "- Corto plazo: menos de 1 año\n" +
                "\n" +
                "- Medio plazo: 1 a 3 años\n" +
                "\n" +
                "- Largo plazo: más de 3 años\n" +
                "\n" +
                "- En el patrimonio no se incluyen bienes inmuebles" +
                "\n")
                .setTitle("INFORMACION")
                .setCancelable(false)
                .setNeutralButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
