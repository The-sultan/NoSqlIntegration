/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author johann
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tracking {
    private UUID idpaquete;
    private UUID idcliente;
    private UUID idlugar;
    private Date fecha;
    private Boolean esdestino;

    public Tracking(UUID idpaquete, UUID idcliente, UUID idlugar, Date fecha, Boolean esdestino) {
        this.idpaquete = idpaquete;
        this.idcliente = idcliente;
        this.idlugar = idlugar;
        this.fecha = fecha;
        this.esdestino = esdestino;
    }

    public UUID getIdpaquete() {
        return idpaquete;
    }

    public UUID getIdcliente() {
        return idcliente;
    }

    public UUID getIdlugar() {
        return idlugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public Boolean isEsdestino() {
        return esdestino;
    }

    
    
}
