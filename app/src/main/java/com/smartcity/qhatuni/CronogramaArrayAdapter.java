package com.smartcity.qhatuni;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by root on 15/04/16.
 */
public class CronogramaArrayAdapter<T> extends ArrayAdapter<T> {
    Fragment fragment;

    public CronogramaArrayAdapter(Context context, List<T> objects, Fragment fragment){
        super(context, 0, objects);
        this.fragment=fragment;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listItemView = convertView;
        if (null == convertView) {
            listItemView = inflater.inflate(
                    R.layout.vista_evento,
                    parent,
                    false);
        }

        //Obteniendo instancias de los elementos
        TextView titulo = (TextView)listItemView.findViewById(R.id.titulo_evento);
        TextView descripcion = (TextView)listItemView.findViewById(R.id.descripcion_evento);
        Button reminder = (Button) listItemView.findViewById(R.id.boton_recordar);

        //Button ver=(Button)listItemView.findViewById(R.id.ver);
        //Button ir=(Button)listItemView.findViewById(R.id.ir);

        final Evento item = (Evento) getItem(position);
        titulo.setText(item.titulo);
        descripcion.setText(item.descripcion);

        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Alarma programada para "+item.time,Toast.LENGTH_SHORT).show();
                Intent alertIntent = new Intent(getContext(), AlertReceiver.class);
                AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                Long alertime = new GregorianCalendar().getTimeInMillis()+5*1000;
                alarmManager.set(AlarmManager.RTC_WAKEUP, alertime, PendingIntent.getBroadcast(getContext(), 1, alertIntent, PendingIntent.FLAG_UPDATE_CURRENT));
            }
        });
        //titulo.setText(item.nombres);
        //ver.setVisibility(View.VISIBLE);
        //ir.setVisibility(View.GONE);
        return listItemView;
    }
}
