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
import universidadpunta3.modelos.Alumno;
import universidadpunta3.modelos.AlumnoData;
import universidadpunta3.modelos.Conexion;
import universidadpunta3.modelos.Cursada;
import universidadpunta3.modelos.CursadaData;
import universidadpunta3.modelos.Materia;
import universidadpunta3.modelos.MateriaData;

/**
 *
 * @author Asus
 */
public class ListadoAlumnosXMaterias extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private ArrayList<Cursada> listaCursada;
    private ArrayList<Materia> listaMaterias;
    private CursadaData cd;
    private MateriaData md;
    private AlumnoData ad;
    private ArrayList<Alumno> listaAlumnos;
    private Conexion conexion;
    /**
     * Creates new form ListadoAlumnosXMaterias
     */
    public ListadoAlumnosXMaterias() {
        try {
            initComponents();
            conexion = new Conexion("jdbc:mysql://localhost/universidadgrupo3", "root", "");
            modelo = new DefaultTableModel();
            cd = new CursadaData(conexion);
            listaCursada = (ArrayList)cd.obtenerCursadas();
            md = new MateriaData(conexion);
            listaMaterias = (ArrayList)md.obtenerMaterias();
            ad = new AlumnoData(conexion);
            listaAlumnos = (ArrayList)ad.obtenerAlumnos();
            cargarMaterias();
            armarCabeceraTabla();
            cargaDatos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListadoAlumnosXMaterias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarMaterias(){
        for(Materia item : listaMaterias){
            cbMenu.addItem(item);
        }
    }
    
    public void armarCabeceraTabla(){
        ArrayList<Object> cabecera = new ArrayList<Object>();
        cabecera.add("ID");
        cabecera.add("Nombre");
        cabecera.add("Nota");
        
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
        Materia mat = (Materia)cbMenu.getSelectedItem();
        for (Cursada mt : listaCursada){
            if(mt.getMateria().getId_materia() == mat.getId_materia()){
                modelo.addRow(new Object[]{mt.getAlumno().getId_alumno(),mt.getAlumno().getNombre(), mt.getNota()});
            }
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
        cbMenu = new javax.swing.JComboBox<>();

        jdpEscritorio.setBackground(new java.awt.Color(255, 204, 153));

        label1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 29)); // NOI18N
        label1.setForeground(new java.awt.Color(51, 51, 51));
        label1.setText("Listado de Alumnos por Materia");

        label2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(51, 51, 51));
        label2.setText("MATERIA:");

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

        cbMenu.setBackground(new java.awt.Color(255, 255, 204));
        cbMenu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cbMenu.setForeground(new java.awt.Color(51, 51, 51));
        cbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMenuActionPerformed(evt);
            }
        });

        jdpEscritorio.setLayer(label1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorio.setLayer(label2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorio.setLayer(cbMenu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpEscritorioLayout = new javax.swing.GroupLayout(jdpEscritorio);
        jdpEscritorio.setLayout(jdpEscritorioLayout);
        jdpEscritorioLayout.setHorizontalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpEscritorioLayout.createSequentialGroup()
                .addGroup(jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdpEscritorioLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdpEscritorioLayout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(cbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(274, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdpEscritorioLayout.createSequentialGroup()
                .addGap(0, 180, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
        jdpEscritorioLayout.setVerticalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpEscritorioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMenu))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
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

    private void cbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMenuActionPerformed
        // TODO add your handling code here:
        cargaDatos();
    }//GEN-LAST:event_cbMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> cbMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDesktopPane jdpEscritorio;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JTable tAlumnos;
    // End of variables declaration//GEN-END:variables
}
