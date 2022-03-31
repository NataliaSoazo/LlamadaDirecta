package com.example.llamadadirecta;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class LlamadaEmergente extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "LLamada de Emergencia", Toast.LENGTH_SHORT).show();


    }
}