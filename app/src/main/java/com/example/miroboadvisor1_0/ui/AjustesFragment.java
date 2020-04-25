package com.example.miroboadvisor1_0.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miroboadvisor1_0.R;
import com.example.miroboadvisor1_0.Usuarios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AjustesFragment extends Fragment  {

    private DatabaseReference databaseRef;
    FirebaseUser mUser;
    FirebaseAuth mAuth;

    private Usuarios usuarios;

    private Button btn_modDatos;
    private Button btn_updateData;
    private Button btn_logOut;
    private Button btn_delUser;

    private EditText txt_dni;
    private EditText txt_nombre;
    private EditText txt_apellidos;
    private EditText txt_pais;
    private EditText txt_ciudad;
    private EditText txt_domicilio;
    private EditText txt_telefono;
    private EditText txt_iban;
    private EditText txt_email;
    private EditText txt_password;


    public AjustesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ajustes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        databaseRef = FirebaseDatabase.getInstance().getReference().child("Usuario");

        btn_updateData = (Button) view.findViewById(R.id.btn_updateData);
        btn_modDatos = (Button) view.findViewById(R.id.btn_modDatos);
        btn_logOut = (Button) view.findViewById(R.id.btn_logOut);
        btn_delUser = (Button) view.findViewById(R.id.btn_delUser);

        txt_dni = (EditText) view.findViewById(R.id.txt_dni);
        txt_nombre = (EditText) view.findViewById(R.id.txt_nombre);
        txt_apellidos = (EditText) view.findViewById(R.id.txt_apellidos);
        txt_pais = (EditText) view.findViewById(R.id.txt_pais);
        txt_ciudad = (EditText) view.findViewById(R.id.txt_ciudad);
        txt_domicilio = (EditText) view.findViewById(R.id.txt_domicilio);
        txt_telefono = (EditText) view.findViewById(R.id.txt_telefono);
        txt_iban = (EditText) view.findViewById(R.id.txt_iban);
        txt_email = (EditText) view.findViewById(R.id.txt_email);
        txt_password = (EditText) view.findViewById(R.id.txt_password);

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Usuarios> list= new ArrayList <>();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    usuarios = postSnapshot.getValue(Usuarios.class);
                    list.add(usuarios);

                    if(mUser.getEmail().contentEquals(usuarios.getEmail())){
                        txt_dni.setText(usuarios.getDNI());
                        txt_nombre.setText(usuarios.getNombre());
                        txt_apellidos.setText(usuarios.getApellidos());
                        txt_pais.setText(usuarios.getPais());
                        txt_ciudad.setText(usuarios.getCiudad());
                        txt_domicilio.setText(usuarios.getDomicilio());
                        txt_telefono.setText(usuarios.getTelefono());
                        txt_iban.setText(usuarios.getIban());
                        txt_email.setText(usuarios.getEmail());
                        txt_password.setText(usuarios.getContraseña());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_modDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_updateData.setEnabled(true);
                btn_modDatos.setEnabled(false);
                btn_logOut.setEnabled(false);
                btn_delUser.setEnabled(false);

                txt_dni.setEnabled(true);
                txt_nombre.setEnabled(true);
                txt_apellidos.setEnabled(true);
                txt_pais.setEnabled(true);
                txt_ciudad.setEnabled(true);
                txt_domicilio.setEnabled(true);
                txt_telefono.setEnabled(true);
                txt_iban.setEnabled(true);
                txt_email.setEnabled(true);
                txt_password.setEnabled(true);
                //los datos son editables
            }
        });

        btn_updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //los datos no son editables
                btn_updateData.setEnabled(false);
                btn_modDatos.setEnabled(true);
                btn_logOut.setEnabled(true);
                btn_delUser.setEnabled(true);

                //ACTUALIZAR DATOS
                databaseRef.child(mUser.getUid()).child("dni").setValue(txt_dni.getText().toString());
                databaseRef.child(mUser.getUid()).child("nombre").setValue(txt_nombre.getText().toString());
                databaseRef.child(mUser.getUid()).child("apellidos").setValue(txt_apellidos.getText().toString());
                databaseRef.child(mUser.getUid()).child("pais").setValue(txt_pais.getText().toString());
                databaseRef.child(mUser.getUid()).child("ciudad").setValue(txt_ciudad.getText().toString());
                databaseRef.child(mUser.getUid()).child("domicilio").setValue(txt_domicilio.getText().toString());
                databaseRef.child(mUser.getUid()).child("telefono").setValue(txt_telefono.getText().toString());
                databaseRef.child(mUser.getUid()).child("iban").setValue(txt_iban.getText().toString());
                databaseRef.child(mUser.getUid()).child("email").setValue(txt_email.getText().toString());
                databaseRef.child(mUser.getUid()).child("contraseña").setValue(txt_password.getText().toString());

                //DESHABILITAR EDIT TEXT
                txt_dni.setEnabled(false);
                txt_nombre.setEnabled(false);
                txt_apellidos.setEnabled(false);
                txt_pais.setEnabled(false);
                txt_ciudad.setEnabled(false);
                txt_domicilio.setEnabled(false);
                txt_telefono.setEnabled(false);
                txt_iban.setEnabled(false);
                txt_email.setEnabled(false);
                txt_password.setEnabled(false);
            }
        });

        btn_delUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
               dialog.setTitle("!!!Atencion¡¡¡");
               dialog.setMessage("¿Desea borrar su cuenta?");
               dialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       borrarUsuario(mAuth.getCurrentUser().getUid());
                       mUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getContext(), "Cuenta borrada", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getActivity(), MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                           }
                       });
                   }
               });
               dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int which) {
                       dialogInterface.dismiss();
                   }
               });
               AlertDialog alertDialog = dialog.create();
               alertDialog.show();
            }
        });

        btn_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Build an AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                // Set a title for alert dialog
                builder.setTitle("!!!!ATENCIÓN¡¡¡¡");

                // Ask the final question
                builder.setMessage("¿Desea cerrar sesión?");

                // Set click listener for alert dialog buttons
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which){
                            case DialogInterface.BUTTON_POSITIVE:
                                // User clicked the Yes button
                                FirebaseAuth.getInstance().signOut();
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);

                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };
                // Set the alert dialog yes button click listener
                builder.setPositiveButton("Yes", dialogClickListener);
                // Set the alert dialog no button click listener
                builder.setNegativeButton("No",dialogClickListener);
                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();
            }
        });
    }
    private void borrarUsuario(String id){
        DatabaseReference idUser =  FirebaseDatabase.getInstance().getReference().child("Usuario").child(id);
        idUser.removeValue();
        Toast.makeText(getActivity(), "Cuenta borrada", Toast.LENGTH_SHORT).show();
    }
}
