package com.pfgAlex.miroboadvisor1_0.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.pfgAlex.miroboadvisor1_0.R;
import com.pfgAlex.miroboadvisor1_0.Usuarios;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    private DatabaseReference databaseRef;
    private FirebaseUser mUser;
    private FirebaseAuth mAuth;

    private Usuarios usuarios;
    private TextView nomUser;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private TabItem tabGeneral;
    private TabItem tabCarteras;
    private TabItem tabAjustes;

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
                Toast.makeText(PrincipalActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        tabLayout = findViewById(R.id.tabLayout);
        tabGeneral = findViewById(R.id.tabGeneral);
        tabCarteras = findViewById(R.id.tabCarteras);
        tabAjustes = findViewById(R.id.tabAjustes);

        viewPager = findViewById(R.id.viewPager);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.callOnClick();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1){
                    //Toast.makeText(PrincipalActivity.this, "Carteras", Toast.LENGTH_SHORT).show();
                }
                else if (tab.getPosition() == 2){
                    //Toast.makeText(PrincipalActivity.this, "Ajustes", Toast.LENGTH_SHORT).show();
                }else{
                    //Toast.makeText(PrincipalActivity.this, "General", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}
