/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.business;

import edu.fing.tagsi.db4o.entities.Envio;
import java.util.List;

/**
 *
 * @author johann
 */
public class EnviosController {
    public void RegistrarEnvio(Envio e){
        DBController.getInstance().store(e);
        new TrackingController().Registrar(e);
    }
    
    public List<Envio> BuscarEnvios() {
        return DBController.getInstance().getDB().query(Envio.class);
    }
}
