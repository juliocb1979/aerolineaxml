package comunicacion_rmi_mainframe;
import Clases.Avion;
import Clases.Compra;
import Clases.Escala;
import Clases.Persona;
import Clases.Reserva;
import Clases.Vuelo;
import Clases.lugar;
import LogicaXML.AvionXML;
import LogicaXML.ClienteXML;
import LogicaXML.CompraXML;
import LogicaXML.LugarXML;
import LogicaXML.ReservaXML;
import LogicaXML.VueloXML;
import java.io.IOException;
import java.util.Vector;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.output.*;
import Clases.Oficina;
import LogicaXML.OficinaXML;
import pathProperties.*;

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
    private Document document;
    Vector vector = new Vector();
    private Persona clienteEncontrado=new Persona();
    private Vuelo vueloEncontrado=new Vuelo();
    private Avion avionEncontrado=new Avion();
    private lugar lugarEncontrado=new lugar();
    private Compra compraEncontrado=new Compra();
    private Reserva reservaEncontrado=new Reserva();
    private Oficina oficinaEncontrado=new Oficina();

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

    public Vector getXml()
    {
        return this.vector;
    }

  public void crearXML(Element root, int opcion){

        String ruta = null;
        Propiedades rutas = new Propiedades();
        rutas.setProperties();
        if(opcion==1)
          //ruta=rutas.rutaClientes;
          ruta="src/data_XML/clientes.xml";
        if(opcion==2)
          ruta=rutas.rutaVuelos;
          //ruta="src/data_XML/vuelos.xml";
        if(opcion==3)
          ruta=rutas.rutaAviones;
            //ruta="src/data_XML/aviones.xml";
        if(opcion==4)
          ruta=rutas.rutaLugares;
            //ruta="src/data_XML/lugares.xml";
        if(opcion==5)
          ruta=rutas.rutaCompras;
          //ruta="src/data_XML/compras.xml";
        if(opcion==6)
          ruta=rutas.rutaReservas;
          //ruta="src/data_XML/reservas.xml";
        if (opcion==7)
            ruta=rutas.rutaOficinas;
          //ruta="src/data_XML/oficinas_comerciales.xml";

        try
        {
            XMLOutputter out=new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream file=new FileOutputStream(ruta);
            out.output(root,file);
            file.flush();
            file.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
  public Element abrirDocumento (int opcion) throws JDOMException, IOException{
        String ruta = null;
        Propiedades rutas = new Propiedades();
        rutas.setProperties();
        if(opcion==1)
          ruta=rutas.rutaClientes;
//          ruta="src/data_XML/clientes.xml";
        if(opcion==2)
          ruta=rutas.rutaVuelos;
//          ruta="src/data_XML/vuelos.xml";
        if(opcion==3)
          ruta=rutas.rutaAviones;
//            ruta="src/data_XML/aviones.xml";
        if(opcion==4)
          ruta=rutas.rutaLugares;
//            ruta="src/data_XML/lugares.xml";
        if(opcion==5)
          ruta=rutas.rutaCompras;
          //ruta="src/data_XML/compras.xml";
        if(opcion==6)
          ruta=rutas.rutaReservas;
//          ruta="src/data_XML/reservas.xml";
        if (opcion==7)
           ruta=rutas.rutaOficinas;
          //ruta="src/data_XML/oficinas_comerciales.xml";

        SAXBuilder builder = new SAXBuilder(false);
        Document document = null;
        document = builder.build(ruta
                );
        Element root = document.getRootElement();
        return root;
    }


  /*
     *
     **/
  public Vector leerClientes() {

        Vector vector_clientes = null;
        vector_clientes = new Vector();
        try
        {

            Element raiz= abrirDocumento(1);
            List clientesList=raiz.getChildren("CLIENTE");
            Iterator i = clientesList.iterator();
            Persona cliente=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                cliente= new Persona();
                cliente.setCedula(element.getChild("ID_CLIENTE").getText());
                cliente.setNombre(element.getChild("NOMBRE").getText());
                cliente.setApellido(element.getChild("APELLIDO").getText());
                cliente.setTelefono(element.getChild("TELEFONO").getText());
                cliente.setCiudad(element.getChild("CIUDAD").getText());
                cliente.setEstado(element.getChild("ESTADO").getText());
                cliente.setZona(element.getChild("ZONA").getText());


                vector_clientes.add(cliente);
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

  return vector_clientes;

    }
  public Vector leerVuelos() {

        Vector vector_vuelos = null;
        vector_vuelos = new Vector();
        try
        {
            Element raiz= abrirDocumento(2);

            List vuelosList=raiz.getChildren("VUELO");
            Iterator i = vuelosList.iterator();
            Vuelo vuelo=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                vuelo= new Vuelo();
                vuelo.setDestino(element.getChild("DESTINO").getText());
                vuelo.setFechaSalida(element.getChild("FECHA").getText());
                vuelo.setIdAvion(element.getChild("ID_AVION").getText());
                vuelo.setIdVuelo(element.getChild("ID_VUELO").getText());
                vuelo.setOrigen(element.getChild("ORIGEN").getText());
                vuelo.setHora(element.getChild("HORA").getText());

                List escalas = element.getChildren("ESCALAS");
                Iterator j = escalas.iterator();
                Vector vector_esc = new Vector();


                while (j.hasNext())
                {
                    Element escala = (Element)j.next();
                    List escalasList = escala.getChildren("ESCALA");
                    Iterator iteEscalas = escalasList.iterator();
                    while(iteEscalas.hasNext())
                    {
                        Element eEscala = (Element) iteEscalas.next();
                        Escala escal = new Escala();
                        escal.setEscala(eEscala.getChild("NOMBRE").getText());
                        vector_esc.add(escal);
                    }
                }

                vuelo.setEscalas_vuelo(vector_esc);
                vector_vuelos.add(vuelo);
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }


  return vector_vuelos;

    }
  public Vector leerAviones() {

        Vector vector_aviones = null;
        vector_aviones = new Vector();
        try
        {
            Element raiz= abrirDocumento(3);
            List avionesList=raiz.getChildren("AVION");
            Iterator i = avionesList.iterator();
            Avion avion=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                avion= new Avion();
                avion.setCapacidad(element.getChild("CAPACIDAD").getText());
                avion.setIdAvion(element.getChild("ID_AVION").getText());
                avion.setMarca(element.getChild("MARCA").getText());
                avion.setModelo(element.getChild("MODELO").getText());

                vector_aviones.add(avion);
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

  return vector_aviones;

    }
  public Vector leerLugares() {

        Vector vector_lugares = null;
        vector_lugares = new Vector();
        try
        {
            Element raiz= abrirDocumento(4);
            List lugaresList=raiz.getChildren("LUGAR");
            Iterator i = lugaresList.iterator();
            lugar lugar=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                lugar= new lugar();
                lugar.setIdlugar(element.getChild("ID_LUGAR").getText());
                lugar.setNombreLugar(element.getChild("NOMBRE").getText());

                vector_lugares.add(lugar);
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

  return vector_lugares;

    }
  public Vector leerCompras() {

        Vector vector_compras = null;
        vector_compras = new Vector();
        try
        {
            Element raiz= abrirDocumento(5);
            List comprasList=raiz.getChildren("COMPRA");
            Iterator i = comprasList.iterator();
            Compra compra=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                compra= new Compra();
                compra.setFechaCompra(element.getChild("FECHA").getText());
                compra.setIdCliente(element.getChild("ID_CLIENTE").getText());
                compra.setIdOficina(element.getChild("ID_OFICINA").getText());
                compra.setIdVuelo(element.getChild("ID_VUELO").getText());
                compra.setIdCompra(element.getChild("ID_COMPRA").getText());

                vector_compras.add(compra);
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

  return vector_compras;

    }
  public Vector leerReservas() {

        Vector vector_reservas = null;
        vector_reservas = new Vector();
        try
        {
            Element raiz= abrirDocumento(6);
            List reservasList=raiz.getChildren("RESERVA");
                Iterator i = reservasList.iterator();
            Reserva reserva=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                reserva= new Reserva();
                reserva.setFechaCaduca(element.getChild("FECHA_CADUCACION").getText());
                reserva.setFechaReserva(element.getChild("FECHA").getText());
                reserva.setIdCliente(element.getChild("ID_CLIENTE").getText());
                reserva.setIdReserva(element.getChild("ID_RESERVA").getText());
                reserva.setIdVuelo(element.getChild("ID_VUELO").getText());
                reserva.setStatus(element.getChild("STATUS").getText());

                vector_reservas.add(reserva);
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

  return vector_reservas;

    }

  public Vector leerOficinas(){
       Vector vector_oficinas = null;
       vector_oficinas = new Vector();

       try
       {
           Element raiz= abrirDocumento(7);
           List oficinasList=raiz.getChildren("OFICINA");
           Iterator i = oficinasList.iterator();
           Oficina oficina=null;

            while (i.hasNext())
            {
                Element element= (Element)i.next();

                oficina= new Oficina();
                oficina.setIdOficina(element.getChild("ID_OFICINA").getText());
                oficina.setNombreOficina(element.getChild("NOMBRE").getText());
                oficina.setEstadoOficina(element.getChild("ESTADO").getText());
                oficina.setCiudadOficina(element.getChild("CIUDAD").getText());
                oficina.setZonaOficina(element.getChild("ZONA").getText());
                vector_oficinas.add(oficina);
            }
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    return vector_oficinas;
  }
/*
 *
 */


  public Persona leerCliente(String id) {

      try
        {

            Element raiz= abrirDocumento(1);
            List clientesList=raiz.getChildren("CLIENTE");
            Iterator i = clientesList.iterator();
            Persona cliente=null;

            while (i.hasNext())
            {
                Element element= (Element)i.next();
                cliente = new Persona();
                cliente.setCedula(element.getChild("ID_CLIENTE").getText());
                cliente.setNombre(element.getChild("NOMBRE").getText());
                cliente.setApellido(element.getChild("APELLIDO").getText());
                cliente.setTelefono(element.getChild("TELEFONO").getText());
                cliente.setCiudad(element.getChild("CIUDAD").getText());
                cliente.setEstado(element.getChild("ESTADO").getText());
                cliente.setZona(element.getChild("ZONA").getText());

                   //pasandolo a un String
                System.out.println("Cedula cliente= "+ cliente.getCedula() + "id recibido= "+id);

               if (cliente.getCedula().equals(id)) { // si encuentra el servicio
                   System.out.println(cliente.getNombre());
                   clienteEncontrado=cliente;

               }

            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
      System.out.println("1- "+clienteEncontrado.getApellido());
        return clienteEncontrado;

    }


  public Vuelo leerVuelo(String id) {
        try
        {
            Element raiz= abrirDocumento(2);
            List vuelosList=raiz.getChildren("VUELO");
            Iterator i = vuelosList.iterator();
            Vuelo vuelo=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                vuelo= new Vuelo();
                vuelo.setDestino(element.getChild("DESTINO").getText());
                vuelo.setFechaSalida(element.getChild("FECHA").getText());
                vuelo.setIdAvion(element.getChild("ID_AVION").getText());
                vuelo.setIdVuelo(element.getChild("ID_VUELO").getText());
                vuelo.setOrigen(element.getChild("ORIGEN").getText());
                vuelo.setHora(element.getChild("HORA").getText());
                if (vuelo.getIdVuelo().compareTo(id)== 0) { // si encuentra el servicio
               vueloEncontrado=vuelo;
               }

            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

  return vueloEncontrado;

    }


  public Avion leerAvion(String id) {
        try
        {
            Element raiz= abrirDocumento(3);
            List avionesList=raiz.getChildren("AVION");
            Iterator i = avionesList.iterator();
            Avion avion=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                avion= new Avion();
                avion.setCapacidad(element.getChild("CAPACIDAD").getText());
                avion.setIdAvion(element.getChild("ID_AVION").getText());
                avion.setMarca(element.getChild("MARCA").getText());
                avion.setModelo(element.getChild("MODELO").getText());
                if (avion.getIdAvion().compareTo(id)== 0) { // si encuentra el servicio
                   avionEncontrado=avion;

               }
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

  return avionEncontrado;

    }
  public lugar leerLugar(String id) {
        try
        {
            Element raiz= abrirDocumento(4);
            List lugaresList=raiz.getChildren("LUGAR");
            Iterator i = lugaresList.iterator();
            lugar lugar=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                lugar= new lugar();
                lugar.setIdlugar(element.getChild("ID_LUGAR").getText());
                lugar.setNombreLugar(element.getChild("NOMBRE").getText());
                 if (lugar.getIdlugar().compareTo(id)== 0) { // si encuentra el servicio
                   lugarEncontrado=lugar;

               }
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    return lugarEncontrado;

    }
  public Compra leerCompra(String id) {
        try
        {
            Element raiz= abrirDocumento(5);
            List comprasList=raiz.getChildren("COMPRA");
            Iterator i = comprasList.iterator();
            Compra compra=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                compra= new Compra();
                compra.setFechaCompra(element.getChild("FECHA").getText());
                compra.setIdCliente(element.getChild("ID_CLIENTE").getText());
                compra.setIdOficina(element.getChild("ID_OFICINA").getText());
                compra.setIdVuelo(element.getChild("ID_VUELO").getText());
                if (compra.getIdCompra().compareTo(id)== 0) { // si encuentra el servicio
                   compraEncontrado=compra;

               }
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

  return compraEncontrado;
    }
  public Reserva leerReserva(String id) {
        try
        {
            Element raiz= abrirDocumento(6);
            List reservasList=raiz.getChildren("RESERVA");
                Iterator i = reservasList.iterator();
            Reserva reserva=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                reserva= new Reserva();
                reserva.setFechaCaduca(element.getChild("FECHA_CADUCACION").getText());
                reserva.setFechaReserva(element.getChild("FECHA").getText());
                reserva.setIdCliente(element.getChild("ID_CLIENTE").getText());
                reserva.setIdReserva(element.getChild("ID_RESERVA").getText());
                reserva.setIdVuelo(element.getChild("ID_VUELO").getText());
                reserva.setStatus(element.getChild("STATUS").getText());

                if (reserva.getIdReserva().compareTo(id)== 0) { // si encuentra el servicio
                   reservaEncontrado=reserva;

               }
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

  return reservaEncontrado;

    }


  /**
   *
   * @param id de la oficina comercial a ser consultada
   */
  public Oficina leerOficina (String id)
  {
   try{
        Element raiz = abrirDocumento(7);
        List oficinasList=raiz.getChildren("OFICINA");
        Iterator i = oficinasList.iterator();
        Oficina oficina=null;
        while (i.hasNext())
            {
                Element element= (Element)i.next();
                oficina= new Oficina();
                oficina.setIdOficina(element.getChild("ID_OFICINA").getText());
                oficina.setNombreOficina(element.getChild("NOMBRE").getText());
                oficina.setEstadoOficina(element.getChild("ESTADO").getText());
                oficina.setCiudadOficina(element.getChild("CIUDAD").getText());
                oficina.setZonaOficina(element.getChild("ZONA").getText());

                if (oficina.getIdOficina().compareTo(id)== 0) { // si encuentra el servicio
                   oficinaEncontrado=oficina;

               }
            }
   }catch(Exception e)
   {
       System.out.println("error, causa: " + e.getMessage());
   }
   return oficinaEncontrado;
  }


  /*
   *
   * */
  public void agregarCliente(Persona cliente) throws JDOMException, IOException{
        try
        {
            Element raiz = abrirDocumento(1);
            List clientesList=raiz.getChildren("CLIENTE"); //dame una lista de los hijos de la raiz que se llaman AGENCIA

            ClienteXML clienteXML=new ClienteXML(cliente);
            raiz.addContent(clienteXML);
            crearXML(raiz,1);
        } catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
  public void agregarVuelo(Vuelo vuelo){
        try
        {
            Element raiz = abrirDocumento(2);
            VueloXML vuelosXML=new VueloXML(vuelo);
            raiz.addContent(vuelosXML);
            crearXML(raiz,2);
        } catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
  public void agregarAvion(Avion avion){
      System.out.println("LLEGO EHH---"+avion.getMarca());
      try
        {
            Element raiz = abrirDocumento(3);
            AvionXML avionXML=new AvionXML(avion);
            raiz.addContent(avionXML);
            crearXML(raiz,3);
        } catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
  public void agregarLugar(lugar lugar){
      try
        {
            Element raiz = abrirDocumento(4);
            LugarXML lugarXML=new LugarXML(lugar);
            raiz.addContent(lugarXML);
            crearXML(raiz,4);
        } catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
  public void agregarCompra(Compra compra){
   try
        {
            Element raiz = abrirDocumento(5);
            CompraXML compraXML=new CompraXML(compra);
            raiz.addContent(compraXML);
            crearXML(raiz,5);
        } catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
  public void agregarReserva(Reserva reserva){
    try
        {
            Element raiz = abrirDocumento(6);

            ReservaXML reservaXML=new ReservaXML(reserva);
            raiz.addContent(reservaXML);
            crearXML(raiz,6);
        } catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }

  /**
   *
   * @param oficina una instancia de la clase oficina a ser escrita en xml
   */
  public void agregarOficina(Oficina oficina)
  {
    try
    {
        Element raiz = abrirDocumento(7);
        OficinaXML oficinaXML = new OficinaXML(oficina);
        raiz.addContent(oficinaXML);
        crearXML(raiz,7);
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
  }


/*
 *
 */
  public void modificarCliente(Persona cliente) throws JDOMException, IOException{
       eliminarCliente(cliente.getCedula());
       agregarCliente(cliente);
  }
  public void modificarVuelo(Vuelo vuelo)throws JDOMException, IOException{
       eliminarVuelo(vuelo.getIdVuelo());
       agregarVuelo(vuelo);
    }
  public void modificarAvion(Avion avion)throws JDOMException, IOException{
      eliminarAvion(avion.getIdAvion());
       agregarAvion(avion);
    }
  public void modificarLugar(lugar lugar) throws JDOMException, IOException{
       eliminarLugar(lugar.getIdlugar());
       agregarLugar(lugar);

    }
  public void modificarCompra(Compra compra)  throws JDOMException, IOException{
       eliminarCompra(compra.getIdCompra());
       agregarCompra(compra);

    }
  public void modificarReserva(Reserva reserva) throws JDOMException, IOException{
      eliminarReserva(reserva.getIdReserva());
       agregarReserva(reserva);
    }

  public void modificarOficina(Oficina oficina) throws JDOMException, IOException {
      eliminarOficina(oficina.getIdOficina());
      agregarOficina(oficina);
  }
/**
 *
 * */

  public void eliminarCliente(String cedula) throws JDOMException, IOException{

        Element raiz=abrirDocumento(1);  //Se para en la raiz del XML
        List Serv=raiz.getChildren("CLIENTE"); //Dame los hijos de la raiz que se llamen CLIENTE

        Iterator i = Serv.iterator();
        Element nodoEliminar=null;
        while (i.hasNext()){  //hasta que no haya mas clientes.
               Element nodo= (Element)i.next();
               Element cedu =nodo.getChild("ID_CLIENTE");
               String a= cedu.getText();   //pasandolo a un String
               if (a.compareTo(cedula)== 0) { // si encuentra el servicio
                   nodoEliminar=nodo;

               }
        }
             raiz.removeContent(nodoEliminar);
             crearXML(raiz,1);

    }
  public void eliminarVuelo(String idvuelo) throws JDOMException, IOException{

        Element raiz=abrirDocumento(2);
        List Serv=raiz.getChildren("VUELO");
        Iterator i = Serv.iterator();
        Element nodoEliminar=null;
        while (i.hasNext()){
               Element nodo= (Element)i.next();
               Element id =nodo.getChild("ID_VUELO");
               String a= id.getText();
               if (a.compareTo(idvuelo)== 0) {
                   nodoEliminar=nodo;

               }
        }
             raiz.removeContent(nodoEliminar);
             crearXML(raiz,2);

    }
  public void eliminarAvion(String idavion) throws JDOMException, IOException{

        Element raiz=abrirDocumento(3);
        List Serv=raiz.getChildren("AVION");
        Iterator i = Serv.iterator();
        Element nodoEliminar=null;
        while (i.hasNext()){
               Element nodo= (Element)i.next();
               Element id =nodo.getChild("ID_AVION");
               String a= id.getText();
               if (a.compareTo(idavion)== 0) {
                   nodoEliminar=nodo;

               }
        }
             raiz.removeContent(nodoEliminar);
             crearXML(raiz,3);

    }
  public void eliminarLugar(String idlugar) throws JDOMException, IOException{

        Element raiz=abrirDocumento(4);
        List Serv=raiz.getChildren("LUGAR");
        Iterator i = Serv.iterator();
        Element nodoEliminar=null;
        while (i.hasNext()){
               Element nodo= (Element)i.next();
               Element id =nodo.getChild("ID_LUGAR");
               String a= id.getText();
               if (a.compareTo(idlugar)== 0) {
                   nodoEliminar=nodo;

               }
        }
             raiz.removeContent(nodoEliminar);
             crearXML(raiz,4);

    }
  public void eliminarCompra(String idcompra) throws JDOMException, IOException{

        Element raiz=abrirDocumento(5);
        List Serv=raiz.getChildren("COMPRA");
        Iterator i = Serv.iterator();
        Element nodoEliminar=null;
        while (i.hasNext()){
               Element nodo= (Element)i.next();
               Element id =nodo.getChild("ID_COMPRA");
               String a= id.getText();
               if (a.compareTo(idcompra)== 0) {
                   nodoEliminar=nodo;

               }
        }
             raiz.removeContent(nodoEliminar);
             crearXML(raiz,5);

    }
  public void eliminarReserva(String idreserva) throws JDOMException, IOException{

        Element raiz=abrirDocumento(6);
        List Serv=raiz.getChildren("RESERVA");
        Iterator i = Serv.iterator();
        Element nodoEliminar=null;
        while (i.hasNext()){
               Element nodo= (Element)i.next();
               Element id =nodo.getChild("ID_RESERVA");
               String a= id.getText();
               if (a.compareTo(idreserva)== 0) {
                   nodoEliminar=nodo;

               }
        }
             raiz.removeContent(nodoEliminar);
             crearXML(raiz,6);

    }

  public void eliminarOficina (String idOficina)throws JDOMException, IOException{
       Element raiz=abrirDocumento(7);
       List Serv=raiz.getChildren("OFICINA");

       Iterator i = Serv.iterator();
       Element nodoEliminar=null;
       while (i.hasNext()){ //hasta que no haya mas oficinas
              Element nodo =(Element) i.next();
              Element id=nodo.getChild("ID_OFICINA");
              String a=id.getText();
              if (a.compareTo(idOficina)==0){
               nodoEliminar=nodo;
              }
       }
             raiz.removeContent(nodoEliminar);
             crearXML(raiz,1);
  }

  public Reserva buscarReserva(String idCliente) {
      try
        {
            Element raiz= abrirDocumento(6);
            List reservasList=raiz.getChildren("RESERVA");
                Iterator i = reservasList.iterator();
            Reserva reserva=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                reserva= new Reserva();
                reserva.setFechaCaduca(element.getChild("FECHA_CADUCACION").getText());
                reserva.setFechaReserva(element.getChild("FECHA").getText());
                reserva.setIdCliente(element.getChild("ID_CLIENTE").getText());
                reserva.setIdReserva(element.getChild("ID_RESERVA").getText());
                reserva.setIdVuelo(element.getChild("ID_VUELO").getText());
                reserva.setStatus(element.getChild("STATUS").getText());

                if (reserva.getIdCliente().compareTo(idCliente)== 0) { // si encuentra el servicio
                   reservaEncontrado=reserva;

               }
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

  return reservaEncontrado;
    }


  public Reserva buscarReservaVuelo(String idVuelo) {
               try
        {
            Element raiz= abrirDocumento(6);
            List reservasList=raiz.getChildren("RESERVA");
                Iterator i = reservasList.iterator();
            Reserva reserva=null;
            while (i.hasNext())
            {
                Element element= (Element)i.next();

                reserva= new Reserva();
                reserva.setFechaCaduca(element.getChild("FECHA_CADUCACION").getText());
                reserva.setFechaReserva(element.getChild("FECHA").getText());
                reserva.setIdCliente(element.getChild("ID_CLIENTE").getText());
                reserva.setIdReserva(element.getChild("ID_RESERVA").getText());
                reserva.setIdVuelo(element.getChild("ID_VUELO").getText());
                reserva.setStatus(element.getChild("STATUS").getText());

                if (reserva.getIdVuelo().compareTo(idVuelo)== 0) { // si encuentra el servicio
                   reservaEncontrado=reserva;

               }
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

  return reservaEncontrado;
    }

    public void eliminarReserva(String idreserva, String idpersona) throws JDOMException, IOException{

        Element raiz=abrirDocumento(6);
        List Serv=raiz.getChildren("RESERVA");
        Iterator i = Serv.iterator();
        Element nodoEliminar=null;
        while (i.hasNext()){
               Element nodo= (Element)i.next();
               Element idReserv =nodo.getChild("ID_RESERVA");
               Element idPerso = nodo.getChild("ID_CLIENTE");
               String idR= idReserv.getText();
               String idP = idPerso.getText();
               if ((idR.compareTo(idreserva)== 0)&& (idP.compareTo(idpersona)==0)) {
                   nodoEliminar=nodo;

               }
        }
             raiz.removeContent(nodoEliminar);
             crearXML(raiz,6);

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
//            Naming.bind("//" + InetAddress.getLocalHost().getHostAddress() +":" + puerto + "/Servidor", this);
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

        //int port = 6100;
        int port = Integer.parseInt(java.util.ResourceBundle.getBundle("configConexion").getString("puerto_rmi_mainf"));

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
