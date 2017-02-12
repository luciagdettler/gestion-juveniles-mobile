package com.gestionjuveniles.appmobile.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 7/2/2017.
 */
public class User {

    private Integer id;
    private String nombre;
    private String email;
    private List<Team> team;
    private String pass;

    public User(){
        this.team = new ArrayList<Team>();
    }

    public User(String email, String pass){

        this.email = email;
        this.pass = pass;

       this.team = new ArrayList<Team>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

}