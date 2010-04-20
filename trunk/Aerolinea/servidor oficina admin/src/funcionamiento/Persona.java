package funcionamiento;

import java.io.Serializable;

/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

public class Persona implements Serializable
{

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String ciudad;
    private String estado;
    private String zona;

    public Persona()
    {
        nombre = null;
        apellido = null;
        cedula = null;
        telefono = null;
        ciudad = null;
        estado = null;
        zona = null;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido()
    {
        return apellido;
    }

    /**
     * @return the cedula
     */
    public String getCedula()
    {
        return cedula;
    }


    /**
     * @return the telefono
     */
    public String getTelefono()
    {
        return telefono;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad()
    {
        return ciudad;
    }


    /**
     * @return the zona
     */
    public String getZona()
    {
        return zona;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula)
    {
        this.cedula = cedula;
    }


    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }


    /**
     * @param zona the zona to set
     */
    public void setZona(String zona)
    {
        this.zona = zona;
    }

    /**
     * @return the estado
     */
    public String getEstado()
    {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
}
