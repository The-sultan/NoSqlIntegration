/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.RESTEntities;

/**
 *
 * @author johann
 */
public class Tramo {
    private float distancia;
    private String[] rutas;

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public String[] getRutas() {
        return rutas;
    }

    public void setRutas(String[] rutas) {
        this.rutas = rutas;
    }
    
}
