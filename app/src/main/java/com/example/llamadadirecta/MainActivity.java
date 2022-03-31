/*Datos adicionales:
Permiso necesario:
<uses-permission android:name="android.permission.CALL_PHONE"/>
 Acción a capturar:
android.hardware.usb.action.USB_STATE
Intent para iniciar Activity de LLamadas:
Intent.ACTION_CALL*/

package com.example.llamadadirecta;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
   private  LlamadaEmergente ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
        && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},100);
        }



    }


     //antes de que se haga visible se activa el método onResume
    @Override
    protected void onResume() {
        super.onResume();

        ll = new LlamadaEmergente();
        registerReceiver(ll, new IntentFilter("android.hardware.usb.action.USB_STATE"));
        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 911"));
        startActivity(in);
    }
  //Desactivar Broadcast
    @Override
    protected void onPause() {
        super.onPause();
       unregisterReceiver(ll);

    }
}