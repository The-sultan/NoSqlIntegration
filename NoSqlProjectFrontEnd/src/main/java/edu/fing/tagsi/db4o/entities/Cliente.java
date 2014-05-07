/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fing.tagsi.db4o.entities;

import com.sun.corba.se.impl.oa.toa.TOA;
import java.util.UUID;

/**
 *
 * @author johann
 */
public class Cliente {

    public Cliente(String Nombres, String Apellidos, String Direccion) {
        this.Id = UUID.randomUUID();
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
    }

    public UUID getId() {
        return Id;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    private UUID  Id;
    private String Nombres;
    private String Apellidos;
    private String Direccion;
    
    @Override
    public String toString(){
        return Apellidos + ", " + Nombres;
    }
    
}
