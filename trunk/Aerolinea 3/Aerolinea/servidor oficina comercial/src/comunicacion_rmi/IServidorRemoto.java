package comunicacion_rmi;

import Clases.Persona;
import Clases.Vuelo;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

/**
 * Interfaz que define los metodos a ser exportados por
 * el Objeto remoto que implemente esta interfaz.
 * Todos los metodos definidos en esta interfaz, deben
 * listar en la clausula "throws" la excepcion de tipo
 * java.rmi.RemoteException e incluso pueden generar
 * excepciones de otro tipo.
 */
public interface IServidorRemoto extends Remote
{
    public String Ingresar(String opcion) throws RemoteException;
    public Vector buscarCliente(Persona cliente) throws RemoteException;
    public void modificarDatosCliente (Persona cliente) throws RemoteException;
    public Vector datosVuelo (Persona persona)throws RemoteException;
    public void eliminarReservaVuelo (Vuelo vuelo, Persona persona) throws RemoteException;
}