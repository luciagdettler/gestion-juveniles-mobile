package com.gestionjuveniles.appmobile.Modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Usuario on 6/2/2017.
 */
public class Equipo implements Serializable {

    private List<Posicion_Jugador> formacion;

    public Equipo(){  }

    public List<Posicion_Jugador> getFormacion() {
        return formacion;
    }

    public void setFormacion(List<Posicion_Jugador> formacion) {
        this.formacion = formacion;
    }
}
