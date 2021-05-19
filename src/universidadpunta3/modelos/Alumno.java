/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadpunta3.modelos;

import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class Alumno {
     private int id_alumno;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private int legajo;
    private boolean estado;

    public Alumno() {
    }

    public Alumno(int id_alumno, String nombre, String apellido, LocalDate fechaNac, int legajo, boolean estado) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.legajo = legajo;
        this.estado = estado;
    }

    public Alumno(String nombre, String apellido, LocalDate fechaNac, int legajo, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.legajo = legajo;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.nombre+" "+this.apellido;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
