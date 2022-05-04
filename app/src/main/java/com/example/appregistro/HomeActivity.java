package com.example.appregistro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView TVresult;
    String name, lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        catchData();
    }
    private void catchData() {
        name = this.getIntent().getExtras().getString("nombre_persona","");
        lastName = this.getIntent().getExtras().getString("apellido_persona","");
    }
    private void initViews() {
        TVresult = findViewById(R.id.TVresult);
    }
}