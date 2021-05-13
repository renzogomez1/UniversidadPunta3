/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadpunta3.modelos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    
    public void guardarMateria(Materia materia){
        try {
            
            String sql = "INSERT INTO materia (nombre) VALUES ( ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, materia.getMateriaMateria());
            
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                materia.setId_materia(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una materia");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una materia: " + ex.getMessage());
        }
    }
    
    public List<Materia> obtenerMaterias(){
        List<Materia> materias = new ArrayList<Materia>();
            

        try {
            String sql = "SELECT * FROM materia;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Materia materia;
            while(resultSet.next()){
                materia = new Materia();
                materia.setId_materia(resultSet.getInt("id"));
                materia.setMateriaMateria(resultSet.getString("nombre"));
               

                materias.add(materia);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las materias: " + ex.getMessage());
        }
        
        
        return materias;
    }
    
    public Materia buscarMateria(int id){
    
        Materia materia=null;
    try {
            
            String sql = "SELECT * FROM materia WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                materia = new Materia();
                materia.setId_materia(resultSet.getInt("id"));
                materia.setMateriaMateria(resultSet.getString("nombre"));
               

                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una materia: " + ex.getMessage());
        }
        
        return materia;
    }
    public void borrarMateria (int id){
    
        
    try {
            
            String sql = "DELETE FROM materia WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar una materia: " + ex.getMessage());
        }
        
    
    
    }
    public void actualizarMateria(Materia materia){
    try {
            
            String sql = "UPDATE materia SET nombre = ? WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, materia.getMateriaMateria());
            statement.setInt(2, materia.getId_materia());
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una materia: " + ex.getMessage());
        }
     
        
    
    }
    }
    

