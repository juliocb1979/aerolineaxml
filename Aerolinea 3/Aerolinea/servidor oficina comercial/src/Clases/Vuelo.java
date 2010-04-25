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

public class Vuelo implements Serializable{

    private String idVuelo;
    private String idAvion;
    private String origen;
    private String destino;
    private String fechaSalida;
    private String fechaRegreso;
    private String horaSalida;
    private String horaLlegada;


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
     * @return the fechaRegreso
     */
    public String getFechaRegreso() {
        return fechaRegreso;
    }

    /**
     * @param fechaRegreso the fechaRegreso to set
     */
    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    /**
     * @return the horaSalida
     */
    public String getHoraSalida() {
        return horaSalida;
    }

    /**
     * @param horaSalida the horaSalida to set
     */
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    /**
     * @return the horaLlegada
     */
    public String getHoraLlegada() {
        return horaLlegada;
    }

    /**
     * @param horaLlegada the horaLlegada to set
     */
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

}
