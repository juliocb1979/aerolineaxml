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

public class Avion implements Serializable
{

    private String idAvion;
    private String capacidad;
    private String marca;
    private String modelo;

    public Avion(){}

    /**
     * @return the idAvion
     */
    public String getIdAvion()
    {
        return idAvion;
    }

    /**
     * @return the capacidad
     */
    public String getCapacidad()
    {
        return capacidad;
    }

    /**
     * @param idAvion the idAvion to set
     */
    public void setIdAvion(String idAvion)
    {
        this.idAvion = idAvion;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(String capacidad)
    {
        this.capacidad = capacidad;
    }

    /**
     * @return the marca
     */
    public String getMarca()
    {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo()
    {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

}
