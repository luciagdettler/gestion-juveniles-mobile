package com.gestionjuveniles.appmobile.Modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Usuario on 6/2/2017.
 */
public class Equipo implements Serializable {

    private Integer id;
    private List<Posicion_Jugador> equipo;

    public Equipo(){
        Posicion arq =new Posicion ("arq");
        Posicion_Jugador j1 = new Posicion_Jugador(1,arq);
        equipo.add(j1);
        Posicion def1 =new Posicion ("def");
        Posicion_Jugador j2 = new Posicion_Jugador(4,def1);
        equipo.add(j2);
        Posicion def2 =new Posicion ("def");
        Posicion_Jugador j3 = new Posicion_Jugador(2,def2);
        equipo.add(j3);
        Posicion def3 =new Posicion ("def");
        Posicion_Jugador j4 = new Posicion_Jugador(6,def3);
        equipo.add(j4);
        Posicion def4 =new Posicion ("def");
        Posicion_Jugador j5 = new Posicion_Jugador(3,def4);
        equipo.add(j5);
        Posicion med1 =new Posicion ("med");
        Posicion_Jugador j6 = new Posicion_Jugador(8,med1);
        equipo.add(j6);
        Posicion med2 =new Posicion ("med");
        Posicion_Jugador j7 = new Posicion_Jugador(10,med2);
        equipo.add(j7);
        Posicion med3 =new Posicion ("med");
        Posicion_Jugador j8 = new Posicion_Jugador(5,med3);
        equipo.add(j8);
        Posicion del1 =new Posicion ("del");
        Posicion_Jugador j9 = new Posicion_Jugador(11,del1);
        equipo.add(j9);
        Posicion del2 =new Posicion ("del");
        Posicion_Jugador j10 = new Posicion_Jugador(9,del2);
        equipo.add(j10);
        Posicion del3 =new Posicion ("del");
        Posicion_Jugador j11 = new Posicion_Jugador(7,del3);
        equipo.add(j11);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Posicion_Jugador> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Posicion_Jugador> equipo) {
        this.equipo = equipo;
    }
}
