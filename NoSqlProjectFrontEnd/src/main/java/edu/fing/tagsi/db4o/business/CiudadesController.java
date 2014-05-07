/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.business;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import edu.fing.tagsi.db4o.RESTEntities.RecorridoREST;
import edu.fing.tagsi.db4o.RESTEntities.RequestRecorrido;
import edu.fing.tagsi.db4o.RESTEntities.Tramo;
import edu.fing.tagsi.db4o.entities.Ciudad;
import edu.fing.tagsi.db4o.entities.NodoCamino;
import edu.fing.tagsi.db4o.entities.Recorrido;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author johann
 */
public class CiudadesController {
    
    private final String URL = "http://localhost:8080/mejorCamino";
    
    public List<Ciudad> ListarCiudades(){     
        return DBController.getInstance().getDB().query(Ciudad.class);
    }
    
    public Ciudad ObtenerCiudad(final String nombre){
        ObjectContainer db = DBController.getInstance().getDB();
        List<Ciudad> resultado = db.query(new Predicate<Ciudad>(){
            @Override
            public boolean match(Ciudad c){
                return c.getNombre().equals(nombre);
            }
        });
        
        if (resultado != null && resultado.size() > 0)
        {
            return resultado.get(0);
        }
        else
        {
            return null;
        }
        
    }
    
    public Recorrido ObtenerRecorrido(Ciudad origen, Ciudad destino){
        RestTemplate restTemplate = new RestTemplate();
        RequestRecorrido req = new RequestRecorrido(origen.getNombre(),destino.getNombre());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RequestRecorrido> entity = new HttpEntity<>(req,headers);
        RecorridoREST recorrido = restTemplate.postForObject(URL, entity, RecorridoREST.class);
        
        if (recorrido.getCiudades() != null){
            NodoCamino[] ciudades = new NodoCamino[recorrido.getCiudades().length];
            for(int i=0;i<ciudades.length;i++)
            {
                if (i==0){
                    ciudades[i] = new NodoCamino(
                            ObtenerCiudad(recorrido.getCiudades()[i].getName()),
                            true, 0,null);
                }
                else{
                    Tramo tramo = recorrido.getRutas()[i-1];
                    ciudades[i] = new NodoCamino(
                            ObtenerCiudad(recorrido.getCiudades()[i].getName()),
                            false, tramo.getDistancia(),tramo.getRutas());
                }
            }
            Recorrido resultado = new Recorrido(recorrido.getDistanciaTotal(), ciudades);
            return resultado;
        }
        else
        {
            return null;
        }
        
    }
}
