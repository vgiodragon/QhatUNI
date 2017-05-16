package com.smartcity.qhatuni;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by root on 30/04/16.
 */
public class ActividadAdapter extends RecyclerView.Adapter<ActividadAdapter.ActividadViewHolder>{
    private List<Actividad> listaActividades;

    public ActividadAdapter(List<Actividad> listaActividades){
        this.listaActividades = listaActividades;
    }

    @Override
    public int getItemCount() {
        return listaActividades.size();
    }

    @Override
    public void onBindViewHolder(ActividadAdapter.ActividadViewHolder holder, int position) {
        Actividad actividad = listaActividades.get(position);
        holder.hora.setText(actividad.hora+":"+actividad.minuto);
        holder.titulo.setText(actividad.titulo);
        holder.ponente.setText(actividad.ponente);
        holder.descripcion.setText(actividad.descripcion);
        holder.dia.setText(actividad.dia);
        holder.idalerta.setText(actividad.idalerta);
    }

    @Override
    public ActividadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_actividad, parent, false);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_charla, parent, false);
        return new ActividadViewHolder(itemView);
    }

    public static class ActividadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        protected TextView hora;
        protected TextView titulo;
        protected TextView ponente;
        protected TextView descripcion;
        protected TextView dia;
        protected Switch alarma;
        protected TextView idalerta;

        public ActividadViewHolder(View v) {
            super(v);
            this.dia = (TextView) v.findViewById(R.id.texto_dia_actividad);
            this.hora = (TextView) v.findViewById(R.id.texto_hora_actividad);
            this.titulo = (TextView) v.findViewById(R.id.texto_titulo_actividad);
            this.ponente = (TextView) v.findViewById(R.id.texto_ponente_actividad);
            this.descripcion = (TextView) v.findViewById(R.id.texto_descripcion_actividad);
            this.alarma = (Switch) v.findViewById(R.id.switch1);
            this.idalerta = (TextView) v.findViewById(R.id.texto_int_alertaid);
            this.alarma.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // do something, the isChecked will be
                    // true if the switch is in the On position
                    if(isChecked){
                        Toast.makeText(hora.getContext(), "Alarma activada", Toast.LENGTH_SHORT).show();
                        Log.d("tocametocame", hora.getText()+"/"+titulo.getText());
                        int d, h, m;
                        String horas = hora.getText().toString();
                        String[] horamin = horas.split(":");
                        d = Integer.parseInt(dia.getText().toString());
                        h = Integer.parseInt(horamin[0]);
                        m = Integer.parseInt(horamin[1]);

                        Intent alertIntent = new Intent(hora.getContext(), AlertReceiver.class);
                        alertIntent.putExtra("tituloevento",titulo.getText());
                        alertIntent.putExtra("horaevento",hora.getText());
                        alertIntent.putExtra("idalerta",idalerta.getText());
                        AlarmManager alarmManager = (AlarmManager) hora.getContext().getSystemService(Context.ALARM_SERVICE);
                        Long alertime = new GregorianCalendar().getTimeInMillis();

                        Calendar calendarEvento = Calendar.getInstance();
                        calendarEvento.setTimeInMillis(System.currentTimeMillis());
                        calendarEvento.set(Calendar.DAY_OF_MONTH, d);
                        calendarEvento.set(Calendar.HOUR_OF_DAY, h);
                        calendarEvento.set(Calendar.MINUTE, m);

                        int _id = (int) System.currentTimeMillis();
                        //alarmManager.set(AlarmManager.RTC_WAKEUP, alertime, PendingIntent.getBroadcast(hora.getContext(), _id, alertIntent, PendingIntent.FLAG_UPDATE_CURRENT));
                        alarmManager.set(AlarmManager.RTC_WAKEUP, calendarEvento.getTimeInMillis(), PendingIntent.getBroadcast(hora.getContext(), _id, alertIntent, PendingIntent.FLAG_UPDATE_CURRENT));
                    }
                    else{
                        Toast.makeText(hora.getContext(), "Alarma cancelada", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            this.hora.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

        }
    }
}
