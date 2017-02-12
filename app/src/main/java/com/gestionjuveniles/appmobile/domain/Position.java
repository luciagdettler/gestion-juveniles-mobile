package com.gestionjuveniles.appmobile.domain;

import java.io.Serializable;

/**
 * Created by Usuario on 6/2/2017.
 */
public class Position implements Serializable{

    private String cod;
    public Position(String s){
        this.cod = s;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }


}
