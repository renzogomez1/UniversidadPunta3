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
public class CursadaData {
     private Connection connection = null;
     private Conexion conexion;

    public CursadaData(Conexion conexion) {
        try {
            this.conexion=conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    
    public void guardarCursada(Cursada cursada){
        try {
            
            String sql = "INSERT INTO inscripcion (id_Alumno, id_Materia, calificacion, estado) VALUES ( ? , ? , ? ,1);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cursada.getAlumno().getId_alumno());
            ps.setInt(2, cursada.getMateria().getId_materia());
            ps.setFloat(3, cursada.getNota());

            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                cursada.setId_cursada(rs.getInt("id_Inscripcion"));
            } else {
                JOptionPane.showMessageDialog(null,"No se pudo obtener el id luego de insertar una inscripción");
            }
            ps.close();
            //Notificamos que se guardo
            JOptionPane.showMessageDialog(null,"La Inscripcion se realizo con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al realizar la inscripción: " + ex.getMessage());
        }
    }
    
    public List<Cursada> obtenerCursadas(){
        List<Cursada> cursadas = new ArrayList<>();
        Cursada cursada = null;    

        try {
            String sql = "SELECT * FROM inscripcion;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                cursada = new Cursada();
                cursada.setId_cursada(rs.getInt("id_Inscripcion"));               
                Alumno alumno = buscarAlumno(rs.getInt("id_Alumno"));
                cursada.setAlumno(alumno);              
                Materia materia = buscarMateria(rs.getInt("id_Materia"));
                cursada.setMateria(materia);
                cursada.setNota(rs.getFloat("calificacion"));
                cursada.setEstado(rs.getBoolean("estado"));
                cursadas.add(cursada);
            }      
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener la cursada: " + ex.getMessage());
        }       
        return cursadas;
    }
    
    public List<Cursada> obtenerCursadasXAlumno(int id){
        List<Cursada> cursadas = new ArrayList<>();
        /*ArrayList<Cursada>aux=(ArrayList<Cursada>) this.obtenerCursadas();
        Alumno a=null;
        for(Cursada c:aux){
            if(c.getAlumno().getId_alumno()==id){
            a=this.buscarAlumno(id);
            }
        }    
        if(a!=null){*/
        try {
            String sql = "SELECT * FROM inscripcion WHERE id_Alumno = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            Cursada cursada;
            while(rs.next()){
                cursada = new Cursada();
                cursada.setId_cursada(rs.getInt("id_inscripcion"));
                Alumno alumno = buscarAlumno(rs.getInt("id_Alumno"));
                cursada.setAlumno(alumno);            
                Materia materia = buscarMateria(rs.getInt("id_Materia"));
                cursada.setMateria(materia);
                cursada.setNota(rs.getFloat("calificacion"));
                cursada.setEstado(rs.getBoolean("estado"));
                cursadas.add(cursada);
            }      
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener las cursadas por alumnos: " + ex.getMessage());
        }//}else{JOptionPane.showMessageDialog(null, "El alumno no esta cursando ninguna materia");}       
        return cursadas;
    }

    
    public Alumno buscarAlumno(int id){
    
        AlumnoData ad=new AlumnoData(conexion);    
        return ad.buscarAlumno(id);
        
    }
    
    public Materia buscarMateria(int id){
    
        MateriaData md=new MateriaData(conexion);
        return md.buscarMateria(id);
    
    }
    
    public List<Materia> obtenerMateriasCursadasXAlumno(int id){
    List<Materia> materias = new ArrayList<>();       

        try {
            String sql = "SELECT m.id_Materia, nomMateria, anioMateria, m.estado FROM inscripcion as i, materia as m " +
                    "WHERE i.id_Materia = m.id_Materia and m.estado = 1 and i.estado = 1 and i.id_Alumno = ? ;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
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
            JOptionPane.showMessageDialog(null,"Error al obtener las materias por alumno " + ex.getMessage());
        }

        return materias;
      
    }
    
    public List<Materia> obtenerMateriasNOCursadas(int id){
    List<Materia> materias = new ArrayList<>();        

        try {
            String sql = "Select * from materia where id_Materia not in (select id_Materia from inscripcion where id_Alumno =?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
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
            JOptionPane.showMessageDialog(null,"Error al obtener las materias no cursadas: " + ex.getMessage());
        }

        return materias;
      
    }
    
    public void borrarCursadaDeunAlumnoFisico(int idAlumno,int idMateria){
    ArrayList<Cursada>aux=(ArrayList<Cursada>) this.obtenerCursadas();
    Alumno a = null;
    for(Cursada c:aux){
        if(c.getAlumno().getId_alumno()==idAlumno&&c.getMateria().getId_materia()==idMateria){
            a=this.buscarAlumno(idAlumno);
           }
        }
        if(a!=null){
        try {
            
            String sql = "DELETE FROM inscripcion WHERE id_Alumno =? and id_Materia =?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            ps.executeUpdate();

            ps.close();
        //Notificamos que se borro
        JOptionPane.showMessageDialog(null,"La cursada se borro correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al borrar una inscripción: " + ex.getMessage());
        }
    }else if(a==null){JOptionPane.showMessageDialog(null, "El alumno no se encuentra inscripto en la materia elegida");}}
    
    public void actualizarNota(int idAlumno,int idMateria, float nota){
    ArrayList<Cursada>aux=(ArrayList<Cursada>) this.obtenerCursadas();
    Alumno a = null;
    
    
    for(Cursada c:aux){
        if(c.getAlumno().getId_alumno()==idAlumno&&c.getMateria().getId_materia()==idMateria){
            a=this.buscarAlumno(idAlumno);
           
    }}
    
    
            if(a!=null&&nota<=10&&nota>=0){
            try {
            
            String sql = "UPDATE inscripcion SET calificacion = ? WHERE id_Alumno =? and id_Materia =?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1,nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
 
            ps.executeUpdate();

            ps.close();
        //Notificamos que se actualizo
        JOptionPane.showMessageDialog(null, "La nota se actualizo correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al actualizar la nota: " + ex.getMessage());
        }}
    else if(a==null){JOptionPane.showMessageDialog(null, "El alumno elegido no se encuentra cursando la materia elegida");}
    else if(nota>10||nota<0){JOptionPane.showMessageDialog(null,"La nota no es valida");}
    
    }

    
    public void borrarCursadaDeunAlumnoLogico(int idAlumno,int idMateria){
     ArrayList<Cursada>aux=(ArrayList<Cursada>) this.obtenerCursadas();
    Alumno a = null;
    
    boolean auxEstado=false;
    
    for(Cursada c:aux){
        if(c.getAlumno().getId_alumno()==idAlumno&&c.getMateria().getId_materia()==idMateria){
            a=this.buscarAlumno(idAlumno);
           if(c.isEstado()==true){auxEstado=true;}
        }
        }
        
        if(a!=null&&auxEstado==true){
        try {
            
            String sql = "UPDATE inscripcion SET estado = 0 WHERE id_Alumno =? and id_Materia =?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
 
            ps.executeUpdate();

            ps.close();
        //notificamos que se borro
        JOptionPane.showMessageDialog(null, "La cursada se borro correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al borrar una inscripcion: " + ex.getMessage());
        }
    }else if(a==null){JOptionPane.showMessageDialog(null, "El alumno no se encuentra inscripto en la materia elegida");}
    else if(auxEstado==false){JOptionPane.showMessageDialog(null,"La cursada que desea borrar ya se encuentra dada de baja");}
    
    
    }  
        /*
    public void inscribirCursadaDeunAlumnoLogico(int idAlumno,int idMateria){
    
        try {
            
            String sql = "UPDATE inscripcion SET estado = 1 WHERE id_Alumno =? and id_Materia =?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
 
            ps.executeUpdate();

            ps.close();
        //notificamos que se borro
        JOptionPane.showMessageDialog(null, "La cursada se Inscribio correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al Inscribir una materia: " + ex.getMessage());
        }
    }  
*/
}
