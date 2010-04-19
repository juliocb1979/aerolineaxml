package comunicacion_rmi_mainframe;

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

public class Servidor extends UnicastRemoteObject implements IServidorRemotoMainframe {

    private int puerto;


    public Servidor (int p) throws RemoteException

    {
        super(p);

        /*le indica a UnicastRemoteObject que se va a disparar con el ip "p" */
        puerto = p;
    }

    
    public String Peticion (String opcion)
    {
        System.out.println(opcion);

        //Se procesa respuesta, en éste caso un Strin a retornar por el metodo
        String respuesta = null;
        respuesta = "Respuesta de Mainframe";
        return (respuesta);
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

        int port = 6100;

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
