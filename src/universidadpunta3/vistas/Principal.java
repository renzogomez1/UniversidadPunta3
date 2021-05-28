/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadpunta3.vistas;

import universidadpunta3.modelos.Conexion;
import universidadpunta3.modelos.Materia;
import universidadpunta3.modelos.MateriaData;

/**
 *
 * @author Emiliano
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBarra = new javax.swing.JMenuBar();
        jMArchivo = new javax.swing.JMenu();
        jMSalir = new javax.swing.JMenuItem();
        jMaterias = new javax.swing.JMenu();
        jMFormularioDeMaterias = new javax.swing.JMenuItem();
        jMAlumnos = new javax.swing.JMenu();
        jMFormularioDeAlumnos = new javax.swing.JMenuItem();
        jMInscripciones = new javax.swing.JMenu();
        jMManejoDeInscripciones = new javax.swing.JMenuItem();
        jMCargaDeNotas = new javax.swing.JMenu();
        jMManejoDeNotas = new javax.swing.JMenuItem();
        jMConsultas = new javax.swing.JMenu();
        jMListadoDeAlumnosPorMateria = new javax.swing.JMenuItem();
        jMListadoAlumnos = new javax.swing.JMenuItem();
        jMListadoMaterias = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1396, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
        );

        jMArchivo.setText("Archivo");

        jMSalir.setText("Salir");
        jMSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSalirActionPerformed(evt);
            }
        });
        jMArchivo.add(jMSalir);

        jMenuBarra.add(jMArchivo);

        jMaterias.setText("Materias");

        jMFormularioDeMaterias.setText("Formulario De Materias");
        jMFormularioDeMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFormularioDeMateriasActionPerformed(evt);
            }
        });
        jMaterias.add(jMFormularioDeMaterias);

        jMenuBarra.add(jMaterias);

        jMAlumnos.setText("Alumnos");

        jMFormularioDeAlumnos.setText("Formulario De Alumnos");
        jMFormularioDeAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFormularioDeAlumnosActionPerformed(evt);
            }
        });
        jMAlumnos.add(jMFormularioDeAlumnos);

        jMenuBarra.add(jMAlumnos);

        jMInscripciones.setText("Inscripciones");

        jMManejoDeInscripciones.setText("Manejo De Inscripciones");
        jMManejoDeInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMManejoDeInscripcionesActionPerformed(evt);
            }
        });
        jMInscripciones.add(jMManejoDeInscripciones);

        jMenuBarra.add(jMInscripciones);

        jMCargaDeNotas.setText("Carga De Notas");

        jMManejoDeNotas.setText("Manejo De Notas");
        jMManejoDeNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMManejoDeNotasActionPerformed(evt);
            }
        });
        jMCargaDeNotas.add(jMManejoDeNotas);

        jMenuBarra.add(jMCargaDeNotas);

        jMConsultas.setText("Consultas");

        jMListadoDeAlumnosPorMateria.setText("Listado De Alumnos Por Materia");
        jMListadoDeAlumnosPorMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListadoDeAlumnosPorMateriaActionPerformed(evt);
            }
        });
        jMConsultas.add(jMListadoDeAlumnosPorMateria);

        jMListadoAlumnos.setText("Listado de Alumnos");
        jMListadoAlumnos.setActionCommand("Listado De Alumnos");
        jMListadoAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListadoAlumnosActionPerformed(evt);
            }
        });
        jMConsultas.add(jMListadoAlumnos);

        jMListadoMaterias.setText("Listado De Materias");
        jMListadoMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListadoMateriasActionPerformed(evt);
            }
        });
        jMConsultas.add(jMListadoMaterias);

        jMenuBarra.add(jMConsultas);

        setJMenuBar(jMenuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMSalirActionPerformed

    private void jMFormularioDeMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFormularioDeMateriasActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaMaterias am = new VistaMaterias();
        am.setVisible(true);
        escritorio.add(am);
        escritorio.moveToFront(am);
    }//GEN-LAST:event_jMFormularioDeMateriasActionPerformed

    private void jMListadoDeAlumnosPorMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListadoDeAlumnosPorMateriaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        ListadoAlumnosXMaterias am = new ListadoAlumnosXMaterias();
        am.setVisible(true);
        escritorio.add(am);
        escritorio.moveToFront(am);
    }//GEN-LAST:event_jMListadoDeAlumnosPorMateriaActionPerformed

    private void jMFormularioDeAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFormularioDeAlumnosActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaAlumnos alumnos = new VistaAlumnos();
        alumnos.setVisible(true);
        escritorio.add(alumnos);
        escritorio.moveToFront(alumnos);
                                    
    }//GEN-LAST:event_jMFormularioDeAlumnosActionPerformed

    private void jMListadoAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListadoAlumnosActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        ListadoAlumnos la = new ListadoAlumnos();
        la.setVisible(true);
        escritorio.add(la);
        escritorio.moveToFront(la);
    }//GEN-LAST:event_jMListadoAlumnosActionPerformed

    private void jMManejoDeInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMManejoDeInscripcionesActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaInscripcion vista = new VistaInscripcion();
        vista.setVisible(true);
        escritorio.add(vista);
        escritorio.moveToFront(vista);
    }//GEN-LAST:event_jMManejoDeInscripcionesActionPerformed

    private void jMListadoMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListadoMateriasActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        ListadoMaterias lm = new ListadoMaterias();
        lm.setVisible(true);
        escritorio.add(lm);
        escritorio.moveToFront(lm);
    }//GEN-LAST:event_jMListadoMateriasActionPerformed

    private void jMManejoDeNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMManejoDeNotasActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaNotas vn = new VistaNotas();
        vn.setVisible(true);
        escritorio.add(vn);
        escritorio.moveToFront(vn);
    }//GEN-LAST:event_jMManejoDeNotasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMAlumnos;
    private javax.swing.JMenu jMArchivo;
    private javax.swing.JMenu jMCargaDeNotas;
    private javax.swing.JMenu jMConsultas;
    private javax.swing.JMenuItem jMFormularioDeAlumnos;
    private javax.swing.JMenuItem jMFormularioDeMaterias;
    private javax.swing.JMenu jMInscripciones;
    private javax.swing.JMenuItem jMListadoAlumnos;
    private javax.swing.JMenuItem jMListadoDeAlumnosPorMateria;
    private javax.swing.JMenuItem jMListadoMaterias;
    private javax.swing.JMenuItem jMManejoDeInscripciones;
    private javax.swing.JMenuItem jMManejoDeNotas;
    private javax.swing.JMenuItem jMSalir;
    private javax.swing.JMenu jMaterias;
    private javax.swing.JMenuBar jMenuBarra;
    // End of variables declaration//GEN-END:variables
}
