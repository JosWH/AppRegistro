package com.example.appregistro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ETname, ETlastName, ETemail, ETphone, ETstudentCode;
    private Switch SWstudent;
    private Button BTNregister;
    private String campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        BTNregister.setOnClickListener(view -> verifyText());
        SWstudent.setOnCheckedChangeListener((compoundButton, b) -> enableCamp());
    }

    private void enableCamp() {
        if (marcado) { ETstudentCode.setVisibility(View.VISIBLE); }
        else { ETstudentCode.setVisibility(View.GONE); }
    }

    private void initViews() {
        ETname = findViewById(R.id.ETname);
        ETlastName = findViewById(R.id.ETlastName);
        ETemail = findViewById(R.id.ETemail);
        ETphone = findViewById(R.id.ETphone);
        ETstudentCode = findViewById(R.id.ETstudentCode);
        SWstudent = findViewById(R.id.SWstudent);
        BTNregister = findViewById(R.id.BTNregister);

        ETstudentCode.setVisibility(View.GONE);
    }
    private void verifyText() {
        int errorType = 0;
        String Message;
        String name = ETname.getText().toString();
        String lastName = ETlastName.getText().toString();
        if ((name.isEmpty()) && (lastName.isEmpty())) errorType = 1;
        else {
            if (name.isEmpty()) errorType = 2;
            if (lastName.isEmpty()) errorType = 3;
        }
        switch (errorType){
            case 0: Message = "Nombre Completo: " +  name + " " + " " + lastName;
                break;
            case 1: Message = "Campos Vacios";
                break;
            case 2: Message = "Campo de Nombre Vacio";
                break;
            case 3: Message = "Campo de Apellido Vacio";
                break;
            default: throw new IllegalStateException("Unexpected value: " + errorType);
        }
        Toast.makeText (this, Message, Toast.LENGTH_SHORT).show();
    }
}