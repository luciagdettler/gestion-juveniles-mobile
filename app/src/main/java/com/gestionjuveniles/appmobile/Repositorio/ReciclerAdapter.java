package com.gestionjuveniles.appmobile.Repositorio;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gestionjuveniles.appmobile.R;
import com.gestionjuveniles.appmobile.domain.PlayerPosition;

import java.util.List;


/**
 * Created by Usuario on 24/2/2017.
 */
public class ReciclerAdapter extends RecyclerView.Adapter<ReciclerAdapter.AnimeViewHolder> {
private List<PlayerPosition> items;

public static class AnimeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    // Campos respectivos de un item
    public TextView pos;
    public TextView num;
    public TextView name;

    public AnimeViewHolder(View v) {
        super(v);
        v.setOnClickListener(this);
        pos = (TextView) v.findViewById(R.id.pos);
        num = (TextView) v.findViewById(R.id.num);
        name = (TextView) v.findViewById(R.id.name);
    }

    @Override
    public void onClick(View view) {


        Log.d("TAG","llego al ioon clic");
    }
}

    public ReciclerAdapter(List<PlayerPosition> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fila, viewGroup, false);
        return new AnimeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AnimeViewHolder viewHolder, int i) {
        viewHolder.num.setText(items.get(i).getNumber().toString());
        viewHolder.pos.setText(items.get(i).getPosition());
        viewHolder.name.setText("Player: " + items.get(i).getPlayerId());
    }
}


