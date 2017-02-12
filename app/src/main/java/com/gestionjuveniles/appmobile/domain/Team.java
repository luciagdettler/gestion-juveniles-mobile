package com.gestionjuveniles.appmobile.domain;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Usuario on 6/2/2017.
 */
public class Team implements Serializable {

    private Integer id;
    private List<PlayerPosition> playerPosition;
    private List<Player> players;

    public Team(){
        setPlayerPosition(new ArrayList<PlayerPosition>());
        setPlayers(new ArrayList<Player>());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PlayerPosition> getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(List<PlayerPosition> playerPosition) {
        this.playerPosition = playerPosition;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
