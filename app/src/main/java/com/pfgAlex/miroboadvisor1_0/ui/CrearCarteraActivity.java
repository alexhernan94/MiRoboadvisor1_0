package com.pfgAlex.miroboadvisor1_0.ui;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.pfgAlex.miroboadvisor1_0.Carteras;
import com.pfgAlex.miroboadvisor1_0.Fondos;
import com.pfgAlex.miroboadvisor1_0.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.pfgAlex.miroboadvisor1_0.Usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class CrearCarteraActivity extends AppCompatActivity {

    protected Python py;

    private Fondos fondos;

    private DatabaseReference database;
    private DatabaseReference databaseFondos;
    private DatabaseReference data;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;


    private Spinner ocupacionItem;
    private Spinner perdidaItem;
    private String ocupacion;
    private String perdida;
    private Button btn_crear_cartera;
    private Button btn_ayuda;
    private EditText txt_cartera;
    private EditText txt_ingresos;
    private EditText txt_ahorros;
    private EditText txt_patrimonio;
    private EditText txt_edad;
    private EditText txt_importe;
    private RadioGroup rbg_riesgo;
    private RadioGroup rbg_objetivos;
    private String selectedtext_riesgo;
    private String selectedtext_objetivos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cartera);
        initPython();

        database = FirebaseDatabase.getInstance().getReference("Usuario");
        databaseFondos = FirebaseDatabase.getInstance().getReference("Fondos");

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        System.out.println("LUGAR " +mUser.getUid());


        btn_crear_cartera = (Button)findViewById(R.id.btn_crear_cartera);
        btn_ayuda = (Button)findViewById(R.id.btn_ayuda);

        ocupacionItem = (Spinner)findViewById(R.id.ocupacionItem);
        perdidaItem = (Spinner)findViewById(R.id.perdidaItem);

        txt_cartera = (EditText)findViewById(R.id.txt_cartera);
        txt_ingresos = (EditText)findViewById(R.id.txt_ingresos);
        txt_ahorros = (EditText)findViewById(R.id.txt_ahorros);
        txt_patrimonio = (EditText)findViewById(R.id.txt_patrimonio);
        txt_edad = (EditText)findViewById(R.id.txt_edad);
        txt_importe = (EditText)findViewById(R.id.txt_importe);

        rbg_riesgo = (RadioGroup)findViewById(R.id.rbg_riesgo);
        rbg_objetivos = (RadioGroup)findViewById(R.id.rbg_objetivos);


        rbg_riesgo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton rb= (RadioButton) findViewById(checkedId);
                selectedtext_riesgo = rb.getText().toString();
            }
        });

        rbg_objetivos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton rb= (RadioButton) findViewById(checkedId);
                selectedtext_objetivos = rb.getText().toString();
            }
        });

        ocupacionItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               ocupacion = parent.getItemAtPosition(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        perdidaItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                perdida = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_crear_cartera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nom_cartera = txt_cartera.getText().toString();
                final String tipo_riesgo = selectedtext_riesgo;
                final String tipo_objetivo = selectedtext_objetivos;
                final String tipo_ocupacion = ocupacion;
                final String tipo_perdida = perdida;
                final String num_ahorros = txt_ahorros.getText().toString();
                final String num_ingresos = txt_ingresos.getText().toString();
                final String num_patrimonio = txt_patrimonio.getText().toString();
                final String num_edad = txt_edad.getText().toString();
                final String num_importe = txt_importe.getText().toString();
                final Fondos[] nom_fondo = new Fondos[1];

                System.out.println("CARTERA: " + txt_cartera.getText().toString());
                System.out.println("Riesgo: " + selectedtext_riesgo);
                System.out.println("Objetivo: " + selectedtext_objetivos);
                System.out.println("OCUPACION: " + ocupacion);
                System.out.println("PERDIDA: " + perdida);
                System.out.println("AHORROS: " + txt_ahorros.getText().toString());
                System.out.println("INGRESOS: " + txt_ingresos.getText().toString());
                System.out.println("PATRIMONIO: " + txt_patrimonio.getText().toString());
                System.out.println("EDAD: " + txt_edad.getText().toString());
                System.out.println("IMPORTE: " + txt_importe.getText().toString());

                Python py = Python.getInstance();
                PyObject pyf = py.getModule("myscript"); //fichero python
                final PyObject obj = pyf.callAttr("test",Integer.parseInt(num_edad), Integer.parseInt(num_ingresos), Integer.parseInt(num_ahorros)); //nombre de funcion a ejecutar

                databaseFondos.addValueEventListener(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        List<Fondos> list= new ArrayList <>();

                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            fondos = postSnapshot.getValue(Fondos.class);
                            if (fondos.getIMI() <= Long.parseLong(num_importe) && (fondos.getRiesgo() <= Long.parseLong(obj.toString()))){
                                list.add(fondos);
                            }
                        }
                        Random random = new Random();
                        nom_fondo[0] = list.get(random.nextInt(list.size()));

                        mUser = mAuth.getCurrentUser();
                        registrarCartera(nom_cartera, tipo_riesgo, tipo_objetivo, tipo_ocupacion, tipo_perdida, num_ahorros, num_ingresos, num_patrimonio, num_edad, num_importe, nom_fondo[0]);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
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

    private void initPython() {
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
    }

    public void registrarCartera(String nom_cartera, String tipo_riesgo, String tipo_objetivo, String tipo_ocupacion, String tipo_perdida, String num_ahorros, String num_ingresos, String num_patrimonio, String num_edad, String num_importe, Fondos nom_fondo) {
        Carteras cartera = new Carteras(nom_cartera, tipo_riesgo, tipo_objetivo, tipo_ocupacion, tipo_perdida, num_ahorros, num_ingresos, num_patrimonio, num_edad, num_importe, nom_fondo);
        database.child(mUser.getUid()).child("Carteras").push().setValue(cartera);
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
