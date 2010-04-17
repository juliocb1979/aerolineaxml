/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comunicacion_sockets;

import comunicacion_rmi.ConexionRemoto;
import comunicacion_rmi.IServidorRemoto;
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
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Luis Figueras
 */

public class gestorServidor implements Runnable, Serializable  {
    private ObjectOutputStream salida = null;
    private ObjectInputStream entrada = null;
    private Socket SocketCliente;
    private String fileLocation;
    private IServidorRemoto obj= null;


 public gestorServidor() {
    }
    public gestorServidor(Socket conex) {
    SocketCliente = conex;
}

    public void run() {

        try {
            // Paso 3: obtener flujos para enviar y recibir datos
            obtenerFlujos();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Paso 4: procesar la conexion
        try {
               // recibe los mensajes enviados por el Cliente
           String  mensajeCliente = recibirMensaje();


           //Envio de objeti hacia servidor RMI, resp es la respuesta devuelta por servidor rmi


           String respServAdm = null;
        try
           {
                ConexionRemoto objeto = new ConexionRemoto();
                obj = objeto.ConexionRemota();
                obj.Ingresar(mensajeCliente);
                respServAdm = obj.Respuesta();
           }
           catch  (Exception e)
           {
           }


              // enviar respuesta al Servidor
//               enviarMensaje(mensajeCliente);
               enviarMensaje(respServAdm);
        } catch (Exception e) {
            e.printStackTrace();
             System.out.println("Error al realizar lectura de los flujos");
            return;
        } finally {
            try {
//                 cerrar los flujos de I/O y el socket de comunicacion
                if (entrada != null) {
                    entrada.close();
                }
                if (salida != null) {
                    salida.close();
                }
                SocketCliente.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void obtenerFlujos () throws IOException{

        entrada = new ObjectInputStream( SocketCliente.getInputStream() );
        salida = new ObjectOutputStream( SocketCliente.getOutputStream() );
        salida.flush(); // vaciar búfer de salida para enviar información de encabezado
    }

    public String recibirMensaje () throws ClassNotFoundException{
           String mensajeCliente=null;
           try {
           //Aquí se recibe el mensaje del cliente y se imprime
           mensajeCliente = (String)entrada.readObject();
           System.out.println(mensajeCliente);
           }catch (IOException excepcionES){
              excepcionES.printStackTrace(); }
           return mensajeCliente;
    }

    /*
     * Este metodo envia la descripcion del modelo de computadora que
     * eligio el cliente
     */
    public void enviarMensaje(String mensajeCliente){
        
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