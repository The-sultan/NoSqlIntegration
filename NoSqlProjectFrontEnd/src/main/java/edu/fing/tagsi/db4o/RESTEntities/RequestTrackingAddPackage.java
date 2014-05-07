/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.RESTEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

/**
 *
 * @author johann
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestTrackingAddPackage {
    private String idpaquete;
    private String idcliente;
    private String idlugar;
    private Date fecha;
    private Boolean esdestino;

    public String getIdpaquete() {
        return idpaquete;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public String getIdlugar() {
        return idlugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public Boolean isEsdestino() {
        return esdestino;
    }

    public RequestTrackingAddPackage(){
        
    }
    
    public RequestTrackingAddPackage(String idpaquete, String idcliente, String idlugar, Date fecha, Boolean esdestino) {
        this.idpaquete = idpaquete;
        this.idcliente = idcliente;
        this.idlugar = idlugar;
        this.fecha = fecha;
        this.esdestino = esdestino;
    }
    
    
}
