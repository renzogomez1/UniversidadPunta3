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
    private int nota;

    public Cursada() {
    }

    public Cursada(int id_cursada, Alumno alumno, Materia materia, int nota) {
        this.id_cursada = id_cursada;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Cursada(Alumno alumno, Materia materia, int nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
}
