package unmsm.com.logingooglelap.model;

import java.util.List;

/**
 * Created by Luis on 18/11/2017.
 */
/**
 * Esta clase alamacena una malla curricular. Una malla curricular estara compuesta por varios planes
 * academicos  de todas las escuelas.
 */


public class Malla {

    private List<Plan> planes;

       public List<Plan> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plan> planes) {
        this.planes = planes;
    }
}
