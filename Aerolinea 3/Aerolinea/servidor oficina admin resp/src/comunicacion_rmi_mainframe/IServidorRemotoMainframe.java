package comunicacion_rmi_mainframe;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import Clases.Avion;
import Clases.Compra;
import Clases.Persona;
import Clases.Reserva;
import Clases.Vuelo;
import Clases.lugar;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import org.jdom.JDOMException;
import Clases.Oficina;

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
public interface IServidorRemotoMainframe extends Remote
{
    public String Peticion(String opcion) throws RemoteException;
    public Vector leerClientes() throws RemoteException;
    public Vector leerVuelos() throws RemoteException;
    public Vector leerAviones() throws RemoteException;
    public Vector leerLugares() throws RemoteException;
    public Vector leerCompras() throws RemoteException;
    public Vector leerReservas() throws RemoteException;
    public Vector leerOficinas() throws RemoteException;
    public Oficina leerOficina (String id)throws RemoteException;
    public Reserva buscarReserva(String idCliente) throws RemoteException;
    public Reserva buscarReservaVuelo(String idVuelo)throws RemoteException;

     public Persona leerCliente(String id) throws RemoteException;
     public Vuelo leerVuelo(String id) throws RemoteException;
     public Avion leerAvion(String id) throws RemoteException;
     public lugar leerLugar(String id) throws RemoteException;
     public Compra leerCompra(String id) throws RemoteException;
     public Reserva leerReserva(String id) throws RemoteException;

     public void agregarCliente(Persona cliente) throws JDOMException, IOException,RemoteException;
     public void agregarAvion(Avion avion) throws JDOMException, IOException,RemoteException;
     public void agregarVuelo(Vuelo vuelo) throws RemoteException;
     public void agregarLugar(lugar lugar) throws RemoteException;
     public void agregarCompra(Compra compra) throws RemoteException;
     public void agregarReserva(Reserva reserva) throws RemoteException;
     public void agregarOficina(Oficina oficina) throws RemoteException;

     public void modificarCliente(Persona cliente) throws JDOMException, IOException, RemoteException;
     public void modificarVuelo(Vuelo vuelo)throws JDOMException, IOException, RemoteException;
     public void modificarAvion(Avion avion)throws JDOMException, IOException , RemoteException;
     public void modificarLugar(lugar lugar) throws JDOMException, IOException , RemoteException;
     public void modificarCompra(Compra compra)  throws JDOMException, IOException, RemoteException;
     public void modificarReserva(Reserva reserva) throws JDOMException, IOException, RemoteException;
     public void modificarOficina(Oficina oficina) throws JDOMException, IOException, RemoteException;

     public void eliminarCliente(String cedula) throws JDOMException, IOException, RemoteException;
     public void eliminarVuelo(String idvuelo) throws JDOMException, IOException, RemoteException;
     public void eliminarAvion(String idavion) throws JDOMException, IOException, RemoteException;
     public void eliminarLugar(String idlugar) throws JDOMException, IOException, RemoteException;
     public void eliminarCompra(String idcompra) throws JDOMException, IOException, RemoteException;
     public void eliminarReserva(String idreserva) throws JDOMException, IOException, RemoteException;
     public void eliminarOficina(String idoficina) throws JDOMException, IOException, RemoteException;
     public void eliminarReserva(String idreserva, String idpersona) throws JDOMException, IOException, RemoteException;

}
