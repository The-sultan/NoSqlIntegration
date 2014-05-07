/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.RESTEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author johann
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecorridoREST {
    private float distanciaTotal;
    private Ciudad[] ciudades;
    private Tramo[] rutas;

    public Tramo[] getRutas() {
        return rutas;
    }

    public void setRutas(Tramo[] rutas) {
        this.rutas = rutas;
    }
    
    public float getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(float distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }

    public Ciudad[] getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudad[] ciudades) {
        this.ciudades = ciudades;
    }
}
