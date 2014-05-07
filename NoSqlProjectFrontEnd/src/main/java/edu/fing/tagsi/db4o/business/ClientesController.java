/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.business;

import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import edu.fing.tagsi.db4o.entities.Cliente;
import java.util.List;

/**
 *
 * @author johann
 */
public class ClientesController {
    
    public void SavarCliente(Cliente c){
        DBController.getInstance().store(c);
    }
    
    public List<Cliente> ListarClientes(){     
        return DBController.getInstance().getDB().query(Cliente.class);
    }
    
    public List<Cliente> BuscarClientes(final String filtro){
    
        ObjectContainer db = DBController.getInstance().getDB();
        return db.query(new Predicate<Cliente>(){
           @Override
           public boolean match(Cliente cliente){
               return cliente.getNombres().toUpperCase().contains(filtro.toUpperCase()) || 
                       cliente.getApellidos().contains(filtro.toUpperCase());
           }
        });
    }
     

}
