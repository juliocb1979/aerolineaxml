/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comunicacion_rmi;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

public class Servidor extends UnicastRemoteObject implements IServidorRemoto {

    private int puerto;


    public Servidor (int p) throws RemoteException

    {
        super(p);

        /*le indica a UnicastRemoteObject que se va a disparar con el
                  ip "p" */
        puerto = p;
    }

    public void Ingresar (String opcion)
    {

//       persona recibido = (persona)aux.elementAt(0);
//
//       String nombre = (String)recibido.getNombre();

        System.out.println("Este es el mensaje que recibi del servidor Comercial: "+ opcion);
//        String respuesta = "Respuesta del servidor Administativo";
//        Vector vec = new Vector<Object>();
//        vec.add(respuesta);
//        return vec;
    }


    public String Respuesta()
    {
        String respuesta;
        respuesta = "Respuesta desde Servidor Administrativo";
        return respuesta;
    }


    public void finalize()
    {
        try
        {
            Naming.unbind("//" + InetAddress.getLocalHost().getHostAddress() +":" + puerto + "/Servidor");
            System.out.println("Servidor de Archivos finalizado");
         }
         catch (Exception e)
         {
            System.out.println("Error al detener servidor, causa: " + e.toString());
         }
    }
    public boolean registrarServicio()
    {
        try
        {
            // crea el RMIRegistry en el puerto indicado
            LocateRegistry.createRegistry(puerto);
            Naming.bind("//" + InetAddress.getLocalHost().getHostAddress() +":" + puerto + "/Servidor", this);
            System.out.println("Servidor de Archivos ha sido iniciado exitosamente");
            return true;
         }
         catch (Exception e)
         {
            System.out.println("Error al iniciar servidor, causa: " + e.toString());
            return false;
         }
    }

    public static void main(String[] args) {

        int port = 6000;

        Servidor server = null;

        try
        {
            server = new Servidor(port);
            if (!server.registrarServicio())
                System.exit(1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
