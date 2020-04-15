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
import java.util.List;

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


        btn_modDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_updateData.setEnabled(true);
                btn_modDatos.setEnabled(false);
                btn_logOut.setEnabled(false);
                btn_delUser.setEnabled(false);
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
