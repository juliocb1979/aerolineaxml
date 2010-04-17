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

public class Reserva implements Serializable{

    private String idReserva;
    private String idVuelo;
    private String idCliente;
    private String fechaReserva;
    private String fechaCaduca;
    private String status;


    public Reserva() {}

    /**
     * @return the idVuelo
     */
    public String getIdVuelo() {
        return idVuelo;
    }

    /**
     * @return the fechaReserva
     */
    public String getFechaReserva() {
        return fechaReserva;
    }

    /**
     * @return the fechaCaduca
     */
    public String getFechaCaduca() {
        return fechaCaduca;
    }

    /**
     * @param idVuelo the idVuelo to set
     */
    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    /**
     * @param fechaReserva the fechaReserva to set
     */
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * @param fechaCaduca the fechaCaduca to set
     */
    public void setFechaCaduca(String fechaCaduca) {
        this.fechaCaduca = fechaCaduca;
    }

    /**
     * @return the idReserva
     */
    public String getIdReserva() {
        return idReserva;
    }

    /**
     * @param idReserva the idReserva to set
     */
    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
