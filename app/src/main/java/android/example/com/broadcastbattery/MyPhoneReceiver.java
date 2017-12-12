package android.example.com.broadcastbattery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MyPhoneReceiver extends BroadcastReceiver{

    public void onReceive(Context context,Intent intent){

        // Sacamos información del intent

        String estado = "", numero = "";

        Bundle extras = intent.getExtras();

        if(extras != null) {

            estado = extras.getString(TelephonyManager.EXTRA_STATE);

            if(estado.equals(TelephonyManager.EXTRA_STATE_RINGING)) {

                numero = extras.getString( TelephonyManager.EXTRA_INCOMING_NUMBER);

            }

        }

        String info = estado + " "+ numero;
        Toast.makeText(context, "Informacion"+info ,Toast.LENGTH_LONG).show();
        //  Log.d("ReceptorAnuncio", info + " intent="+ intent);



    }

}