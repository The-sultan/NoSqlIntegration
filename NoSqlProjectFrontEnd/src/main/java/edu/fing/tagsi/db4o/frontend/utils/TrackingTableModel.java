/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.frontend.utils;

import edu.fing.tagsi.db4o.business.CiudadesController;
import edu.fing.tagsi.db4o.business.ConfigController;
import edu.fing.tagsi.db4o.business.TrackingController;
import edu.fing.tagsi.db4o.entities.Envio;
import edu.fing.tagsi.db4o.entities.Recorrido;
import edu.fing.tagsi.db4o.entities.Tracking;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author johann
 */
public class TrackingTableModel  implements TableModel{

    Envio envio;
    Recorrido recorrido;
    List<Tracking> tracking;
    
    public TrackingTableModel(){
    
    }
    
    public TrackingTableModel(Envio envio){
        this.envio = envio;
        CiudadesController ciudadesControler = new CiudadesController();
        TrackingController trackingController = new TrackingController();
        ConfigController config = ConfigController.getInstance();
        recorrido = ciudadesControler.ObtenerRecorrido(config.obtenerCiudad(), envio.getDestino());
        tracking = trackingController.getTracking(envio.getId());
    }

    public Envio getEnvio() {
        return envio;
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }

    public List<Tracking> getTracking() {
        return tracking;
    }
    
    @Override
    public int getRowCount() {
        if (recorrido != null)
            return recorrido.getNodos().length;
        else
            return 0;
    }

    @Override
    public int getColumnCount() {
        //Ciudad, fecha
        return 2;
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0: return "Ciudad";
            case 1: return "Fecha";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        if (i1 == 0){
            return recorrido.getNodos()[i].getCiudad().getNombre();
        }
        else
        {
            if (i<tracking.size()){
                return tracking.get(i).getFecha().toString();
            }
            else
            {
                return "--";
            }
        }
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        
    }
    
}
