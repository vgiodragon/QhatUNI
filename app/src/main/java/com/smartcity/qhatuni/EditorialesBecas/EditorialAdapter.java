package com.smartcity.qhatuni.EditorialesBecas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcity.qhatuni.R;

import java.util.List;

/**
 * Created by root on 15/05/16.
 */
public class EditorialAdapter extends RecyclerView.Adapter<EditorialAdapter.EditorialViewHolder> {
    private List<Editorial> listaEditoriales;

    public EditorialAdapter(List<Editorial> listaEditoriales){
        this.listaEditoriales = listaEditoriales;
    }


    @Override
    public EditorialAdapter.EditorialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_stand, parent, false);
        return new EditorialViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EditorialAdapter.EditorialViewHolder holder, int position) {
        Editorial editorial = listaEditoriales.get(position);
        holder.nombreEditorial.setText(editorial.nombre);
        holder.logoEditorial.setImageResource(editorial.imagen);
        holder.telefonoContacto.setText(editorial.telefono);
        holder.direccion.setText(editorial.direccion);
    }

    @Override
    public int getItemCount() {
        return listaEditoriales.size();
    }

    public static class EditorialViewHolder extends RecyclerView.ViewHolder{

        protected TextView nombreEditorial;
        protected ImageView logoEditorial;
        protected TextView telefonoContacto;
        protected TextView direccion;

        public EditorialViewHolder(View itemView) {
            super(itemView);
            this.nombreEditorial = (TextView) itemView.findViewById(R.id.nombre_stand);
            this.logoEditorial = (ImageView) itemView.findViewById(R.id.logo_stand);
            this.telefonoContacto = (TextView) itemView.findViewById(R.id.texto_numero_contacto);
            this.direccion = (TextView) itemView.findViewById(R.id.texto_direccion);
        }
    }
}
