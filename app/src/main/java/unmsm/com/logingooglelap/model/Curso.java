package unmsm.com.logingooglelap.model;

/**
 * Created by Luis on 17/11/2017.
 */

/*
    Esta clase almacenara la informacion de un curso que dicta un docente.
**/

public class Curso {
    private int codigoEscuela;
    private String escuela;
    private String nombre;



    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoEscuela() {
        return codigoEscuela;
    }

    public void setCodigoEscuela(int codigoEscuela) {
        this.codigoEscuela = codigoEscuela;
    }
}
