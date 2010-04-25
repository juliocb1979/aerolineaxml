/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author Juan Escalante
 */
import java.io.Serializable;
public class Oficina implements Serializable{
    private String idOficina;
    private String nombre;
    private String estado;
    private String ciudad;
    private String zona;
    private String contVentas;

    public Oficina()
    {}
    /***
     * @return id de la oficina comercial
     */
    public String getIdOficina(){
    return idOficina;
    }

    /**
     *
     * @return nombre de la oficina
     */
    public String getNombreOficina(){
    return nombre;
    }

    /**
     *
     * @return codigo del estado
     */
    public String getEstadoOficina(){
    return estado;
    }

    /**
     *
     * @return codigo de la ciudad
     */
    public String getCiudadOficina(){
    return ciudad;
    }

    /**
     *
     * @return codigo de la zona
     */
    public String getZonaOficina(){
    return zona;
    }

    /**
     *
     * @param idOficina setea el id de la oficina
     */
    public void setIdOficina(String idOficina) {
        this.idOficina = idOficina;
    }
    /**
     *
     * @param nombreOficina setea el nombre de la oficina
     */
    public void setNombreOficina(String nombreOficina) {
        this.nombre = nombreOficina;
    }
    /**
     *
     * @param estadoOficina setea estado de la oficina
     */
    public void setEstadoOficina(String estadoOficina) {
        this.estado = estadoOficina;
    }
    /**
     *
     * @param ciudadOficina setea ciudad de la oficina
     */
    public void setCiudadOficina(String ciudadOficina) {
        this.ciudad = ciudadOficina;
    }
    /**
     *
     * @param zonaOficina setea zona de la oficina
     */
    public void setZonaOficina(String zonaOficina) {
        this.zona = zonaOficina;
    }

    public String getVentasOficina(){
        return contVentas;
    }
    public void  setVentasOficina(String contVentas){
        this.contVentas=contVentas;
    }
}
