/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadpunta3;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
 /////////////COMIENZO DE PRUEBA DE ALUMNOS/////////
 /*
            //Alumno(int id_alumno, String nombre, String apellido, LocalDate fechaNac, int legajo, boolean estado)
        //CREA 8 ALUMNOS
            Alumno a = new Alumno("Javier","Pogliese",LocalDate.of(2000,01,01),1000,false);
            Alumno a1 = new Alumno("Renzo","Gomez",LocalDate.of(2000,01,01),1001,false);
            Alumno a2 = new Alumno("Luciano","Fernandez",LocalDate.of(2000,01,01),1002,false);
            Alumno a3 = new Alumno("Emiliano","Garro",LocalDate.of(2000,01,01),1003,false);
            Alumno a4 = new Alumno("Juan","Perez",LocalDate.of(2000,01,01),1004,true);
            Alumno a5 = new Alumno("Dario","cortez",LocalDate.of(2000,01,01),1005,true);
            Alumno a6 = new Alumno("Agustin","Quiroga",LocalDate.of(2000,01,01),1006,true);
            Alumno a7 = new Alumno("Walter","Sanchez",LocalDate.of(2000,01,01),1007,true);
        //GUARDA 8 ALUMNOS
            ad.guardarAlumno(a);
            ad.guardarAlumno(a1);
            ad.guardarAlumno(a2);
            ad.guardarAlumno(a3);
            ad.guardarAlumno(a4);
            ad.guardarAlumno(a5);
            ad.guardarAlumno(a6);
            ad.guardarAlumno(a7);
      
        //GUARDA EL ALUMNO (a6) NUEVAMENTE (TIENE QUE DAR ERROR DE LEGAJO REPETIDO)
            ad.guardarAlumno(a6);
        //ACTUALIZA EL ESTADO A VERDADERO DE LOS ALUMNOS (a,a1,a2,a3)
            a.setEstado(true);
            a1.setEstado(true);
            a2.setEstado(true);
            a3.setEstado(true);
            ad.actualizarAlumno(a);
            ad.actualizarAlumno(a1);
            ad.actualizarAlumno(a2);
            ad.actualizarAlumno(a3);
        //OBTIENE LOS ALUMNOS Y LOS GUARDA EN UNA VARIABLE
            List<Alumno>alumnos=ad.obtenerAlumnos();
            
                    //GUARDAMOS LOS ID DE LOS ALUMNOS LISTADOS  PRUEBA DE FOREACH!!!!!!!!!!!!!! 
                    //List<Integer>ids=new ArrayList<>();
                    //alumnos.forEach((n) -> ids.add(n.getId_alumno()));
            
        //BORRA LOGICAMENTE LOS DOS PRIMEROS
            ad.borrarAlumnoLogico(alumnos.get(0).getId_alumno());
            ad.borrarAlumnoLogico(alumnos.get(1).getId_alumno());
        //BORRA FISICAMENTE AL 6to
            ad.borrarAlumnoFisico(alumnos.get(5).getId_alumno());
        
//////////////////////////////////FIN PRUEBA DE ALUMNOS/////////////
        
/////////////COMIENZO DE PRRUEBA DE MATERIAS///////////

        //Materia(int id_materia, String materiaMateria, int anio, boolean estado)      
        //CREA 10 MATERIAS    
            Materia m = new Materia("Laboratorio I",1,true);
            Materia m1 = new Materia("Laboratorio II",2,true);
            Materia m2 = new Materia("Programacion Web I",1,true);
            Materia m3 = new Materia("Matematica I",1,true);
            Materia m4 = new Materia("Matematica II",2,true);
            Materia m5 = new Materia("Programacion Web II",2,true);
            Materia m6 = new Materia("Laboratorio III",3,true);
            Materia m7 = new Materia("EDA",1,true);
            Materia m8 = new Materia("Ingles tec I",2,true);
            Materia m9 = new Materia("ADM base de datos",2,true);
        //GUARDA LAS MATERIAS
            md.guardarMateria(m);
            md.guardarMateria(m1);
            md.guardarMateria(m2);
            md.guardarMateria(m3);
            md.guardarMateria(m4);
            md.guardarMateria(m5);
            md.guardarMateria(m6);
            md.guardarMateria(m7);
            md.guardarMateria(m8);
            md.guardarMateria(m9);
      
        //OBTIENE LAS MATERIAS
            List<Materia>materias=md.obtenerMaterias();
       //ACTUALIZA EL NOMBRE A LAS DOS PRIMERAS
            materias.get(0).setMateriaMateria("Labortorio 1");
            materias.get(1).setMateriaMateria("Laboratorio 2");
            md.actualizarMateria(materias.get(0));
            md.actualizarMateria(materias.get(1));
        //BORRA LOGICAMENTE A LA 3RA
            md.borrarMateriaLogica(materias.get(2).getId_materia());
        //BORRAR TODAD LAS MATERIAS FISICAMENTE
            materias.forEach((b) -> md.borrarMateriaFisica(b.getId_materia()));
        //GUARDADO DE MATERIAS
            materias.forEach((ab) -> md.guardarMateria(ab));
        
//////////////////////////FIN PRUEBA DE MATERIA//////////////
        
////////////////////////COMIENZO PRUEBA CURSADA//////////////

        //OBTENEMOS ALUMNOS Y MATERIAS PARA TRABAJAR SIN LAS PRUEBAS ANTERIORES
            //List<Alumno>alumnos=ad.obtenerAlumnos();  
            //List<Materia>materias=md.obtenerMaterias();
        //Cursada(, Alumno alumno, Materia materia, float nota, boolean estado)
        //CREA 5 CURSADAS 
            Cursada c = new Cursada(alumnos.get(0),materias.get(0),0,true);  //INSCRIBIMOS AL ALUMNO 
            Cursada c1 = new Cursada(alumnos.get(0),materias.get(1),0,true);
            Cursada c2 = new Cursada(alumnos.get(2),materias.get(1),0,true);
            Cursada c3 = new Cursada(alumnos.get(2),materias.get(3),0,true);
            Cursada c4 = new Cursada(alumnos.get(2),materias.get(0),0,true);
            
        //GUARDA LAS CURSADAS CREADAS
            cd.guardarCursada(c);
            cd.guardarCursada(c1);
            cd.guardarCursada(c2);
            cd.guardarCursada(c3);
            cd.guardarCursada(c4);
        //BUSCA UN ALUMNO Y LO MOSTRAMOS
            JOptionPane.showMessageDialog(null,cd.buscarAlumno(alumnos.get(0).getId_alumno()).toString());
            
        //BUSCA UNA MATERIA Y LA MOSTRAMOS
            JOptionPane.showMessageDialog(null,cd.buscarMateria(materias.get(0).getId_materia()).toString());
            
        //OBTIENE LAS MATERIAS QUE CURSA UN ALUMNO Y MOSTRAMOS LA CANTIDAD DE MATERIAS QUE CURSA
           List<Materia>materiaPorAlumno=cd.obtenerMateriasCursadasXAlumno(alumnos.get(0).getId_alumno());
           int auxC=materiaPorAlumno.size();
           JOptionPane.showMessageDialog(null,"La cantidad de materias que cursa son: "+auxC);
           
        //OBTIENE LAS MATERIAS QUE NO CURSA UN ALUMNO,Y MOSTRAMOS LA CANTIDAD DE MATERIAS QUE NO CURSA
            List<Materia>materiasQueNoCursa=cd.obtenerMateriasNOCursadas(alumnos.get(0).getId_alumno());
            int auxC2=materiasQueNoCursa.size();
            JOptionPane.showMessageDialog(null,"La cantidad de materias que no cursa son: "+auxC2);
            
        //OBTIENE TODA LA CURSADA
            List<Cursada>cursadas=cd.obtenerCursadas();
            JOptionPane.showMessageDialog(null,cursadas.get(0).getAlumno().toString());
            
        //ACTUALIZA LA NOTA DEL 1ER ALUMNO DE LA LISTA CON LA 2DA MATERIA DE LA LISTA
            cd.actualizarNota(alumnos.get(0).getId_alumno(), materias.get(1).getId_materia(),10);
            
        //BORRA LOGICAMENTE LA CURSADA LA CURSADA DEL 1ER ALUMNO CON LA 1RA MATERIA     
            cd.borrarCursadaDeunAlumnoLogico(alumnos.get(0).getId_alumno(), materias.get(0).getId_materia());
            
        //BORRA FISICAMENTE LA CURSADA DEL 3ER ALUMNO DE LA LISTA CON LA 1RA MATERIA DE LA LISTA
            cd.borrarCursadaDeunAlumnoFisico(alumnos.get(2).getId_alumno(), materias.get(0).getId_materia());
            
////////////////FIN PRUEBA DE CURSADA/////////////            
*/      
        //cd.InscribirCursadaDeunAlumnoLogico(16, 20);    //prueba del nuevo metodo de CursadaData...
        
            
         //cd.actualizarNota(19, 20, 10);
        //cd.borrarCursadaDeunAlumnoLogico(16,20);
        //cd.borrarCursadaDeunAlumnoFisico(44,8);
               //System.out.println(cd.obtenerCursadasXAlumno(19));
               //Alumno a = ad.buscarAlumno(44);
               //Materia m = cd.buscarMateria(20);
               //Cursada c = new Cursada(a,m,10,true);
               //cd.guardarCursada(c);
               //a.setNombre("asd");
               //ad.actualizarAlumno(a);
               //md.borrarMateriaLogica(22);
               //ad.borrarAlumnoLogico(39);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Problema con los drivers de conexion.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema con la conexion de la Bases de Datos.");
        }
    }

}
