package com.gestionjuveniles.appmobile;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gestionjuveniles.appmobile.Modelo.Posicion_Jugador;
import com.gestionjuveniles.appmobile.Modelo.Profesor;
import com.gestionjuveniles.appmobile.Repositorio.Equipo_Adapter;

import java.util.ArrayList;
import java.util.List;



public class Fecha_Actual extends AppCompatActivity {

    private ListView listaJugadores;
    private Equipo_Adapter adapter;
    private Profesor prof;
    String[] nombres = {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fecha_actual);
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




        }else {
            //momentaneo hasta hacer lo del login
            List<Posicion_Jugador> formacion= new ArrayList<Posicion_Jugador>();
            prof=new Profesor(null, null);

        }
        adapter = new Equipo_Adapter(Fecha_Actual.this,prof.getEquipo().get(0).getEquipo());
        listaJugadores.setAdapter(adapter);



    listaJugadores.setOnItemClickListener(new  AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            ArrayAdapter<String> mLeadsAdapter = new ArrayAdapter<String>(
                    Fecha_Actual.this,
                    android.R.layout.simple_list_item_single_choice,
                    nombres);


            switch(position){
                case 0:
                    Log.d("Arquero","Se selecciono el arquero");
                    AlertDialog.Builder builderArq = new AlertDialog.Builder(Fecha_Actual.this)
                            .setTitle("Arqueros:")
                            .setSingleChoiceItems(mLeadsAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alertArq = builderArq.create();
                    alertArq.show();
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                    Log.d("Defensor","Se selecciono el defensor");
                    AlertDialog.Builder builderDef = new AlertDialog.Builder(Fecha_Actual.this)
                            .setTitle("Defensores:")
                            .setSingleChoiceItems(mLeadsAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alertDef = builderDef.create();
                    alertDef.show();
                    break;
                case 5:
                case 6:
                case 7:
                    Log.d("Mediocampista","Se selecciono el mediocampista");
                    AlertDialog.Builder builderMed = new AlertDialog.Builder(Fecha_Actual.this)
                            .setTitle("Mediocampistas;")
                            .setSingleChoiceItems(mLeadsAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alertMed = builderMed.create();
                    alertMed.show();
                    break;
                case 8:
                case 9:
                case 10:
                    Log.d("Delantero","Se selecciono el delanter");
                    AlertDialog.Builder builderDel = new AlertDialog.Builder(Fecha_Actual.this)
                            .setTitle("Delanteros:")
                            .setSingleChoiceItems(mLeadsAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alertDel = builderDel.create();
                    alertDel.show();
                    break;



            }

    }
});
}
}