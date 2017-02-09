package com.gestionjuveniles.appmobile;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gestionjuveniles.appmobile.Modelo.Posicion_Jugador;
import com.gestionjuveniles.appmobile.Modelo.Profesor;
import com.gestionjuveniles.appmobile.Repositorio.Equipo_Adapter;

import java.util.ArrayList;
import java.util.List;

import gestion_juveniles.com.gestionjuveniles_mobile.R;


public class Fecha_Actual extends AppCompatActivity {

    private ListView listaJugadores;
    private Equipo_Adapter adapter;
    private Profesor prof;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha_actual);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listaJugadores= (ListView) findViewById(R.id.listaJugadores);

}

    @Override
    protected void onStart() {
        super.onStart();
       // boolean cargado = equipocargado();
        boolean cargado = false;
        if(cargado){
          //  new BuscarEquipoTask().execute(prof);



        }else {
            //momentaneo hasta hacer lo del login
            List<Posicion_Jugador> formacion= new ArrayList<Posicion_Jugador>();
            prof=new Profesor(null, null);

        }
        adapter = new Equipo_Adapter(Fecha_Actual.this,prof.getEquipo());
        listaJugadores.setAdapter(adapter);



    listaJugadores.setOnItemClickListener(new  AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String[] leadsNames = {
                    "Alexander Pierrot",
                    "Carlos Lopez",
                    "Sara Bonz",
                    "Liliana Clarence",
                    "Benito Peralta",
                    "Juan Jaramillo",
                    "Christian Steps",
                    "Alexa Giraldo",
                    "Linda Murillo",
                    "Lizeth Astrada"
            };

            ArrayAdapter<String> mLeadsAdapter = new ArrayAdapter<String>(
                    Fecha_Actual.this,
                    android.R.layout.simple_list_item_single_choice,
                    leadsNames);
            ArrayList<String> items = new ArrayList<String>();
            items.add("Lucia");
            items.add("Lucia31");

            AlertDialog.Builder builder = new AlertDialog.Builder(Fecha_Actual.this)
                    .setSingleChoiceItems(mLeadsAdapter,0, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // The 'which' argument contains the index position
                            // of the selected item
                        }
                    })
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert = builder.create();
            alert.show();

        }
    });

}
}