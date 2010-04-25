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
        Properties props = new Properties();
        try
        {
            props.load(new FileInputStream("configuracion.properties"));
            rutaClientes=props.getProperty("rutaClientes");
            rutaVuelos=props.getProperty("rutaVuelos");
            rutaAviones=props.getProperty("rutaAviones");
            rutaLugares=props.getProperty("rutaLugares");
            rutaCompras=props.getProperty("rutaCompras");
            rutaReservas=props.getProperty("rutaReservas");
            rutaOficinas=props.getProperty("rutaOficinas");
        }

        catch (IOException e)
        {
            e.printStackTrace();
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
