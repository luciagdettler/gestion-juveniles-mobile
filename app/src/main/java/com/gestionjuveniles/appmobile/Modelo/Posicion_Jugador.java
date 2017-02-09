package com.gestionjuveniles.appmobile.Modelo;

import java.io.Serializable;

/**
 * Created by Usuario on 6/2/2017.
 */
public class Posicion_Jugador implements Serializable{
    private Integer pos;
    private Posicion posicion;
    private Jugador jug;

    public Posicion_Jugador(Integer pos,Posicion posicion) {
        this.pos = pos;
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public Jugador getJug() {
        return jug;
    }

    public void setJug(Jugador jug) {
        this.jug = jug;
    }

    public void setPosicion(Posicion posicion) {

        this.posicion = posicion;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }
}
