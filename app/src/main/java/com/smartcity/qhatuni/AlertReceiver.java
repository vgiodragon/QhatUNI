package com.smartcity.qhatuni;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {

    String nombreevento;
    String horaevento;
    int idalerta;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        nombreevento = intent.getStringExtra("tituloevento");
        horaevento = intent.getStringExtra("horaevento");
        idalerta = Integer.parseInt(intent.getStringExtra("idalerta"));
        createNotification(context, nombreevento, horaevento);
    }

    public void createNotification(Context context, String message1, String message2){
        PendingIntent notificationIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setContentTitle(message1)
                .setSmallIcon(R.drawable.eduni)
                .setContentText(message2)
                .setTicker("Mensaje de alerta");
        mBuilder.setContentIntent(notificationIntent);

        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND | NotificationCompat.DEFAULT_VIBRATE);

        mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        int alerta_id=(int) System.currentTimeMillis();
        alerta_id = idalerta;
        mNotificationManager.notify(alerta_id, mBuilder.build());
    }
}
