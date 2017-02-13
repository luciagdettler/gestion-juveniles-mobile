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

import com.gestionjuveniles.appmobile.Repositorio.Equipo_Adapter;
import com.gestionjuveniles.appmobile.domain.Player;
import com.gestionjuveniles.appmobile.domain.PlayerPosition;
import com.gestionjuveniles.appmobile.domain.Team;
import com.gestionjuveniles.appmobile.domain.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Fecha_Actual extends AppCompatActivity {

    private ListView listaJugadores;
    private Equipo_Adapter adapter;
    private User prof;
    private Team team;
   private List<PlayerPosition> formacion;
    private PlayerPosition player;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fecha_actual);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prof = new User();
        team = new Team();

        listaJugadores= (ListView) findViewById(R.id.listaJugadores);
        DatabaseReference firebaseReference = database.getReference("users").child("0").child("teams").child("0");
        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                team = dataSnapshot.getValue(Team.class);

                Log.d("fechaActual", "equipo  "+team.getId() +"   " + team.getPlayers().get(2).getName());

            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                //NADA
            }
        });

}

    @Override
    protected void onStart() {
        super.onStart();
        //boolean cargado = equipocargado();
        boolean cargado = false;
        if(cargado){


       List formacion = team.getPlayerPosition();

        }else {

             formacion= new ArrayList<PlayerPosition>();
            formacion = team.getPlayerPosition();

        }
       adapter = new Equipo_Adapter(Fecha_Actual.this,formacion);
       listaJugadores.setAdapter(adapter);



    listaJugadores.setOnItemClickListener(new  AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            ArrayAdapter<Player> arqAdapter = new ArrayAdapter<Player>(
                    Fecha_Actual.this,
                    android.R.layout.simple_list_item_single_choice,
                    team.getArq());
            ArrayAdapter<Player> delAdapter = new ArrayAdapter<Player>(
                    Fecha_Actual.this,
                    android.R.layout.simple_list_item_single_choice,
                    team.getDel());
            ArrayAdapter<Player> medAdapter = new ArrayAdapter<Player>(
                    Fecha_Actual.this,
                    android.R.layout.simple_list_item_single_choice,
                    team.getMed());
            ArrayAdapter<Player> defAdapter = new ArrayAdapter<Player>(
                    Fecha_Actual.this,
                    android.R.layout.simple_list_item_single_choice,
                    team.getDef());

            switch(position){
                case 0:
                    Log.d("Arquero","Se selecciono el arquero");
                    AlertDialog.Builder builderArq = new AlertDialog.Builder(Fecha_Actual.this)
                            .setTitle("Arqueros:")
                            .setSingleChoiceItems(arqAdapter,0, new DialogInterface.OnClickListener() {
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
                            .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
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
                            .setSingleChoiceItems(medAdapter,0, new DialogInterface.OnClickListener() {
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
                            .setSingleChoiceItems(delAdapter,0, new DialogInterface.OnClickListener() {
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