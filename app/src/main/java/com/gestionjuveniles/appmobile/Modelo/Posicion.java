package com.gestionjuveniles.appmobile.Modelo;

import java.io.Serializable;

/**
 * Created by Usuario on 6/2/2017.
 */
public class Posicion implements Serializable{

    private String cod;
    public Posicion(String s){
        this.cod = s;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }


}
