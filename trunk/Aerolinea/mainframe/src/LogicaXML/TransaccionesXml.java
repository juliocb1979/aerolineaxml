/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaXML;
import Clases.Avion;
import Clases.Compra;
import Clases.Persona;
import Clases.Reserva;
import Clases.Vuelo;
import Clases.lugar;
import java.io.*;
import java.util.Vector;
import java.util.List;
import java.util.Iterator;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;
/**
 *
 * @author MANU
 */
public class TransaccionesXml {

Vector vector = new Vector();
private Persona clienteEncontrado=new Persona();
  private Vuelo vueloEncontrado=new Vuelo();
  private Avion avionEncontrado=new Avion();
  private lugar lugarEncontrado=new lugar();
  private Compra compraEncontrado=new Compra();
  private Reserva reservaEncontrado=new Reserva();
  
    @SuppressWarnings("unchecked")
    
    public Vector getXml()
    {
        return this.vector;
    }
    
  public void crearXML(Element root, int opcion){
       
        String ruta = null;
        if(opcion==1)
          
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/clientes.xml";
      if(opcion==2)
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/vuelos.xml";
      if(opcion==3)
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/aviones.xml";
      if(opcion==4)
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/lugares.xml";
         if(opcion==5)
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/compras.xml";
   if(opcion==6)
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/reservas.xml";
      
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
      if(opcion==1)
          
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/clientes.xml";
      if(opcion==2)
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/vuelos.xml";
      if(opcion==3)
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/aviones.xml";
      if(opcion==4)
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/lugares.xml";
      if(opcion==5)
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/compras.xml";
      if(opcion==6)
          ruta="C:/Users/MANU/Desktop/SISTEMAS-DISTRIBUIDOS/XMLS/reservas.xml";
        
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
                
                
                this.vector.add(cliente);
            }           
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    
  return vector;      
        
    }
  public Vector leerVuelos() {
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
                vuelo.setFechaRegreso(element.getChild("FECHA_REGRESO").getText());
                vuelo.setFechaSalida(element.getChild("FECHA_SALIDA").getText());
                vuelo.setIdAvion(element.getChild("ID_AVION").getText());
                vuelo.setIdVuelo(element.getChild("ID_VUELO").getText());
                vuelo.setOrigen(element.getChild("ORIGEN").getText());
                
                this.vector.add(vuelo);
            }           
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    
  return vector;      
        
    }
  public Vector leerAviones() {
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
                
                this.vector.add(avion);
            }           
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    
  return vector;      
        
    }
  public Vector leerLugares() {
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
                
                this.vector.add(lugar);
            }           
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    
  return vector;      
        
    }
  public Vector leerCompras() {
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
                
                this.vector.add(compra);
            }           
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    
  return vector;      
        
    }
  public Vector leerReservas() {
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
                
                this.vector.add(reserva);
            }           
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    
  return vector;      
        
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
                vuelo.setFechaRegreso(element.getChild("FECHA_REGRESO").getText());
                vuelo.setFechaSalida(element.getChild("FECHA_SALIDA").getText());
                vuelo.setIdAvion(element.getChild("ID_AVION").getText());
                vuelo.setIdVuelo(element.getChild("ID_VUELO").getText());
                vuelo.setOrigen(element.getChild("ORIGEN").getText());
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

}
