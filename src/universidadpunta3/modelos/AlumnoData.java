/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadpunta3.modelos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadpunta3.modelos.*;


/**
 *
 * @author Admin
 */
public class AlumnoData {
     private Connection con;
    
    public AlumnoData(Conexion conexion ){
        
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al conectarse."+ex.getMessage());
        }
        
    }
    
    public void guardarAlumno(Alumno alumno){
        
        try{ 
          String sql= "INSERT INTO alumno(legajo, nombre, apellido, fechaNac, estado) VALUES (?,?,?,?,?)"; 
          PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1, alumno.getLegajo());
          ps.setString(2,alumno.getNombre());
          ps.setString(3,alumno.getApellido());
          ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
          ps.setBoolean(5, alumno.isEstado());
          ps.executeUpdate();  //ACA SE GENERA EL AUTONUMERICO DEL ID
          ResultSet rs = ps.getGeneratedKeys();
          if (rs.next()){
          
            alumno.setId_alumno(rs.getInt("id_Alumno"));
          }
          
        ps.close();
        //Notificamos que se guardo
        JOptionPane.showMessageDialog(null,"El alumno: "+alumno.getApellido()+" se guardo correctamente");
        } catch (SQLException ex) {
            //Notificamos que hubo un error, y el origen del error
            JOptionPane.showMessageDialog(null, "Error al insertar el alumno. "+alumno.getApellido()+" "+ex.getMessage());
        }      
    
    }
    
    public void actualizarAlumno(Alumno alumno){
        
        try{ 
                      
          String sql= "UPDATE alumno SET nombre= ?, apellido=?, fechaNac=?, estado=? WHERE id_Alumno=?"; 
          PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setString(1,alumno.getNombre());
          ps.setString(2,alumno.getApellido());
          ps.setDate(3, Date.valueOf(alumno.getFechaNac()));
          ps.setBoolean(4, alumno.isEstado());
          ps.setInt(5, alumno.getId_alumno());
          ps.executeUpdate();  
                    
          ps.close();
            //Notificamos que se actualizo  
            JOptionPane.showMessageDialog(null,"El alumno se actualizo correctamente");
        } catch (SQLException ex) {
            //Notificamos que hubo un error al actualizar el alumno, y el origen del error
            JOptionPane.showMessageDialog(null, "error al actuaizar el alumno: "+alumno.getApellido()+" "+ex.getMessage());
        }
     
    
    }
    
    public void borrarAlumnoFisico(int id){
        
        try{ 
          String sql= "DELETE FROM alumno WHERE id_Alumno=?"; 
          PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1,id);
          
          ps.executeUpdate();  
                    
          ps.close();
         //Notificamos que se borro
        JOptionPane.showMessageDialog(null,"El alumno se borro corectamente");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error al borrar el alumno "+ex.getMessage());
        
        }
     
    
    }
    public void borrarAlumnoLogico(int id){
        
        try{ 
                      
          String sql= "UPDATE alumno SET estado=0 WHERE id_Alumno=?"; 
          PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1,id);
          ps.executeUpdate();  
                    
          ps.close();
        //Notificamos que se borro
        JOptionPane.showMessageDialog(null,"El alumno: "+buscarAlumno(id).getApellido()+" se borro corectamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al borrar el alumno: "+buscarAlumno(id).getApellido()+" "+ex.getMessage());
        }
     
    
    }
        
    public Alumno buscarAlumno(int id){
    Alumno alumno=null;
    
    
        try{ 
          String sql= "SELECT * FROM alumno WHERE id_Alumno=?"; 
          PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1,id);
          
          ResultSet rs=ps.executeQuery();  
          
          if (rs.next()){
              alumno=new Alumno();
              alumno.setId_alumno(rs.getInt("id_Alumno"));
              alumno.setLegajo(rs.getInt("legajo"));
              alumno.setNombre(rs.getString("nombre"));
              alumno.setApellido(rs.getString("apellido"));
              alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
              alumno.setEstado(rs.getBoolean("estado"));
              
          }
                    
          ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al buscar el alumno."+ex.getMessage());
        }
    
    return alumno;
        
    }
    
    public List<Alumno> obtenerAlumnos(){
    List<Alumno> alumnos= new ArrayList<>();
    
    
        try{ 
          String sql= "SELECT * FROM alumno"; 
          PreparedStatement ps= con.prepareStatement(sql);
         
          ResultSet rs=ps.executeQuery();  
          Alumno alumno;
          while (rs.next()){
              alumno=new Alumno();
              alumno.setId_alumno(rs.getInt("id_Alumno"));
              alumno.setLegajo(rs.getInt("legajo"));
              alumno.setNombre(rs.getString("nombre"));
              alumno.setApellido(rs.getString("apellido"));
              alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
              alumno.setEstado(rs.getBoolean("estado"));
              alumnos.add(alumno);
          }
                    
          ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al listar los alumno. "+ex.getMessage());
        }
    
    return alumnos;
        
    }
    
    
    
}
