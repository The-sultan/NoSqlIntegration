/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.frontend.utils;

import edu.fing.tagsi.db4o.entities.NodoCamino;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author johann
 */
public class RecorridoCellRenderer extends JLabel implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean bln, boolean bln1) {
        NodoCamino nodo = (NodoCamino)e;
        if (nodo.getCiudad() != null){
            this.setText(nodo.getCiudad().getNombre());

            if (nodo.isVisited())
            {
                this.setFont(this.getFont().deriveFont(Font.BOLD));
            }
            else
            {
                this.setFont(this.getFont().deriveFont(Font.PLAIN));
            }
        } 
        else{
            this.setText("");
        }
        return this;
    }
    
}
