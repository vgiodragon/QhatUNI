package com.smartcity.qhatuni.StandsQhatuni2017;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartcity.qhatuni.Model.Stand;
import com.smartcity.qhatuni.R;

import java.util.ArrayList;

/**
 * Created by root on 22/05/17.
 */

public class RecyclerStandsAdapter extends RecyclerView.Adapter<RecyclerStandsAdapter.StandsViewHolder>{
    Context context;
    ArrayList<Stand> standsQhatuni;

    public RecyclerStandsAdapter(Context context, ArrayList<Stand> standsQhatuni){
        this.context = context;
        this.standsQhatuni = standsQhatuni;
    }


    @Override
    public RecyclerStandsAdapter.StandsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_stands_qhatuni, parent, false);
        return new RecyclerStandsAdapter.StandsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerStandsAdapter.StandsViewHolder holder, int position) {
        Stand stand = standsQhatuni.get(position);
        holder.textViewNombreStand.setText(stand.getNombre());
        holder.textViewDireccion.setText(stand.getDireccion());
        holder.textViewUrl.setText(stand.getUrl());
        holder.textViewUrl.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public int getItemCount() {
        return standsQhatuni.size();
    }

    public static class StandsViewHolder extends RecyclerView.ViewHolder{
        TextView textViewNombreStand;
        TextView textViewDireccion;
        TextView textViewUrl;

        public StandsViewHolder(View itemView) {
            super(itemView);
            textViewNombreStand = (TextView) itemView.findViewById(R.id.textview_nombre_stand);
            textViewDireccion = (TextView) itemView.findViewById(R.id.textview_direccion_stand);
            textViewUrl= (TextView) itemView.findViewById(R.id.textview_url_stand);
        }
    }
}
