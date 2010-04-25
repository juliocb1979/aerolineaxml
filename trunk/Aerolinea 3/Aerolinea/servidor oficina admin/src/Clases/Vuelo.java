package Clases;

import java.io.Serializable;
import java.util.Vector;

/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

public class Vuelo implements Serializable{

    private String origen;
    private String destino;
    private String fechaSalida;
    private String idVuelo;
    private String idAvion;
    private String hora;
    private Vector escalas_vuelo;


    public Vuelo(){
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @return the fechaSalida
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @return the fechaLlegada
     */

    /**
     * @return the idVuelo
     */
    public String getIdVuelo() {
        return idVuelo;
    }

    /**
     * @return the idAvion
     */
    public String getIdAvion() {
        return idAvion;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * @param fechaLlegada the fechaLlegada to set
     */

    /**
     * @param idVuelo the idVuelo to set
     */
    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    /**
     * @param idAvion the idAvion to set
     */
    public void setIdAvion(String idAvion) {
        this.idAvion = idAvion;
    }

    /**
     * @return the escalas_vuelo
     */
    public Vector getEscalas_vuelo() {
        return escalas_vuelo;
    }

    /**
     * @param escalas_vuelo the escalas_vuelo to set
     */
    public void setEscalas_vuelo(Vector escalas_vuelo) {
        this.escalas_vuelo = escalas_vuelo;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }


}
