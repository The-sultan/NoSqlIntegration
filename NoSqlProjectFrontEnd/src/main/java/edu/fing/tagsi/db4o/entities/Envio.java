/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.entities;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author johann
 */
public class Envio {
    private Cliente cliente;
    private Date fechaEnvio;
    private UUID id;
    private String codigoEnvio;

    public Envio(Cliente cliente, Ciudad destino) {
        this.cliente = cliente;
        this.destino = destino;
        this.fechaEnvio = new Date();
        this.id = UUID.randomUUID();
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }
    
    private Ciudad destino;

    public Cliente getCliente() {
        return cliente;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public UUID getId() {
        return id;
    }
    
    public String toString(){
        if (fechaEnvio != null && destino != null  && cliente != null){
            return fechaEnvio.toString() + " a " + destino.getNombre() + " - " + cliente.toString();
        }
        else
        {
            return "envio";
        }
    }
}
