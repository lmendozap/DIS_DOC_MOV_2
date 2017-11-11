package unmsm.com.logingooglelap.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Luis on 9/11/2017.
 */

public class Disponibilidad implements Serializable {

    private List<String> Lunes;
    private List<String> Martes;
    private List<String> Miercoles;
    private List<String> Jueves;
    private List<String> Viernes;
    private List<String> Sabado;


    private void Disponibilidad(){

    }


    public List<String> getLunes() {
        return Lunes;
    }

    public void setLunes(List<String> lunes) {
        Lunes = lunes;
    }

    public List<String> getMartes() {
        return Martes;
    }

    public void setMartes(List<String> martes) {
        Martes = martes;
    }

    public List<String> getMiercoles() {
        return Miercoles;
    }

    public void setMiercoles(List<String> miercoles) {
        Miercoles = miercoles;
    }

    public List<String> getJueves() {
        return Jueves;
    }

    public void setJueves(List<String> jueves) {
        Jueves = jueves;
    }

    public List<String> getViernes() {
        return Viernes;
    }

    public void setViernes(List<String> viernes) {
        Viernes = viernes;
    }

    public List<String> getSabado() {
        return Sabado;
    }

    public void setSabado(List<String> sabado) {
        Sabado = sabado;
    }


}
