package unmsm.com.logingooglelap.model;

/**
 * Created by Luis on 9/11/2017.
 */
/*
* Almacena la informacion particular de un usuario en el sistema.
* */

public class Usuario {
    private String dni;
    private String correo;


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
