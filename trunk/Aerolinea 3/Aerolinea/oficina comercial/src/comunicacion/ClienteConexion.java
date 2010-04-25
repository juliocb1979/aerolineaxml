package comunicacion;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;

/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

public class ClienteConexion
{
    private Socket conexion; //Socket de Conexion al servidor
    private String host;//Nombre del host donde esta ubicado el servidor
    private int puerto; //Puerto donde el servidor recibe las peticiones
    static int i = 1;

    /**
     * Constructor de la clase Cliente Conexion
     */
    public ClienteConexion()
    {
        String p = java.util.ResourceBundle.getBundle("configConexion").getString("puertoConex1"); // Del archivo de propiedades le paso el parametro de servicio
        int port = Integer.parseInt(p);
        String ip = java.util.ResourceBundle.getBundle("configConexion").getString("ip1"); // Del archivo de propiedades le paso el parametro de servicio
        host = ip;
        puerto = port;
    }

    public void ClienteConexion2()
    {
        String p = java.util.ResourceBundle.getBundle("configConexion").getString("puertoConex2"); // Del archivo de propiedades le paso el parametro de servicio
        int port = Integer.parseInt(p);
        String ip = java.util.ResourceBundle.getBundle("configConexion").getString("ip2"); // Del archivo de propiedades le paso el parametro de servicio
        host = ip;
        puerto = port;
    }
   /**
    * Cierra la conexion previamente establecida
    */
    public void cerrarConexion()
    {
        try
        {
            if (conexion != null)
            {
                conexion.close();
                conexion = null;
            }
        }
        catch(Exception e )
        {
            System.out.println("No es posible terminar conexion, causa: "+e.getMessage());
        }
    }
    /**
     * Abre una conexion con el servidor en el puerto y host indicado.
     * Implementa la Tolerancia a Fallas en caso que el servidor
     * principal no este en linea.
     */
    public void abrirConexion()
    {
        if (conexion == null)
        {
            try
            {
                conexion = new Socket(host, puerto);
                System.out.println("Socket aceptado exitosamente "+host);
            }
            catch (Exception e)
            {
                try
                {
                    System.out.println("No puede abrirse la conexion con "+host+", causa: "+e.getMessage());
                    conexion = null;
                    ClienteConexion2();
                    abrirConexion();
                }
                catch (Exception f)
                {
                    System.out.println("No puede abrirse la conexion con "+host+", causa: "+e.getMessage());
                    conexion = null;
                }
            }

        }
    }
    /**
     * @return respuesta del servidor
     */
    public Object recibir()
    {
        if (conexion != null)
        {
            try
            {
             return  new ObjectInputStream(conexion.getInputStream()).readObject();
            }
            catch(Exception e)
            {
                return null;
            }
        }
        else
            return null;
    }
    /**
     * Permite enviar las peticiones al servidor
     */
    public void enviar(Vector mensaje)
    {
        if (conexion != null)
        {
            try
            {
                new ObjectOutputStream(conexion.getOutputStream()).writeObject(mensaje);
            }
            catch(Exception e)
            {
                System.out.println("No puede ser enviada la peticion, causa: "+e.getMessage());
            }
        }
    }
}
