/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadpunta3.vistas;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
 * @author Emiliano
 */
public class VistaNotas extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private CursadaData cursadaData;
    private AlumnoData alumnoData;
    private ArrayList<Alumno> listaAlumnos;
    private Conexion conexion;
    private int mate,registro;
    private float auxBotonGuardar;
   
        /**
     * Creates new form VistaNotas
     */
    public VistaNotas() {
         try {
            initComponents();
            conexion = new Conexion("jdbc:mysql://localhost/universidadgrupo3", "root", "");
            modelo = new DefaultTableModel(){public boolean isCellEditable(int row,int col){
            return(col!=0&&col!=1&&col!=2);
            }};
            cursadaData = new CursadaData(conexion);
            alumnoData = new AlumnoData(conexion);
            listaAlumnos = (ArrayList)alumnoData.obtenerAlumnos();
            jBGuardar.setEnabled(false);
            
            cargarAlumnos();
           armarCabeceraTabla();
           cargaDatos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListadoAlumnosXMaterias.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jCAlumno = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCursada = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTMateriaS = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTNota = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("CARGA DE NOTAS");

        jCAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCAlumnoActionPerformed(evt);
            }
        });

        jLabel2.setText("Alumnos");

        jTCursada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTCursada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCursadaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTCursada);

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });
        jBCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBCancelarKeyReleased(evt);
            }
        });

        jLabel3.setText("Materia seleccionada");

        jTMateriaS.setEditable(false);

        jLabel4.setText("Nota");

        jTNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNotaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNotaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(jCAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTMateriaS, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTNota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jBCancelar)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTMateriaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jBCancelar))
                .addGap(120, 120, 120))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCAlumnoActionPerformed
        // TODO add your handling code here:
        cargaDatos();
    }//GEN-LAST:event_jCAlumnoActionPerformed

    private void jTCursadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCursadaMouseClicked
        // TODO add your handling code here:
        registro = jTCursada.getSelectedRow();
        jTMateriaS.setText(jTCursada.getValueAt(registro, 0).toString()+", "+jTCursada.getValueAt(registro, 1).toString());
        mate = (int) jTCursada.getValueAt(registro, 0);
        
    }//GEN-LAST:event_jTCursadaMouseClicked

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
     Alumno a = (Alumno) jCAlumno.getSelectedItem();
     float nota = Float.parseFloat(jTNota.getText());
     cursadaData.actualizarNota(a.getId_alumno(), mate, nota);
     cargaDatos();
     
     
    
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jTNotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNotaKeyTyped
        // TODO add your handling code here:
       /* char validar;
        validar = evt.getKeyChar();
        String cod=jTNota.getText();
        int punto = cod.indexOf(".")+1;
        if(punto == 0){
        if(!Character.isDigit(validar)&&validar!=KeyEvent.VK_BACK_SPACE&&validar!=KeyEvent.VK_PERIOD){
        evt.consume();
        getToolkit().beep();
        }
        }else{
        if(!Character.isDigit(validar)&&validar!=KeyEvent.VK_BACK_SPACE){
        evt.consume();
        getToolkit().beep();
        }
        }
    */
       if(!Character.isDigit(evt.getKeyChar())&&evt.getKeyChar()!='.'){
       evt.consume();
       }
       if(evt.getKeyChar()=='.'&&jTNota.getText().contains(".")){
       evt.consume();
       }
       
       
    }//GEN-LAST:event_jTNotaKeyTyped

    private void jTNotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNotaKeyReleased
        // TODO add your handling code here:ç
        habilitarBotonGuardar();
    }//GEN-LAST:event_jTNotaKeyReleased

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        cargaDatos();
        jTMateriaS.setText("");
        jTNota.setText("");
        jBGuardar.setEnabled(false);
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBCancelarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBCancelarKeyReleased
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jBCancelarKeyReleased
      
    public void cargarAlumnos(){
    for(Alumno a:listaAlumnos){
    jCAlumno.addItem(a);
    }
    
    }

    public void borrarFilasTabla(){
        int g = modelo.getRowCount()-1;
        for(int i=g; i>=0; i--){
            modelo.removeRow(i);
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
        
        jTCursada.setModel(modelo);
    }
   
    public void cargaDatos(){
    borrarFilasTabla();
    Alumno alum=(Alumno)jCAlumno.getSelectedItem();
    
    ArrayList<Cursada>listaCursadas=(ArrayList)cursadaData.obtenerCursadas();
        for(Cursada mt:listaCursadas){
            if(mt.getAlumno().getId_alumno() == alum.getId_alumno()){
                modelo.addRow(new Object[]{mt.getMateria().getId_materia(),mt.getMateria().getMateriaMateria(), mt.getNota()});}
    
    }}
    public void habilitarBotonGuardar(){
        if(!jTNota.getText().isEmpty()){
        auxBotonGuardar= Float.parseFloat(jTNota.getText());
        }if(!jTNota.getText().isEmpty()&&!jTMateriaS.getText().isEmpty()&&auxBotonGuardar>=0&&auxBotonGuardar<=10){
    jBGuardar.setEnabled(true);
    }
    else{jBGuardar.setEnabled(false);}
    }
    
    
    /*public void cargaDatos(){
        borrarFilasTabla();
        Alumno alum = (Alumno)jCAlumno.getSelectedItem();
        for (Cursada mt : listaCursada){
            if(mt.getAlumno().getId_alumno() == alum.getId_alumno()){
                modelo.addRow(new Object[]{mt.getMateria().getId_materia(),mt.getMateria().getMateriaMateria(), mt.getNota()});
            }
        }
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JComboBox<Alumno> jCAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCursada;
    private javax.swing.JTextField jTMateriaS;
    private javax.swing.JTextField jTNota;
    // End of variables declaration//GEN-END:variables
}
