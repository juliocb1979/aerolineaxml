package comunicacion_rmi;


/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

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
//    public Vector consultar(String opcion) throws RemoteException;

    public void Ingresar(String opcion) throws RemoteException;
    public String Respuesta() throws RemoteException;
}
