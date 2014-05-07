/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.business;

import com.db4o.ObjectContainer;
import edu.fing.tagsi.db4o.entities.Ciudad;
import java.util.List;

/**
 *
 * @author johann
 */
public class DBDataLoader {
    public static void FirstLoad(){
        ObjectContainer db = DBController.getInstance().getDB();
        List<Ciudad> ciudades = db.query(Ciudad.class);
        
        if (ciudades == null || ciudades.size() == 0)
        {
            
            try{
                db.store(new Ciudad("Montevideo"));
                db.store(new Ciudad("Rivera"));
                db.store(new Ciudad("Tacuarembo"));
                db.store(new Ciudad("Canelones"));
                db.store(new Ciudad("San Jose"));
                db.store(new Ciudad("Rivera"));
            }
            finally{
                db.commit();
            }
        }
    }
}

