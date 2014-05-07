/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.business;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectContainer;
import com.db4o.config.ConfigScope;
import com.db4o.config.EmbeddedConfiguration;

/**
 *
 * @author johann
 */
public class DBController {
    
    private final String DB4OFILENAME = "./db4o";
    
    EmbeddedObjectContainer _db;
    
    private DBController(){
        _db = Db4oEmbedded.openFile(getConfig(), DB4OFILENAME);
    }
    
    private static DBController instance = null;
    
    public static DBController getInstance(){
        if (instance == null){
            instance = new DBController();
            DBDataLoader.FirstLoad();
        }
        return instance;
    }
    
    public EmbeddedObjectContainer getDB(){
        return _db;
    }
    
    public void CloseDB(){
        _db.close();
    }
    
    public void store(Object o){
        ObjectContainer db = getDB();
        try {
            db.store(o);
        } finally {
            db.commit();
        }
    }
    
    private static EmbeddedConfiguration getConfig(){
	EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
	configuration.file().generateUUIDs(ConfigScope.GLOBALLY);
	configuration.file().generateCommitTimestamps(true);
	return configuration;
    }
}
