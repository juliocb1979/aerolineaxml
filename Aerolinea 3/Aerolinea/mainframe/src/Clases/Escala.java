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

public class Escala implements Serializable{

    private String escala;

    public Escala(String escala){
        this.escala=escala;
    }

    public Escala(){
    }


    /**
     * @return the escala
     */
    public String getEscala() {
        return escala;
    }

    /**
     * @param escala the escala to set
     */
    public void setEscala(String escala) {
        this.escala = escala;
    }



}