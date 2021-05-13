/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadpunta3.modelos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void guardarAlumno(Alumno alumno){
        
        try{ 
          String sql= "INSERT INTO alumno(nombre, fecNac, activo) VALUES (?,?,?)"; 
          PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setString(1,alumno.getNombre());
          ps.setDate(2, Date.valueOf(alumno.getFechaNac()));
          ps.setBoolean(3, alumno.isEstado());
          ps.executeUpdate();  //ACA SE GENERA EL AUTONUMERICO DEL ID
          ResultSet rs = ps.getGeneratedKeys();
          if (rs.next()){
          
            alumno.setId_alumno(rs.getInt(1));
          }
          
        ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }      
    
    }
    
    public void actualizarAlumno(Alumno alumno){
        
        try{ 
          String sql= "UPDATE alumno SET nombre= ?, fecNac=?, activo=? WHERE id=?"; 
          PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setString(1,alumno.getNombre());
          ps.setDate(2, Date.valueOf(alumno.getFechaNac()));
          ps.setBoolean(3, alumno.isEstado());
          ps.setInt(4, alumno.getId_alumno());
          ps.executeUpdate();  
                    
          ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
    }
    
    public void borrarAlumno(int id){
        
        try{ 
          String sql= "DELETE FROM alumno WHERE id=?"; 
          PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1,id);
          
          ps.executeUpdate();  
                    
          ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
    }
    
    public Alumno buscarAlumno(int id){
    Alumno alumno=null;
    
    
        try{ 
          String sql= "SELECT * FROM alumno WHERE id=?"; 
          PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1,id);
          
          ResultSet rs=ps.executeQuery();  
          
          if (rs.next()){
              alumno=new Alumno();
              alumno.setId_alumno(rs.getInt("id"));
              alumno.setNombre(rs.getString("nombre"));
              alumno.setFechaNac(rs.getDate("fecNac").toLocalDate());
              alumno.setEstado(rs.getBoolean("activo"));
              
          }
                    
          ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return alumno;
        
    }
    
    public List<Alumno> obtenerAlumno(){
    List<Alumno> alumnos= new ArrayList<>();
    
    
        try{ 
          String sql= "SELECT * FROM alumno"; 
          PreparedStatement ps= con.prepareStatement(sql);
         
          ResultSet rs=ps.executeQuery();  
          Alumno alumno;
          while (rs.next()){
              alumno=new Alumno();
              alumno.setId_alumno(rs.getInt("id"));
              alumno.setNombre(rs.getString("nombre"));
              alumno.setFechaNac(rs.getDate("fecNac").toLocalDate());
              alumno.setEstado(rs.getBoolean("activo"));
              alumnos.add(alumno);
          }
                    
          ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return alumnos;
        
    }
    
    
    
}
