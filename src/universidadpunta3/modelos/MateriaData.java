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

/**
 *
 * @author Usuario
 */
public class MateriaData {
    private Connection connection = null;

    public MateriaData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al conectarse. "+ex.getMessage());    
        }
    }
    
    
    public void guardarMateria(Materia materia){
        try {
            
            String sql = "INSERT INTO materia (nomMateria, anioMateria, estado) VALUES ( ?,?,? )";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getMateriaMateria());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {   
                materia.setId_materia(rs.getInt("id_Materia"));
            } else {
                JOptionPane.showMessageDialog(null,"No se pudo obtener el id luego de insertar una materia");
            }
            ps.close();
            //Notificamos que se guardo correctamente
            JOptionPane.showMessageDialog(null,"Materia: "+materia.getMateriaMateria()+" Guardada Correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al insertar una materia: " + ex.getMessage());
        }
    }
    
    public List<Materia> obtenerMaterias(){
        List<Materia> materias = new ArrayList<Materia>();   

        try {
            String sql = "SELECT * FROM materia;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while(rs.next()){
                materia = new Materia();
                materia.setId_materia(rs.getInt("id_Materia"));
                materia.setMateriaMateria(rs.getString("nomMateria"));
                materia.setAnio(rs.getInt("anioMateria"));
                materia.setEstado(rs.getBoolean("estado"));
                materias.add(materia);
            } 
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener las materias: " + ex.getMessage());
        }

        return materias;
    }
    
    public Materia buscarMateria(int id){
    
        Materia materia=null;
    try {
            
            String sql = "SELECT * FROM materia WHERE id_Materia=?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
           
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                materia = new Materia();
                materia.setId_materia(rs.getInt("id_Materia"));
                materia.setMateriaMateria(rs.getString("nomMateria"));
                materia.setAnio(rs.getInt("anioMateria"));
                materia.setEstado(rs.getBoolean("estado"));
            }      
            ps.close();
   
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al insertar una materia: " + ex.getMessage());
        }
        
        return materia;
    }
    public void borrarMateriaFisica(int id){
    
        
    try {
            
            String sql = "DELETE FROM materia WHERE id_Materia=?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
         //Notificamos que se Borro
         JOptionPane.showMessageDialog(null,"La materia se borro correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al borrar la materia: " + ex.getMessage());
        }
    }
    public void actualizarMateria(Materia materia){
    try {
            
            String sql = "UPDATE materia SET nomMateria = ?, anioMateria =?, estado =? WHERE id_Materia= ?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getMateriaMateria());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getId_materia());
            ps.executeUpdate();

            ps.close();
        //Notificamos que se actualizo
        JOptionPane.showMessageDialog(null,"La materia se actualizo correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al actualizar la materia: "+materia.getMateriaMateria() + ex.getMessage());
        }
  
    }
    public void borrarMateriaLogica(int id){
    try {
            
            String sql = "UPDATE materia SET estado =0 WHERE id_Materia= ?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
        //Notificamos que se borro
            JOptionPane.showMessageDialog(null,"La materia: "+buscarMateria(id).getMateriaMateria()+" Se borro correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al borrar la materia: " +buscarMateria(id).getMateriaMateria()+" "+ ex.getMessage());
        }
  
    }
    public List<Materia> obtenerMateriasPorEstado(int estado){
        List<Materia> materias = new ArrayList<Materia>();   

        try {
            String sql = "SELECT * FROM materia WHERE ESTADO=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,estado);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while(rs.next()){
                materia = new Materia();
                materia.setId_materia(rs.getInt("id_Materia"));
                materia.setMateriaMateria(rs.getString("nomMateria"));
                materia.setAnio(rs.getInt("anioMateria"));
                materia.setEstado(rs.getBoolean("estado"));
                materias.add(materia);
            } 
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener las materias: " + ex.getMessage());
        }

        return materias;
    }
    }
    

