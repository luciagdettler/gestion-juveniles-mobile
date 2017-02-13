package com.gestionjuveniles.appmobile.Repositorio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gestionjuveniles.appmobile.domain.PlayerPosition;
import com.gestionjuveniles.appmobile.R;

import java.util.List;



/**
 * Created by Usuario on 7/2/2017.
 */
public class Equipo_Adapter  extends ArrayAdapter<PlayerPosition> {
    private LayoutInflater inflater;
    private Context contexto;

    public Equipo_Adapter(Context contexto, List<PlayerPosition> items) {
        super(contexto, R.layout.fila,items);
        inflater = LayoutInflater.from(contexto);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) row = inflater.inflate(R.layout.fila, parent, false);
        TextView txtNum = (TextView) row.findViewById(R.id.num);
        txtNum.setText(this.getItem(position).getNumber().toString()+" - ");
       // TextView txtNombre = (TextView) row.findViewById(R.id.name);
      // txtNombre.setText(this.getItem(position).getJug().getName());
        TextView txtPosicion = (TextView) row.findViewById(R.id.number);
       txtPosicion.setText(" - " + this.getItem(position).getPosition());
        return row;
    }
}
