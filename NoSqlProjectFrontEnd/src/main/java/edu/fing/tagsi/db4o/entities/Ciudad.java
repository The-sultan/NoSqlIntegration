/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.entities;

import java.util.UUID;

/**
 *
 * @author johann
 */
public class Ciudad {

    public Ciudad(String nombre){
        this.nombre = nombre;
        this.id = UUID.randomUUID();
    }
    
    private String nombre;
    private UUID id;
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    public UUID getId() {
        return id;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
