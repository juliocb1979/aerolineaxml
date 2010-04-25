/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pathProperties;

/**
 *
 * @author Juan Escalante
 */
import java.io.*;
import java.util.Properties;

public class Propiedades {
    public String rutaClientes;
    public String rutaVuelos;
    public String rutaAviones;
    public String rutaLugares;
    public String rutaCompras;
    public String rutaReservas;
    public String rutaOficinas;
    

    public Propiedades()
    {
    }

    public void setProperties()
    {
        
          try {
            rutaClientes=java.util.ResourceBundle.getBundle("configPath").getString("rutaClientes");
            rutaVuelos=java.util.ResourceBundle.getBundle("configPath").getString("rutaVuelos");;
            rutaAviones=java.util.ResourceBundle.getBundle("configPath").getString("rutaAviones");;
            rutaLugares=java.util.ResourceBundle.getBundle("configPath").getString("rutaLugares");;
            rutaCompras=java.util.ResourceBundle.getBundle("configPath").getString("rutaCompras");
            rutaReservas=java.util.ResourceBundle.getBundle("configPath").getString("rutaReservas");;
            rutaOficinas=java.util.ResourceBundle.getBundle("configPath").getString("rutaOficinas");

          }
          catch (Exception e)
          {
              System.out.println("Error tomando la ruta de archivos XML. Descripción: " + e);


          }
        

    }
    public static void main(String[] args)
     {
     //create an instance of Greeting3 class

     Propiedades con = new Propiedades();

     //call the setMessage() method of the Greeting3 class

     con.setProperties();
     }
}
