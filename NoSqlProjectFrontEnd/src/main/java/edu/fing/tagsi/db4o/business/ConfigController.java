/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.business;

import edu.fing.tagsi.db4o.entities.Ciudad;

/**
 *
 * @author johann
 */
public class ConfigController {
    private static ConfigController instance;
    
    private ConfigController(){
        
    }
    
    public static ConfigController getInstance(){
        if (instance == null){
            instance = new ConfigController();
        }
        return instance;
    }
    
    public Ciudad obtenerCiudad() {
        return new CiudadesController().ObtenerCiudad("Rivera");
    }
    
    public String getURLAddTracking(){
        return "http://localhost:8080/Add";
    }
        
    public String getURLFindTracking(){
        return "http://localhost:8080/GetTracking";
    }
}
