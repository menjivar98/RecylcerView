package com.example.recylcerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersonajes extends RecyclerView.Adapter <AdaptadorPersonajes.HolderPersonajes> {

    ArrayList<PersonajeVo> listaPersonajes;

    public AdaptadorPersonajes(ArrayList<PersonajeVo> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public HolderPersonajes onCreateViewHolder(ViewGroup viewGroup, int i) {
        //View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,null,false);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_personajes,null,false);
        return new HolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(HolderPersonajes holderPersonajes, int i) {
        holderPersonajes.et_nombre.setText(listaPersonajes.get(i).getNombre());
       // holderPersonajes.et_information.setText(listaPersonajes.get(i).getInfo());
        holderPersonajes.foto.setImageResource(listaPersonajes.get(i).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public class HolderPersonajes extends RecyclerView.ViewHolder {

        TextView et_nombre, et_information;
        ImageView foto;

        public HolderPersonajes(View itemView) {
            super(itemView);

            et_nombre = (TextView) itemView.findViewById(R.id.idNombre);
            //et_information = (TextView) itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
