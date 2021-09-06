package com.example.abueappint;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

public class config extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }

    public void regr(View view) {
        Intent con = new Intent(this, MainActivity.class);
        startActivity(con);
    }

    public void contact(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.contacts");
        startActivity( launchIntent );
    }

    public void letra(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.settings");
        startActivity( launchIntent );
    }

    public void localiz(View view) {
        Intent con = new Intent(this, localizacion.class);
        startActivity(con);
    }
}
