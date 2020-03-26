package com.example.miroboadvisor1_0.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miroboadvisor1_0.R;
import com.example.miroboadvisor1_0.Usuarios;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class PrincipalActivity extends AppCompatActivity {

    private DatabaseReference databaseRef;
    private FirebaseUser mUser;
    private FirebaseAuth mAuth;

    private Usuarios usuarios;
    private TextView nomUser;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        databaseRef = FirebaseDatabase.getInstance().getReference().child("Usuario");

        nomUser = (TextView)findViewById(R.id.welcomeView);

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Usuarios> list= new ArrayList <>();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    usuarios = postSnapshot.getValue(Usuarios.class);
                    list.add(usuarios);

                    if(mUser.getEmail().contentEquals(usuarios.getEmail())){
                        nomUser.setText(usuarios.getNombre() + " " + usuarios.getApellidos());
                        Toast.makeText(PrincipalActivity.this, usuarios.getDNI(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
