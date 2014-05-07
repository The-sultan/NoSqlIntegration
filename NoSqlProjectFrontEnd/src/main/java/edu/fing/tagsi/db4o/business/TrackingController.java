/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.business;

import edu.fing.tagsi.db4o.RESTEntities.RequestTrackingAddPackage;
import edu.fing.tagsi.db4o.entities.Envio;
import edu.fing.tagsi.db4o.entities.NodoCamino;
import edu.fing.tagsi.db4o.entities.Recorrido;
import edu.fing.tagsi.db4o.entities.Tracking;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import static org.springframework.http.HttpMethod.GET;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author johann
 */
public class TrackingController {
    
    public void Registrar(Envio envio){
        RestTemplate restTemplate = new RestTemplate();
        RequestTrackingAddPackage req = new RequestTrackingAddPackage(
                envio.getId().toString(), envio.getCliente().getId().toString(),
                envio.getDestino().getId().toString(),
                envio.getFechaEnvio(), false);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RequestTrackingAddPackage> entity = new HttpEntity<>(req,headers);
        restTemplate.postForObject(ConfigController.getInstance().getURLAddTracking(), entity, void.class);
    }
    
    public List<Tracking> getTracking(UUID id){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        
        ResponseEntity<RequestTrackingAddPackage[]> tracking = restTemplate.exchange(
                ConfigController.getInstance().getURLFindTracking() +"/"+ id.toString(),
                GET,
                entity, 
                RequestTrackingAddPackage[].class);

        if (tracking != null){
            List<Tracking> resultado = new ArrayList<>(tracking.getBody().length);
            for(RequestTrackingAddPackage r : tracking.getBody()){
                
                resultado.add(new Tracking(
                        UUID.fromString(r.getIdpaquete()), 
                        UUID.fromString(r.getIdcliente()),
                        UUID.fromString(r.getIdlugar()),
                        r.getFecha(), 
                        r.isEsdestino()));
            }
            return resultado;
        }
        else
        {
            return null;
        }

    }
    
    public void RegistrarNuevoSalto(Envio envio, Recorrido recorrido, List<Tracking> list){
        if (list.size() < recorrido.getNodos().length)
        {
            NodoCamino nodo = recorrido.getNodos()[list.size()];

            RestTemplate restTemplate = new RestTemplate();
            RequestTrackingAddPackage req = new RequestTrackingAddPackage(
                    envio.getId().toString(), envio.getCliente().getId().toString(),
                    nodo.getCiudad().getId().toString(),
                    new Date(), 
                    list.size() +1 == recorrido.getNodos().length);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<RequestTrackingAddPackage> entity = new HttpEntity<>(req,headers);
            restTemplate.postForObject(ConfigController.getInstance().getURLAddTracking(), entity, void.class);
        }
    
    }
        
}
