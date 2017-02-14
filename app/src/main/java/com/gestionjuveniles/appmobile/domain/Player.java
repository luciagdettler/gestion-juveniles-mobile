package com.gestionjuveniles.appmobile.domain;

import java.io.Serializable;

/**
 * Created by Usuario on 6/2/2017.
 */
public class Player implements Serializable {
    private Integer id;
    private String name;
    private String position;

    public Player(){}



    public Player(Integer id, String name, String pos){
        this.id = id;
        this.name = name;
        this.position=pos;

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
    public String getPosition() {
        return position;
    }

    public void setPosition(String pos) {
        this.position = pos;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
