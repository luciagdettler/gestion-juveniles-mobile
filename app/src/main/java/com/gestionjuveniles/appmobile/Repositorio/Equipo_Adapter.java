package com.gestionjuveniles.appmobile.Repositorio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gestionjuveniles.appmobile.Modelo.Posicion_Jugador;

import java.util.List;

import gestion_juveniles.com.gestionjuveniles_mobile.R;


/**
 * Created by Usuario on 7/2/2017.
 */
public class Equipo_Adapter  extends ArrayAdapter<Posicion_Jugador> {
    private LayoutInflater inflater;
    private Context contexto;

    public Equipo_Adapter(Context contexto, List<Posicion_Jugador> items) {
        super(contexto, R.layout.fila,items);
        inflater = LayoutInflater.from(contexto);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) row = inflater.inflate(R.layout.fila, parent, false);
        TextView txtNum = (TextView) row.findViewById(R.id.num);
        txtNum.setText(this.getItem(position).getPos().toString()+" - ");
        TextView txtNombre = (TextView) row.findViewById(R.id.nombre);
     //  txtNombre.setText(this.getItem(position).getJug().getNombre());
        TextView txtPosicion = (TextView) row.findViewById(R.id.pos);
       txtPosicion.setText(" - " + this.getItem(position).getPosicion().getCod());
        return row;
    }
}
