package com.gestionjuveniles.appmobile.Repositorio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gestionjuveniles.appmobile.R;
import com.gestionjuveniles.appmobile.domain.PlayerPosition;

import java.util.ArrayList;


/**
 * Created by Usuario on 7/2/2017.
 */
public class Equipo_BaseAdapter extends BaseAdapter {
    private static ArrayList<PlayerPosition> formacion;

    private LayoutInflater mInflater;

    public Equipo_BaseAdapter(Context context, ArrayList<PlayerPosition> results) {
        formacion = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return formacion.size();
    }

    public Object getItem(int position) {
        return formacion.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.fila, null);
            holder = new ViewHolder();
            holder.txtNum = (TextView) convertView.findViewById(R.id.num);

            holder.txtPosicion = (TextView) convertView.findViewById(R.id.pos);

            holder.txtNombre = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtNum.setText(formacion.get(position).getNumber()+" - ");

        holder.txtPosicion.setText(formacion.get(position).getPosition()+" - ");
        if(formacion.get(position).getJug()!=null){
            holder.txtNombre.setText(formacion.get(position).getJug().getName());
        }

        return convertView;
    }

    public void updateResults(ArrayList<PlayerPosition> results) {
        formacion = results;
        //Triggers the list update
        notifyDataSetChanged();
    }


    static class ViewHolder {
        TextView txtNum;
        TextView txtPosicion;
        TextView txtNombre;
    }
}

