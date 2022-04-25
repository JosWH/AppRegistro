package com.example.appregistro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private EditText ETname, ETlastName, ETemail, ETphone;
    private Switch SWstudent;
    private Button BTNregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        ETname = findViewById(R.id.ETname);
        ETlastName = findViewById(R.id.ETlastName);
        ETemail = findViewById(R.id.ETemail);
        ETphone = findViewById(R.id.ETphone);
        SWstudent = findViewById(R.id.SWstudent);
        BTNregister = findViewById(R.id.BTNregister);
    }
}