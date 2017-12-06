package unmsm.com.logingooglelap.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Luis on 9/11/2017.
 */
/*
* Alamacena la lista de todos los usuarios del sistema
* */

public class Usuarios implements Serializable {

    private List<Usuario> listaUsuarios;

    public void Usuarios(){

    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
