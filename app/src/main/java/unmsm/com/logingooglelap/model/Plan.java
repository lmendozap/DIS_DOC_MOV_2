package unmsm.com.logingooglelap.model;

import java.util.List;

/**
 * Created by Luis on 18/11/2017.
 */
/*
Esta clase almacena la lista de cursos que almacena un plan. Un plan pertecene a una escuela y tiene un año de creacion
* */
public class Plan {
    private int anio;
    private int codEscuela;
    private List<Curso> cursos;




    public int getCodEscuela() {
        return codEscuela;
    }

    public void setCodEscuela(int codEscuela) {
        this.codEscuela = codEscuela;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
