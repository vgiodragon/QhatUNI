package com.smartcity.qhatuni.ProgramaQhatuni;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartcity.qhatuni.Model.Actividad;
import com.smartcity.qhatuni.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by root on 19/05/17.
 */

public class RecyclerActividadesAdapter extends RecyclerView.Adapter<RecyclerActividadesAdapter.ActividadesViewHolder>{
    Context context;
    ArrayList<Actividad> actividadesQhatuni;

    public RecyclerActividadesAdapter(Context context, ArrayList<Actividad> actividadesQhatuni) {
        this.context = context;
        this.actividadesQhatuni = actividadesQhatuni;
    }

    @Override
    public RecyclerActividadesAdapter.ActividadesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_actividades_qhatuni, parent, false);
        return new RecyclerActividadesAdapter.ActividadesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerActividadesAdapter.ActividadesViewHolder holder, int position) {
        Actividad actividad = actividadesQhatuni.get(position);
        holder.textViewTituloActividad.setText(actividad.getTitulo());
        holder.textViewPonente.setText(actividad.getPonente());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");

        holder.textViewHoraInicio.setText("Inicio: " + simpleDateFormat.format(actividad.getHoraInicio().getTime()));
        holder.textViewHoraFinal.setText("Fin: " + simpleDateFormat.format(actividad.getHoraFin().getTime()));
        holder.textViewLugar.setText(actividad.getLugar().getDescripcion());
    }

    @Override
    public int getItemCount() {
        return actividadesQhatuni.size();
    }

    public static class ActividadesViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTituloActividad;
        TextView textViewPonente;
        TextView textViewHoraInicio;
        TextView textViewHoraFinal;
        TextView textViewLugar;


        public ActividadesViewHolder(View itemView) {
            super(itemView);
            textViewTituloActividad = (TextView) itemView.findViewById(R.id.textview_titulo_actividad);
            textViewPonente = (TextView) itemView.findViewById(R.id.textview_ponente_actividad);
            textViewHoraInicio = (TextView) itemView.findViewById(R.id.textview_hora_inicio_actividad);
            textViewHoraFinal = (TextView) itemView.findViewById(R.id.textview_hora_final_actividad);
            textViewLugar = (TextView) itemView.findViewById(R.id.textview_lugar_actividad);
        }
    }
}
