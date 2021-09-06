package com.example.abueappint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class mensajes extends AppCompatActivity {
    private EditText msj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajes);
        msj=(EditText)findViewById(R.id.mensaje);
    }

    public void regr(View view) {
        Intent con = new Intent(this, MainActivity.class);
        startActivity(con);
    }

    public void mensj(View view){
        String message = msj.getText().toString();
        String phoneNo = "4274274294";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo, null, message, null, null);
    }
}
