package com.example.miroboadvisor1_0.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miroboadvisor1_0.R;
import com.google.firebase.auth.FirebaseAuth;

public class TestActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btn_guardarTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mAuth = FirebaseAuth.getInstance();

        //String usuario = mAuth.getCurrentUser().getEmail();

        //Toast.makeText(TestActivity.this, "TEST " + usuario, Toast.LENGTH_SHORT).show();

        btn_guardarTest = (Button)findViewById(R.id.btn_guardarTest);

        btn_guardarTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this, MainActivity.class));
            }
        });


    }
}
