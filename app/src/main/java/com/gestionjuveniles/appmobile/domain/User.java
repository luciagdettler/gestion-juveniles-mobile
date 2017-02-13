package com.gestionjuveniles.appmobile.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 7/2/2017.
 */
public class User {

    private Integer id;
    private String name;
    private String email;
    private List<Team> teams;
    private String password;

    public User(){
        this.teams = new ArrayList<Team>();
    }

    public User(String email, String pass){

        this.email = email;
        this.password = pass;

       this.teams = new ArrayList<Team>();

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

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public List<Team> getTeam() {
        return teams;
    }

    public void setTeam(List<Team> team) {
        this.teams = team;
    }

}