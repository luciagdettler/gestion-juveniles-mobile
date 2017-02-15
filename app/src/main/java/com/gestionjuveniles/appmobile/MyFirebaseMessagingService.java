package com.gestionjuveniles.appmobile;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Usuario on 24/1/2017.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public MyFirebaseMessagingService() {
    }

    public static final String TAG="NOTICIAS";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

       String from = remoteMessage.getFrom();
        Log.d(TAG,"Mensaje recibido de:"+from);

        if(remoteMessage.getNotification() != null){
            Log.d(TAG,"Notificacion:"+remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());
        }
    }

    public void sendNotification(String message){
        NotificationManager nManager = (NotificationManager) getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Intent targetIntent = new Intent();
        PendingIntent contentIntent = PendingIntent.getActivity(getBaseContext(), 0,targetIntent, 0);

        Uri notificactionSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext())
                .setContentIntent(contentIntent)
                .setContentTitle("Gestión Juveniles")
                .setContentText(message)
                .setSound(notificactionSound)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(contentIntent);

        builder.setAutoCancel(true);
        nManager.notify(123456,builder.build());
    }
}
