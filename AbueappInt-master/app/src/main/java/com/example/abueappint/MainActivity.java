package com.example.abueappint;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Button lla, men;
    private ImageButton em, emg;
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //conf=(ImageButton)findViewById(R.id.conf);
        lla = (Button) findViewById(R.id.llamada);
        men = (Button) findViewById(R.id.mensaj);
        em = (ImageButton) findViewById(R.id.emergenc);
        emg = (ImageButton) findViewById(R.id.emergenci);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

    sensorEventListener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if(sensorEvent.values[0]==0){
                llamaem();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };


    }


    public void conf(View view) {
        Intent con = new Intent(this, config.class);
        startActivity(con);
    }

    public void cuadro(View view) {
        lla.setEnabled(true);
        lla.setVisibility(View.VISIBLE);
        men.setEnabled(true);
        men.setVisibility(View.VISIBLE);
    }

    public void mensaje(View view) {
        Intent con = new Intent(this, mensajes.class);
        startActivity(con);
    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
    public void llama(View view) {
        String dial = "tel:" + "4274274294";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(sensorEventListener,sensor,0);
    }

    public void llamaem() {
        String dial = "tel:" + "4274274294";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));

    }

}
