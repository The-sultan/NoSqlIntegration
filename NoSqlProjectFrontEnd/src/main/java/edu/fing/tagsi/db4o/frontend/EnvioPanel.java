/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fing.tagsi.db4o.frontend;

import edu.fing.tagsi.db4o.business.CiudadesController;
import edu.fing.tagsi.db4o.business.ClientesController;
import edu.fing.tagsi.db4o.business.EnviosController;
import edu.fing.tagsi.db4o.entities.Ciudad;
import edu.fing.tagsi.db4o.entities.Cliente;
import edu.fing.tagsi.db4o.entities.Envio;
import edu.fing.tagsi.db4o.entities.NodoCamino;
import edu.fing.tagsi.db4o.entities.Recorrido;
import edu.fing.tagsi.db4o.frontend.utils.RecorridoCellRenderer;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;

/**
 *
 * @author johann
 */
public class EnvioPanel extends javax.swing.JPanel implements PropertyChangeListener {

    /**
     * Creates new form EnvioPanel
     */
    public EnvioPanel() {
        initComponents();
        buscarClientePanel1.addPropertyChangeListener(this);
        CargarCiudades();
        initPCS();
    }

    PropertyChangeSupport pcs;

    public void initPCS() {
        if (pcs == null) {
            pcs = new PropertyChangeSupport(this);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgBuscarCliente = new javax.swing.JDialog();
        buscarClientePanel1 = new edu.fing.tagsi.db4o.frontend.BuscarClientePanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbCiudades = new javax.swing.JComboBox();
        btnEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRecorrido = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        lblDistanciaEnKm = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        dlgBuscarCliente.setMinimumSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout dlgBuscarClienteLayout = new javax.swing.GroupLayout(dlgBuscarCliente.getContentPane());
        dlgBuscarCliente.getContentPane().setLayout(dlgBuscarClienteLayout);
        dlgBuscarClienteLayout.setHorizontalGroup(
            dlgBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buscarClientePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgBuscarClienteLayout.setVerticalGroup(
            dlgBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buscarClientePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setText("Cliente");

        btnBuscarCliente.setText("Buscar...");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        txtCliente.setEditable(false);

        jLabel2.setText("Destino");

        cmbCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCiudadesActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        lstRecorrido.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBox.background"));
        lstRecorrido.setModel(new DefaultListModel());
        lstRecorrido.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstRecorrido);

        jLabel3.setText("Distancia");

        jLabel4.setText("Recorrido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCliente))
                    .addComponent(cmbCiudades, 0, 286, Short.MAX_VALUE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDistanciaEnKm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscarCliente)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblDistanciaEnKm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnviar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        dlgBuscarCliente.setLocationRelativeTo(this);
        dlgBuscarCliente.setModal(true);
        dlgBuscarCliente.setVisible(true);
        //dlgBuscarCliente.set
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        Envio envio = new Envio(_cliente, (Ciudad)cmbCiudades.getSelectedItem());
        new EnviosController().RegistrarEnvio(envio);
        pcs.firePropertyChange( "envioRegistrado", "", envio);
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void cmbCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCiudadesActionPerformed
        try{
            CiudadesController ciudadesController = new CiudadesController();
            Recorrido recorrido = ciudadesController.ObtenerRecorrido(
                    ciudadesController.ObtenerCiudad("Rivera"),
                    (Ciudad)(cmbCiudades.getSelectedItem()));
            DefaultListModel model = (DefaultListModel)lstRecorrido.getModel();
            model.removeAllElements();
            if (recorrido != null)
            {
                for(NodoCamino c : recorrido.getNodos())
                {
                    model.addElement(c);
                }
                lblDistanciaEnKm.setText(Float.toString(recorrido.getDistancia()));
            }
            else
            {
                lblDistanciaEnKm.setText("");
            }
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }//GEN-LAST:event_cmbCiudadesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnEnviar;
    private edu.fing.tagsi.db4o.frontend.BuscarClientePanel buscarClientePanel1;
    private javax.swing.JComboBox cmbCiudades;
    private javax.swing.JDialog dlgBuscarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDistanciaEnKm;
    private javax.swing.JList lstRecorrido;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables

    private Cliente _cliente;
    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if ("clienteSeleccionado".equals(pce.getPropertyName())){
           dlgBuscarCliente.setVisible(false);
           _cliente = (Cliente)(pce.getNewValue());
           txtCliente.setText(_cliente.toString());
        }
    }

    private void CargarCiudades() {
        List<Ciudad> ciudades = new CiudadesController().ListarCiudades();
        for(Ciudad c : ciudades){
            cmbCiudades.addItem(c);
        }
    }

    void clear() {
        _cliente = null;
        txtCliente.setText("");
        lstRecorrido.setSelectedIndex(0);
    }

    void setCliente(Cliente cliente) {
        _cliente = cliente;
        txtCliente.setText(cliente.toString());
    }
    
     @Override
    public void addPropertyChangeListener(PropertyChangeListener pl) {
        initPCS();
        pcs.addPropertyChangeListener(pl); //To change body of generated methods, choose Tools | Templates.
    }
}
