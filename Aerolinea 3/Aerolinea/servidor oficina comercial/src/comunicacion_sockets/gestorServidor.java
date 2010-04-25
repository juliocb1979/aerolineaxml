package comunicacion_sockets;

import comunicacion_rmi.ConexionRemoto;
import comunicacion_rmi.IServidorRemoto;
import Clases.Persona;
import Clases.Vuelo;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.XMLOutputter;


/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

public class gestorServidor implements Runnable, Serializable
{
    private ObjectOutputStream salida = null;
    private ObjectInputStream entrada = null;
    private Socket SocketCliente;
    private String fileLocation;
    private IServidorRemoto obj= null;
    private Vector resultado = null;



     public gestorServidor()
     {

     }

     public gestorServidor(Socket conex)
     {
        SocketCliente = conex;
     }

    public void run()
    {

        try
        {
            // Paso 3: obtener flujos para enviar y recibir datos
            obtenerFlujos();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        // Paso 4: procesar la conexion
        try
        {

           recibirMensaje();
           enviarMensaje(resultado);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error al realizar lectura de los flujos");
            return;
        }
        finally
        {
            try
            {
                //cerrar los flujos de I/O y el socket de comunicacion
                if (entrada != null)
                {
                    entrada.close();
                }
                if (salida != null)
                {
                    salida.close();
                }
                SocketCliente.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void obtenerFlujos () throws IOException
    {
        entrada = new ObjectInputStream( SocketCliente.getInputStream() );
        salida = new ObjectOutputStream( SocketCliente.getOutputStream() );
        salida.flush();
    }

   public IServidorRemoto Interfaz(){

        IServidorRemoto interfaz= null;
        interfaz =(IServidorRemoto)new ConexionRemoto().ConexionRemota();
        return interfaz;


    }

    public void recibirMensaje () throws ClassNotFoundException, IOException
    {

        try
        {
           Vector datos;
           datos = ((Vector) entrada.readObject());

           int peticion=(Integer) datos.elementAt(0);

           System.out.println("peticion: " +peticion);

           switch(peticion)
           {
               case 1:

//                   obj.ConsultarVuelos(datos);

               break;

               case 2:
                  Persona client = new Persona();
                  client = (Persona)datos.elementAt(1);
                  resultado= Interfaz().buscarCliente(client);

               break;

               case 3:
                  Persona cliente = new Persona();
                  cliente = (Persona)datos.elementAt(1);
                  Interfaz().modificarDatosCliente(cliente);

               break;

               case 4:
                  Persona usuario = new Persona();
                  usuario = (Persona)datos.elementAt(1);
                  resultado= (Vector) Interfaz().datosVuelo(usuario);

               break;

               case 5:
                  Vuelo vuelo = new Vuelo();
                  Persona person = new Persona();
                  vuelo = (Vuelo)datos.elementAt(1);
                  person = (Persona)datos.elementAt(2);
                  Interfaz().eliminarReservaVuelo(vuelo, person);

               break;

               case 6:

               break;

               case 7:

               break;
           }

        }
        catch (IOException excepcionES)
        {
            excepcionES.printStackTrace();
        }

    }

    /*
     * Este metodo envia la descripcion del modelo de computadora que
     * eligio el cliente
     */
    public void enviarMensaje(Vector mensajeCliente)
    {

        try
        {
            //Aquí se envía el mensaje al Cliente
            salida.writeObject(mensajeCliente);
            salida.flush();
        }
        catch (IOException excepcionES)
        {
            excepcionES.printStackTrace();
        }

    }
}