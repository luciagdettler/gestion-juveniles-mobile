package com.gestionjuveniles.appmobile.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 7/2/2017.
 */
public class Profesor {

    private Integer id;
    private String nombre;
    private String email;
    private List<Equipo> equipo;
    private String pass;

    public Profesor(){

    }

    public Profesor(String email, String pass){

        this.email = email;
        this.pass = pass;

       this.equipo = new ArrayList<Equipo>();

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

    public List<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Equipo> equipo) {
        this.equipo = equipo;
    }

}