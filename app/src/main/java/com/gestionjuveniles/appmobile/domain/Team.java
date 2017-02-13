package com.gestionjuveniles.appmobile.domain;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Usuario on 6/2/2017.
 */
public class Team implements Serializable {

    private Integer id;
    private List<PlayerPosition> formation;
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
        return formation;
    }

    public void setPlayerPosition(List<PlayerPosition> playerPosition) {
        this.formation = playerPosition;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getArq(){
        List<Player> arq = new ArrayList<Player>();

        for(Player p: players){
            if(p.getPos().equals("ARQ") )
                arq.add(p);
        }
        return arq;
    }

    public List<Player> getDef(){
        List<Player> def = new ArrayList<Player>();

        for(Player p: players){
            if(p.getPos().equals("DEF") )
                def.add(p);
        }
        return def;
    }

    public List<Player> getMed(){
        List<Player> med = new ArrayList<Player>();

        for(Player p: players){
            if(p.getPos().equals("MED") )
                med.add(p);
        }
        return med;
    }

    public List<Player> getDel(){
        List<Player> del = new ArrayList<Player>();

        for(Player p: players){
            if(p.getPos().equals("DEL") )
                del.add(p);
        }
        return del;
    }
}
