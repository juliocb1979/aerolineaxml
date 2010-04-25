package comunicacion_rmi;

import comunicacion_rmi_mainframe.ConexionRemoto;
import comunicacion_rmi_mainframe.GUI3;
import comunicacion_rmi_mainframe.IServidorRemotoMainframe;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import Clases.Compra;
import Clases.Persona;
import Clases.Reserva;
import Clases.Vuelo;
import Clases.lugar;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.JDOMException;


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
    private IServidorRemotoMainframe obj= null;

    public Servidor (int p) throws RemoteException

    {
        super(p);

        /*le indica a UnicastRemoteObject que se va a disparar con el ip "p" */
        puerto = p;
        GUI3 ventanaPrincipal = new GUI3();
        ventanaPrincipal.setVisible(true);
    }


    //Aquí se recibe la petición desde servidor comercial
    public String Ingresar (String opcion)
    {
        System.out.println(opcion);

        //Se procesa respuesta, en éste caso un Strin a retornar por el metodo
        String respuesta = null;
        respuesta = "Desde Server administrativo: Como estas Servidor Comercial?";

            String respMainframe = null;
            try
            {
                ConexionRemoto objeto = new ConexionRemoto();
                obj = objeto.ConexionRemota();

                //se envia un mensaje de petición al mainframe
                //"respServAdm" es la respuesta obtenidad desde el servidor administrativo
                respMainframe = obj.Peticion("Peticion desde server administrativo");
                System.out.println (respMainframe);
            }
            catch  (Exception e)
            {
            }

        return respuesta;
    }


    public IServidorRemotoMainframe Interfaz(){

        IServidorRemotoMainframe interfaz= null;
        interfaz =(IServidorRemotoMainframe)new ConexionRemoto().ConexionRemota();
        return interfaz;
    }

    public Vector buscarCliente(Persona persona) throws RemoteException {

        String cedula = (String)persona.getCedula();
        Persona cliente =new Persona();

        System.out.println("ehhhhh"+persona.getCedula());

        cliente = Interfaz().leerCliente(cedula);


        Vector resultado = null;
        resultado=new Vector();
        resultado.add(0, cliente);

        return resultado;
    }

    public void modificarDatosCliente (Persona persona) throws RemoteException{
        try {

            Interfaz().modificarCliente(persona);

        } catch (JDOMException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ef) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ef);
        }

    }

    public Vector datosVuelo (Persona persona) throws RemoteException {

        Reserva reservaVuelo =new Reserva();
        Vuelo vueloEncontrado = new Vuelo();
        lugar lugarDestino = new lugar();
        lugar lugarOrigen = new lugar();

        String cedula = (String)persona.getCedula();
        System.out.println("cedula a buscar = " + cedula);

        reservaVuelo = Interfaz().buscarReserva(cedula);

        String idVuelo = reservaVuelo.getIdVuelo();
        System.out.println("idVuelo a buscar = "+idVuelo);

        vueloEncontrado = (Vuelo)Interfaz().leerVuelo(idVuelo);
        String idDestino = vueloEncontrado.getDestino();
        String idOrigen = vueloEncontrado.getOrigen();

        lugarDestino = Interfaz().leerLugar(idDestino);
        lugarOrigen = Interfaz().leerLugar(idOrigen);

        String destinoVuelo = lugarDestino.getNombreLugar();
        String origenVuelo = lugarOrigen.getNombreLugar();

        System.out.println("origenVuelo = " + origenVuelo);
        System.out.println("destinoVuelo = " + destinoVuelo);

        Vector resultado = null;
        resultado=new Vector();
        resultado.add(0, vueloEncontrado);
        resultado.add(1,destinoVuelo);
        resultado.add(2,origenVuelo);

        return resultado;
    }

    public void eliminarReservaVuelo (Vuelo vuelo, Persona persona) throws RemoteException {

    String idVuelo = vuelo.getIdVuelo();
    String idpersona = persona.getCedula();

    Reserva reserv = new Reserva();

    reserv = Interfaz().buscarReservaVuelo(idVuelo);
    String idReserva = reserv.getIdReserva();
        try {
            Interfaz().eliminarReserva(idReserva,idpersona);
        } catch (JDOMException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        int port = Integer.parseInt(java.util.ResourceBundle.getBundle("configuracion").getString("puerto_rmi"));

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
