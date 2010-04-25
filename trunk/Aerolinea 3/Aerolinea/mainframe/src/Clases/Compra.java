package Clases;

import java.io.Serializable;

/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

public class Compra implements Serializable {

    private String idVuelo;
    private String idCliente;
    private String fechaCompra;
    private String idOficina;
    private String idCompra;

    public Compra(){}

    /**
     * @return the idVuelo
     */
    public String getIdVuelo() {
        return idVuelo;
    }

    /**
     * @return the fechaCompra
     */
    public String getFechaCompra() {
        return fechaCompra;
    }

    /**
     * @param idVuelo the idVuelo to set
     */
    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    /**
     * @param fechaCompra the fechaCompra to set
     */
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * @return the idCliente
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idOficina
     */
    public String getIdOficina() {
        return idOficina;
    }

    /**
     * @param idOficina the idOficina to set
     */
    public void setIdOficina(String idOficina) {
        this.idOficina = idOficina;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

}
