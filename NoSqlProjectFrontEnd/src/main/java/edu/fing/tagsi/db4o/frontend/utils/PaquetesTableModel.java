/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.frontend.utils;

import edu.fing.tagsi.db4o.entities.Envio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author johann
 */
public class PaquetesTableModel implements TableModel {
    
    List<Envio> lista;
    
    public PaquetesTableModel(){
        this.lista = new ArrayList<>();
    }
    
    public PaquetesTableModel(List<Envio> lista){
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        //Cliente, fecha, destino
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1)  {
        Envio item = lista.get(i);
        
        switch(i1){
            case 0: return item.getCliente().toString();
            case 1: return item.getFechaEnvio().toString();
            case 2: return item.getDestino() != null ? item.getDestino().getNombre() : "--";
        }
        
        return null;
    }
    
    public Envio getItem(int row){
        return lista.get(row);
    }

    @Override
    public String getColumnName(int i) {
        switch(i)
        {
            case 0: return "Cliente";
            case 1: return "Fecha";
            case 2: return "Destino";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
