package android.example.com.broadcastbattery;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity_Battery extends Activity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__battery);
        checkPhoneStatePermission();

        final Button button = (Button)findViewById(R.id.bClick);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                broadcastIntent(view);
            }
        });


        /*
        Intent battery=new Intent();//CREACION DE UN INTENT PARA DETERMINAR EL NIVEL DE BATERIA
        int level = battery.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = battery.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        Toast.makeText(getApplicationContext(),level,Toast.LENGTH_LONG).show();
        float batteryPct = level / (float)scale;*/
    }


    // broadcast a custom intent.
    //https://www.tutorialspoint.com/android/android_broadcast_receivers.htm
    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("MY_INTENT_DANIEL");//ESTA ES LA ACCION QUE EVALUA IMPORTANTE
        sendBroadcast(intent);
    }

    private void checkPhoneStatePermission() {
        //CHEQUEAMOS EL PERMISO EN EL SISTEMA PARA PERMITIR SMS
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para enviar/recibir SMS.");
            //Cuando la app llama a requestPermissions(), el sistema muestra al usuario
            // un cuadro de diálogo estándar.
            //la app no puede configurar ni modificar ese cuadro de diálogo.
            //Si hay que proporcionar información o
            // una explicación al usuario, hay que hacerlo antes de llamar a requestPermissions(),
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 225);
        } else {
            Log.i("Mensaje", "Se tiene permiso para enviar/recibir SMS!");
        }
    }
}