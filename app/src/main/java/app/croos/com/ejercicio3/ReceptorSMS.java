package app.croos.com.ejercicio3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by k_zon on 1/7/2016.
 */
public class ReceptorSMS extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent){
        Log.i("ReceptorSMS", "SMS Recibido");
        Bundle b=intent.getExtras();
        if (b!=null){
            Object[] pdus=(Object[]) b.get("pdus");
            SmsMessage[] mensajes=new SmsMessage[pdus.length];

            for (int i=0; i<mensajes.length; i++){
                mensajes[i]=SmsMessage.createFromPdu((byte[]) pdus[i]);

                String idMensaje = mensajes[i].getOriginatingAddress();
                String textoMensaje = mensajes[i].getMessageBody();

                Log.i("ReceptorSMS", "Remitente: " + idMensaje);
                Log.i("ReceptorSMS", "Mensaje: " + textoMensaje);
            }
        }

    }
}
