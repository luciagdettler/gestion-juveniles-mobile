package com.gestionjuveniles.appmobile;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.gestionjuveniles.appmobile.Interfaz.BusquedaUsuarioListener;
import com.gestionjuveniles.appmobile.Repositorio.AsinTaskFirebase;
import com.gestionjuveniles.appmobile.Repositorio.ReciclerAdapter;
import com.gestionjuveniles.appmobile.Repositorio.RecyclerItemClickListener;
import com.gestionjuveniles.appmobile.domain.Player;
import com.gestionjuveniles.appmobile.domain.Team;
import com.gestionjuveniles.appmobile.domain.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Form_previa_activity extends AppCompatActivity implements BusquedaUsuarioListener{


    private RecyclerView listaJugadores;
    ReciclerAdapter adaptador;
    private Team team;

    private Player arquero;
    private Player defensor1;
    private Player defensor2;
    private Player defensor3;
    private Player defensor4;
    private Player mediocampista1;
    private Player mediocampista2;
    private Player mediocampista3;
    private Player delantero1;
    private Player delantero2;
    private Player delantero3;
    private ArrayAdapter<Player> arqAdapter;
    private ArrayAdapter<Player> delAdapter;
    private ArrayAdapter<Player> medAdapter;
    private ArrayAdapter<Player> defAdapter;


    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_previa_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaJugadores= (RecyclerView) findViewById(R.id.rv);
        listaJugadores.setHasFixedSize(true);

        //adapter = new Equipo_BaseAdapter(Form_previa_activity.this, (ArrayList<PlayerPosition>) team.getFormation());
        //listaJugadores.setAdapter(adapter);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        listaJugadores.setLayoutManager(mLayoutManager);



        AsinTaskFirebase ejemploAsyncTask = new AsinTaskFirebase(this);
        ejemploAsyncTask.execute();


    }

  /*  @Override
    protected void onResume() {
        super.onResume();

        listaJugadores.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),listaJugadores, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                final  DatabaseReference ref = database.getReference("users").child("0").child("teams").child("0").child("formation");


                switch(position){
                    case 0:
                        AlertDialog.Builder builder0= new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Arqueros:")
                                .setSingleChoiceItems(arqAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        arquero = arqAdapter.getItem(which);
                                        Log.d("fechaActual","se seleccionno el "+ arquero.getName());
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        team.getFormation().get(0).setPlayerId(arquero.getId());
                                        ref.child("0").child("playerId").setValue(arquero.getId());
                                        adapter.updateResults((ArrayList<PlayerPosition>) team.getFormation());
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert0 = builder0.create();
                        alert0.show();


                        break;
                    case 1:
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Defensores:")
                                .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        defensor1 = defAdapter.getItem(which);
                                        Log.d("fechaActual",defensor1.getId().toString());
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(defensor1.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(1).setPlayerId(defensor1.getId());
                                            ref.child("1").child("playerId").setValue(defensor1.getId());
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert1 = builder1.create();
                        alert1.show();
                        break;
                    case 2:
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Defensores:")
                                .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        defensor2 = defAdapter.getItem(which);                                }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(defensor2.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(2).setPlayerId(defensor2.getId());
                                            ref.child("2").child("playerId").setValue(defensor2.getId());

                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert2 = builder2.create();
                        alert2.show();
                        break;
                    case 3:
                        AlertDialog.Builder builder3 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Defensores:")
                                .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        defensor3 = defAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(defensor3.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(3).setPlayerId(defensor3.getId());
                                            ref.child("3").child("playerId").setValue(defensor3.getId());

                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert3 = builder3.create();
                        alert3.show();
                        break;
                    case 4:
                        AlertDialog.Builder builder4 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Mediocampistas:")
                                .setSingleChoiceItems(medAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        mediocampista1=medAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(mediocampista1.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(4).setPlayerId(mediocampista1.getId());
                                            ref.child("4").child("playerId").setValue(mediocampista1.getId());

                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert4 = builder4.create();
                        alert4.show();
                        break;
                    case 5:
                        AlertDialog.Builder builder5 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Defensores:")
                                .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        defensor4=defAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(defensor4.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(5).setPlayerId(defensor4.getId());
                                            ref.child("5").child("playerId").setValue(defensor4.getId());

                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert5 = builder5.create();
                        alert5.show();
                        break;
                    case 6:
                        AlertDialog.Builder builder6 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Delanteros:")
                                .setSingleChoiceItems(delAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        delantero1=delAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(delantero1.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(6).setPlayerId(delantero1.getId());
                                            ref.child("6").child("playerId").setValue(delantero1.getId());

                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert6 = builder6.create();
                        alert6.show();
                        break;
                    case 7:
                        AlertDialog.Builder builder7 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Mediocampistas;")
                                .setSingleChoiceItems(medAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        mediocampista2=medAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(mediocampista2.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(7).setPlayerId(mediocampista2.getId());
                                            ref.child("7").child("playerId").setValue(mediocampista2.getId());

                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert7 = builder7.create();
                        alert7.show();
                        break;
                    case 8:
                        AlertDialog.Builder builder8 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Delanteros:")
                                .setSingleChoiceItems(delAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        delantero2=delAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(delantero2.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(8).setPlayerId(delantero2.getId());

                                            ref.child("8").child("playerId").setValue(delantero2.getId());
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert8 = builder8.create();
                        alert8.show();
                        break;
                    case 9:
                        AlertDialog.Builder builder9 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Mediocampistas:")
                                .setSingleChoiceItems(medAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        mediocampista3=medAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(mediocampista3.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(9).setPlayerId(mediocampista3.getId());
                                            ref.child("9").child("playerId").setValue(mediocampista3.getId());

                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert9 = builder9.create();
                        alert9.show();
                        break;
                    case 10:
                        AlertDialog.Builder builder10 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Delanteros:")
                                .setSingleChoiceItems(delAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        delantero3=delAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(delantero3.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(10).setPlayerId(delantero3.getId());
                                            ref.child("10").child("playerId").setValue(delantero3.getId());

                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert10 = builder10.create();
                        alert10.show();
                        break;

            }
        }}));
    }




   /* listaJugadores.setOnItemClickListener(new  AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


           final  DatabaseReference ref = database.getReference("users").child("0").child("teams").child("0").child("formation");


            switch(position){
                case 0:
                    AlertDialog.Builder builder0= new AlertDialog.Builder(Form_previa_activity.this)
                            .setTitle("Arqueros:")
                            .setSingleChoiceItems(arqAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    arquero = arqAdapter.getItem(which);
                                    Log.d("fechaActual","se seleccionno el "+ arquero.getName());
                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    team.getFormation().get(0).setPlayerId(arquero.getId());
                                    ref.child("0").child("playerId").setValue(arquero.getId());
                                    adapter.updateResults((ArrayList<PlayerPosition>) team.getFormation());
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert0 = builder0.create();
                    alert0.show();


                    break;
                case 1:
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(Form_previa_activity.this)
                            .setTitle("Defensores:")
                            .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    defensor1 = defAdapter.getItem(which);
                                    Log.d("fechaActual",defensor1.getId().toString());
                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                  if(team.estaEnFormacion(defensor1.getId()))
                                      Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                  else{
                                       team.getFormation().get(1).setPlayerId(defensor1.getId());
                                       ref.child("1").child("playerId").setValue(defensor1.getId());
                                      }
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert1 = builder1.create();
                    alert1.show();
                    break;
                case 2:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(Form_previa_activity.this)
                            .setTitle("Defensores:")
                            .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    defensor2 = defAdapter.getItem(which);                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if(team.estaEnFormacion(defensor2.getId()))
                                        Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                    else{
                                    team.getFormation().get(2).setPlayerId(defensor2.getId());
                                    ref.child("2").child("playerId").setValue(defensor2.getId());

                                        }
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert2 = builder2.create();
                    alert2.show();
                    break;
                case 3:
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(Form_previa_activity.this)
                            .setTitle("Defensores:")
                            .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    defensor3 = defAdapter.getItem(which);
                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if(team.estaEnFormacion(defensor3.getId()))
                                        Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                    else{
                                    team.getFormation().get(3).setPlayerId(defensor3.getId());
                                    ref.child("3").child("playerId").setValue(defensor3.getId());

                                        }
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert3 = builder3.create();
                    alert3.show();
                    break;
                case 4:
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(Form_previa_activity.this)
                            .setTitle("Mediocampistas:")
                            .setSingleChoiceItems(medAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    mediocampista1=medAdapter.getItem(which);
                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if(team.estaEnFormacion(mediocampista1.getId()))
                                        Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                    else{
                                    team.getFormation().get(4).setPlayerId(mediocampista1.getId());
                                    ref.child("4").child("playerId").setValue(mediocampista1.getId());

                                        }
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert4 = builder4.create();
                    alert4.show();
                    break;
                case 5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(Form_previa_activity.this)
                            .setTitle("Defensores:")
                            .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    defensor4=defAdapter.getItem(which);
                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if(team.estaEnFormacion(defensor4.getId()))
                                        Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                    else{
                                        team.getFormation().get(5).setPlayerId(defensor4.getId());
                                        ref.child("5").child("playerId").setValue(defensor4.getId());

                                        }
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert5 = builder5.create();
                    alert5.show();
                    break;
                case 6:
                    AlertDialog.Builder builder6 = new AlertDialog.Builder(Form_previa_activity.this)
                            .setTitle("Delanteros:")
                            .setSingleChoiceItems(delAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    delantero1=delAdapter.getItem(which);
                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if(team.estaEnFormacion(delantero1.getId()))
                                        Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                    else{
                                    team.getFormation().get(6).setPlayerId(delantero1.getId());
                                    ref.child("6").child("playerId").setValue(delantero1.getId());

                                        }
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert6 = builder6.create();
                    alert6.show();
                    break;
                case 7:
                    AlertDialog.Builder builder7 = new AlertDialog.Builder(Form_previa_activity.this)
                            .setTitle("Mediocampistas;")
                            .setSingleChoiceItems(medAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    mediocampista2=medAdapter.getItem(which);
                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if(team.estaEnFormacion(mediocampista2.getId()))
                                        Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                   else{
                                    team.getFormation().get(7).setPlayerId(mediocampista2.getId());
                                    ref.child("7").child("playerId").setValue(mediocampista2.getId());

                                        }
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert7 = builder7.create();
                    alert7.show();
                    break;
                case 8:
                    AlertDialog.Builder builder8 = new AlertDialog.Builder(Form_previa_activity.this)
                            .setTitle("Delanteros:")
                            .setSingleChoiceItems(delAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    delantero2=delAdapter.getItem(which);
                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if(team.estaEnFormacion(delantero2.getId()))
                                        Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                   else{
                                        team.getFormation().get(8).setPlayerId(delantero2.getId());

                                    ref.child("8").child("playerId").setValue(delantero2.getId());
                                        }
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert8 = builder8.create();
                    alert8.show();
                    break;
                case 9:
                    AlertDialog.Builder builder9 = new AlertDialog.Builder(Form_previa_activity.this)
                            .setTitle("Mediocampistas:")
                            .setSingleChoiceItems(medAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    mediocampista3=medAdapter.getItem(which);
                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if(team.estaEnFormacion(mediocampista3.getId()))
                                        Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                    else{
                                    team.getFormation().get(9).setPlayerId(mediocampista3.getId());
                                    ref.child("9").child("playerId").setValue(mediocampista3.getId());

                                        }
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert9 = builder9.create();
                    alert9.show();
                    break;
                case 10:
                    AlertDialog.Builder builder10 = new AlertDialog.Builder(Form_previa_activity.this)
                            .setTitle("Delanteros:")
                            .setSingleChoiceItems(delAdapter,0, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    delantero3=delAdapter.getItem(which);
                                }
                            })
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if(team.estaEnFormacion(delantero3.getId()))
                                        Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                   else{
                                    team.getFormation().get(10).setPlayerId(delantero3.getId());
                                   ref.child("10").child("playerId").setValue(delantero3.getId());

                                        }
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert10 = builder10.create();
                    alert10.show();
                    break;
            }

    }
});*/


    public void busquedaFinalizada(User u) {

        Log.d("TAG","usuario: "+u.getName());
        team = u.getTeams().get(0);
        team.setearPlayers(team.getFormation());
        adaptador=new ReciclerAdapter(team.getFormation());
        listaJugadores.setAdapter(adaptador);
        arqAdapter  = new ArrayAdapter<Player>(
                Form_previa_activity.this,
                android.R.layout.simple_list_item_single_choice,
                team.getArq());
        defAdapter = new ArrayAdapter<Player>(
                Form_previa_activity.this,
                android.R.layout.simple_list_item_single_choice,
                team.getDef());
        medAdapter = new ArrayAdapter<Player>(
                Form_previa_activity.this,
                android.R.layout.simple_list_item_single_choice,
                team.getMed());
        delAdapter = new ArrayAdapter<Player>(
                Form_previa_activity.this,
                android.R.layout.simple_list_item_single_choice,
                team.getDel());


        listaJugadores.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),listaJugadores, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                final  DatabaseReference ref = database.getReference("users").child("0").child("teams").child("0").child("formation");


                switch(position){
                    case 0:
                        AlertDialog.Builder builder0= new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Arqueros:")
                                .setSingleChoiceItems(arqAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        arquero = arqAdapter.getItem(which);
                                        Log.d("fechaActual","se seleccionno el "+ arquero.getName());
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        team.getFormation().get(0).setPlayerId(arquero.getId());
                                        team.getFormation().get(0).setJug(arquero);
                                        ref.child("0").child("playerId").setValue(arquero.getId());
                                        adaptador.notifyDataSetChanged();
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert0 = builder0.create();
                        alert0.show();
                        break;
                    case 1:
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Defensores:")
                                .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        defensor1 = defAdapter.getItem(which);

                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(defensor1.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(1).setPlayerId(defensor1.getId());
                                            team.getFormation().get(1).setJug(defensor1);
                                            ref.child("1").child("playerId").setValue(defensor1.getId());
                                            adaptador.notifyDataSetChanged();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert1 = builder1.create();
                        alert1.show();
                        break;
                    case 2:
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Defensores:")
                                .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        defensor2 = defAdapter.getItem(which);                                }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(defensor2.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(2).setPlayerId(defensor2.getId());
                                           team.getFormation().get(2).setJug(defensor2);
                                            ref.child("2").child("playerId").setValue(defensor2.getId());
                                            adaptador.notifyDataSetChanged();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert2 = builder2.create();
                        alert2.show();
                        break;
                    case 3:
                        AlertDialog.Builder builder3 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Defensores:")
                                .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        defensor3 = defAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(defensor3.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(3).setPlayerId(defensor3.getId());
                                            team.getFormation().get(3).setJug(defensor3);
                                            ref.child("3").child("playerId").setValue(defensor3.getId());
                                            adaptador.notifyDataSetChanged();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert3 = builder3.create();
                        alert3.show();
                        break;
                    case 4:
                        AlertDialog.Builder builder4 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Mediocampistas:")
                                .setSingleChoiceItems(medAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        mediocampista1=medAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(mediocampista1.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(4).setPlayerId(mediocampista1.getId());
                                            team.getFormation().get(4).setJug(mediocampista1);
                                            ref.child("4").child("playerId").setValue(mediocampista1.getId());
                                            adaptador.notifyDataSetChanged();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert4 = builder4.create();
                        alert4.show();
                        break;
                    case 5:
                        AlertDialog.Builder builder5 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Defensores:")
                                .setSingleChoiceItems(defAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        defensor4=defAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(defensor4.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(5).setPlayerId(defensor4.getId());
                                            team.getFormation().get(5).setJug(defensor4);
                                            ref.child("5").child("playerId").setValue(defensor4.getId());
                                            adaptador.notifyDataSetChanged();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert5 = builder5.create();
                        alert5.show();
                        break;
                    case 6:
                        AlertDialog.Builder builder6 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Delanteros:")
                                .setSingleChoiceItems(delAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        delantero1=delAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(delantero1.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(6).setPlayerId(delantero1.getId());
                                            team.getFormation().get(6).setJug(delantero1);
                                            ref.child("6").child("playerId").setValue(delantero1.getId());
                                            adaptador.notifyDataSetChanged();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert6 = builder6.create();
                        alert6.show();
                        break;
                    case 7:
                        AlertDialog.Builder builder7 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Mediocampistas;")
                                .setSingleChoiceItems(medAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        mediocampista2=medAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(mediocampista2.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(7).setPlayerId(mediocampista2.getId());
                                            team.getFormation().get(7).setJug(mediocampista1);
                                            ref.child("7").child("playerId").setValue(mediocampista2.getId());
                                            adaptador.notifyDataSetChanged();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert7 = builder7.create();
                        alert7.show();
                        break;
                    case 8:
                        AlertDialog.Builder builder8 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Delanteros:")
                                .setSingleChoiceItems(delAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        delantero2=delAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(delantero2.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(8).setPlayerId(delantero2.getId());
                                            team.getFormation().get(8).setJug(delantero2);
                                            ref.child("8").child("playerId").setValue(delantero2.getId());
                                            adaptador.notifyDataSetChanged();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert8 = builder8.create();
                        alert8.show();
                        break;
                    case 9:
                        AlertDialog.Builder builder9 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Mediocampistas:")
                                .setSingleChoiceItems(medAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        mediocampista3=medAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(mediocampista3.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(9).setPlayerId(mediocampista3.getId());
                                            team.getFormation().get(9).setJug(mediocampista3);
                                            ref.child("9").child("playerId").setValue(mediocampista3.getId());
                                            adaptador.notifyDataSetChanged();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert9 = builder9.create();
                        alert9.show();
                        break;
                    case 10:
                        AlertDialog.Builder builder10 = new AlertDialog.Builder(Form_previa_activity.this)
                                .setTitle("Delanteros:")
                                .setSingleChoiceItems(delAdapter,0, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        delantero3=delAdapter.getItem(which);
                                    }
                                })
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(team.estaEnFormacion(delantero3.getId()))
                                            Toast.makeText(Form_previa_activity.this,"El jugador ya fue elegido. Por favor eliga otro jugador",Toast.LENGTH_SHORT).show();
                                        else{
                                            team.getFormation().get(10).setPlayerId(delantero3.getId());
                                            team.getFormation().get(10).setJug(delantero3);
                                            ref.child("10").child("playerId").setValue(delantero3.getId());
                                            adaptador.notifyDataSetChanged();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert10 = builder10.create();
                        alert10.show();
                        break;

                }
            }}));


    }


}