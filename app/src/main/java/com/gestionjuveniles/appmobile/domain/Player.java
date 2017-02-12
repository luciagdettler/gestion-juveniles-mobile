package com.gestionjuveniles.appmobile.domain;

import java.io.Serializable;

/**
 * Created by Usuario on 6/2/2017.
 */
public class Player implements Serializable {
    private Integer id;
    private String name;

    public Player(){}

    public Player(Integer id, String name){
        this.id = id;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
