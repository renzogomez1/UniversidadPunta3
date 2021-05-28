/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadpunta3.vistas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import universidadpunta3.modelos.*;


/**
 *
 * @author Asus
 */
public class ListadoAlumnos extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private AlumnoData ad;
    private ArrayList<Alumno> listaAlumnos;
    private Conexion conexion;
    /**
     * Creates new form ListadoAlumnosXMaterias
     */
    public ListadoAlumnos()  {
        initComponents();
        try {
            conexion = new Conexion("jdbc:mysql://localhost/universidadgrupo3", "root", "");
            modelo = new DefaultTableModel();
            ad = new AlumnoData(conexion);
            
            armarCabeceraTabla();
            cargaDatos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListadoAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    public void armarCabeceraTabla(){
        ArrayList<Object> cabecera = new ArrayList<Object>();
        cabecera.add("Id");
        cabecera.add("Legajo");
        cabecera.add("Apellido");
        cabecera.add("Nombre");
        cabecera.add("Fecha nacimiento");
        cabecera.add("Estado");
        
        for (Object ol : cabecera){
            modelo.addColumn(ol);
        }
        tAlumnos.setModel(modelo);
    } 
    
    public void borrarFilasTabla(){
        int g = modelo.getRowCount()-1;
        for(int i=g; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    public void cargaDatos(){
        borrarFilasTabla();
        String opcion = (String)cbEstado.getSelectedItem();
        
        switch (opcion) {
            case "activos" : listaAlumnos = (ArrayList)ad.obtenerAlumnosPorEstado(1); break;
            case "inactivos" : listaAlumnos = (ArrayList)ad.obtenerAlumnosPorEstado(0); break;
            case "todos" : listaAlumnos = (ArrayList)ad.obtenerAlumnos(); break;
        }
 
        for (Alumno al : listaAlumnos) {       
            modelo.addRow(new Object[]{al.getId_alumno(), al.getLegajo(), al.getApellido(), al.getNombre(), al.getFechaNac(), al.isEstado()});
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

        jdpEscritorio = new javax.swing.JDesktopPane();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlumnos = new javax.swing.JTable();
        cbEstado = new javax.swing.JComboBox<>();

        setClosable(true);

        jdpEscritorio.setBackground(new java.awt.Color(255, 204, 153));

        label1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 29)); // NOI18N
        label1.setForeground(new java.awt.Color(51, 51, 51));
        label1.setText("Listado de Alumnos");

        label2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(51, 51, 51));
        label2.setText("ESTADO:");

        tAlumnos.setBackground(new java.awt.Color(255, 255, 204));
        tAlumnos.setForeground(new java.awt.Color(51, 51, 51));
        tAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Title 2", "Title 3", "Title 4"
            }
        ));
        tAlumnos.setToolTipText("");
        jScrollPane1.setViewportView(tAlumnos);

        cbEstado.setBackground(new java.awt.Color(255, 255, 204));
        cbEstado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cbEstado.setForeground(new java.awt.Color(51, 51, 51));
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "todos", "activos", "inactivos" }));
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        jdpEscritorio.setLayer(label1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorio.setLayer(label2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorio.setLayer(cbEstado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpEscritorioLayout = new javax.swing.GroupLayout(jdpEscritorio);
        jdpEscritorio.setLayout(jdpEscritorioLayout);
        jdpEscritorioLayout.setHorizontalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdpEscritorioLayout.createSequentialGroup()
                .addGap(0, 106, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(jdpEscritorioLayout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addGroup(jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jdpEscritorioLayout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdpEscritorioLayout.setVerticalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpEscritorioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        // TODO add your handling code here:
        cargaDatos();
    }//GEN-LAST:event_cbEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDesktopPane jdpEscritorio;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JTable tAlumnos;
    // End of variables declaration//GEN-END:variables
}