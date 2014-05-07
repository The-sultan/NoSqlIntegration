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
public class NodoCamino {
    private Ciudad ciudad;
    private boolean visited;
    private float distancia;
    private String[] rutas;
    
    public NodoCamino(Ciudad ciudad, boolean visited, float distancia, String[] rutas) {
        this.ciudad = ciudad;
        this.visited = visited;
        this.distancia = distancia;
        this.rutas = rutas;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public boolean isVisited() {
        return visited;
    }

    public float getDistancia() {
        return distancia;
    }

    public String[] getRutas() {
        return rutas;
    }
    
    @Override
    public String toString(){
        String resultado = ciudad.getNombre();
        if (rutas != null){
            resultado += " " + Float.toString(distancia) +"kms por las rutas: ";
            for(int i=0; i<rutas.length; i++){
                if (i!= 0 && i!= rutas.length-1)
                {
                    resultado +=", ";
                }
                else if (i!= rutas.length-1){
                    resultado +=" y ";
                }
                resultado += rutas[i];
            }
        }
        return resultado;
    }
}
