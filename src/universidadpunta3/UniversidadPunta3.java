/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadpunta3;

import java.sql.*;
import javax.swing.JOptionPane;
import universidadpunta3.modelos.*;


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

            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            CursadaData cd = new CursadaData(conexion);
            AlumnoData ad = new AlumnoData(conexion);
            MateriaData md = new MateriaData(conexion);
            
//            Alumno a= new Alumno("Juan","Perez",LocalDate.of(1999, 7, 20),5000,true);
//            ad.guardarAlumno(a);
//            Materia m = new Materia("Fisica II",2,true);
//            md.guardarMateria(m);
//            Cursada cursada = new Cursada(a,m,7,true);
//            cd.guardarCursada(cursada);
            
            System.out.println(cd.obtenerMateriasCursadasXAlumno(6));
//            AlumnoData ad = new AlumnoData(conexion);
//            Alumno alumno1= new Alumno(2,"Renzo","Gomez",LocalDate.of(1999, 7, 20),1000,false);
//            ad.obtenerAlumnos();
//            System.out.println(alumno1.toString());
//                MateriaData md = new MateriaData(conexion);
//                
//                Materia m = new Materia(4,"Fisica I",1,true);
//                md.borrarMateriaLogica(2);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Problema con los drivers de conexion.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema con la conexion de la Bases de Datos.");
        }
    }

}
