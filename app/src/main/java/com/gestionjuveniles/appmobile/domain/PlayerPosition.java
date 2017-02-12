package com.gestionjuveniles.appmobile.domain;

import java.io.Serializable;

/**
 * Created by Usuario on 6/2/2017.
 */
public class PlayerPosition implements Serializable{
    private Integer number;
    private Player jug;
    private String position;
    private Integer playerId;

    public PlayerPosition(){

    }

    public PlayerPosition(Integer number) {
        this.number = number;
    }


    public Player getJug() {
        return jug;
    }

    public void setJug(Player jug) {
        this.jug = jug;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }
}
