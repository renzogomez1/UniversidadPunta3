/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadpunta3.modelos;

/**
 *
 * @author Asus
 */
public class Materia {
     private int id_materia;
    private String materiaMateria;
    private int anio;
    private boolean estado;

    public Materia() {
    }

    public Materia(int id_materia, String materiaMateria, int anio, boolean estado) {
        this.id_materia = id_materia;
        this.materiaMateria = materiaMateria;
        this.anio = anio;
        this.estado = estado;
    }

    public Materia(String materiaMateria, int anio, boolean estado) {
        this.materiaMateria = materiaMateria;
        this.anio = anio;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.materiaMateria;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getMateriaMateria() {
        return materiaMateria;
    }

    public void setMateriaMateria(String materiaMateria) {
        this.materiaMateria = materiaMateria;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
