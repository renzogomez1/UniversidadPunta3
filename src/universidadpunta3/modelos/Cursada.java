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
public class Cursada {
    private int id_cursada;
    private Alumno alumno;
    private Materia materia;
    private float nota;
    private boolean estado;

    public Cursada() {
    }

    public Cursada(int id_cursada, Alumno alumno, Materia materia, float nota, boolean estado) {
        this.id_cursada = id_cursada;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.estado = estado;
    }

    public Cursada(Alumno alumno, Materia materia, float nota, boolean estado) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.estado = estado;
    }

    public int getId_cursada() {
        return id_cursada;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public float getNota() {
        return nota;
    }

    public void setId_cursada(int id_cursada) {
        this.id_cursada = id_cursada;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cursada{" + "id_cursada=" + id_cursada + ", alumno=" + alumno + ", materia=" + materia + ", nota=" + nota + '}';
    }
    
}
