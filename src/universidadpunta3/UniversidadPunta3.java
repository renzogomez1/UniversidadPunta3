/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadpunta3;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import universidadpunta3.modelos.Conexion;

/**
 *
 * @author Asus
 */
public class UniversidadPunta3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Problema con los drivers de conexion.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema con la conexion de la Bases de Datos.");
        }
    }
}
