package com.example.appregistro;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        ETstudentCode.setVisibility(View.GONE);
        BTNregister.setOnClickListener(view -> {
            //verifyText();
            pasarSegundaPantalla();
        });
        SWstudent.setOnCheckedChangeListener((compoundButton, b) -> {
            enableCamp(b);
            sendMessage(b);
        });
    }
    private void pasarSegundaPantalla() {
        Intent intencion = new Intent(this,HomeActivity.class);
        intencion.putExtra("nombre_persona",ETname.getText().toString() );
        intencion.putExtra("apellido_persona",ETname.getText().toString() );
        startActivity(intencion);
    }
    private void sendMessage(boolean marked) {
        String mensaje = "no estoy marcado";
        if (marked) { mensaje = "Estoy marcado"; }
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }
    private void enableCamp(boolean marked) {
        if (marked) { ETstudentCode.setVisibility(View.VISIBLE); }
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
        if ((ETname.getText().toString().isEmpty()) && (ETlastName.getText().toString().isEmpty())) errorType = 1;
        else {
            if (ETname.getText().toString().isEmpty()) errorType = 2;
            if (ETlastName.getText().toString().isEmpty()) errorType = 3;
        }
        switch (errorType) {
            case 0: Message = "Nombre Completo: " + ETname.getText().toString() + " " + ETlastName.getText().toString(); break;
            case 1: Message = "Campos Vacios"; break;
            case 2: Message = "Campo de Nombre Vacio"; break;
            case 3: Message = "Campo de Apellido Vacio"; break;
            default: throw new IllegalStateException("Unexpected value: " + errorType);
        }
        Toast.makeText (this, Message, Toast.LENGTH_SHORT).show();
    }
}