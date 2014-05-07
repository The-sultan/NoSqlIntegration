/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.entities;

/**
 *
 * @author johann
 */
public class Recorrido {
    private float distancia;
    private NodoCamino[] nodos;

    public Recorrido(float distancia, NodoCamino[] nodos) {
        this.distancia = distancia;
        this.nodos = nodos;
    }

    public float getDistancia() {
        return distancia;
    }

    public NodoCamino[] getNodos() {
        return nodos;
    }
    
}
