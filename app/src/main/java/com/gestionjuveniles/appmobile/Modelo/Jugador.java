package com.gestionjuveniles.appmobile.Modelo;

import java.io.Serializable;

/**
 * Created by Usuario on 6/2/2017.
 */
public class Jugador implements Serializable {
    private Integer id;
    private String nombre;

    public Jugador(){}

    public Jugador(Integer id, String nombre){
        this.id = id;
        this.nombre = nombre;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
