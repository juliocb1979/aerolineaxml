package oficinacomercial;

import java.io.Serializable;

/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

public class lugar implements Serializable{

    private String idlugar;
    private String nombreLugar;

    /**
     * @return the idlugar
     */
    public String getIdlugar() {
        return idlugar;
    }

    /**
     * @param idlugar the idlugar to set
     */
    public void setIdlugar(String idlugar) {
        this.idlugar = idlugar;
    }

    /**
     * @return the nombreLugar
     */
    public String getNombreLugar() {
        return nombreLugar;
    }

    /**
     * @param nombreLugar the nombreLugar to set
     */
    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }
}
