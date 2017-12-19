package android.example.com.broadcastbattery;

import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by dmora on 19/12/2017.
 */

import android.app.Activity;
import android.content.Intent;import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;


public class MyService extends Service {

    private double crono = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "FIN del servicio la var vale" + crono, Toast.LENGTH_SHORT).show();
    }

    //solucion
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(getApplicationContext(), "INICAMOS EL SERVICIO", Toast.LENGTH_SHORT).show();

        // Generem un Thread pel Contador
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    crono = i;
                }
            }
        });
        // dormim el servei 1,5 segons
        try {
            Thread.sleep(1500);
            Toast.makeText(getApplicationContext(), "QUE SUEÑOOOOOOOOOO:" + crono, Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Arranquem el fil d'execució Thread
        hilo.start();
        // Parem el servei
        this.stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

}