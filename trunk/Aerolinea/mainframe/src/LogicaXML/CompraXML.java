/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaXML;

import Clases.Compra;
import Clases.Persona;
import Clases.Vuelo;
 import org.jdom.Element;

/*
/**
 *
 * @author MANU
 */
public class CompraXML extends Element{
 public CompraXML(Compra c)
    {
          super("COMPRA");
        try{ 
        addContent(new Element("ID_OFICINA").setText(c.getIdOficina()));
        addContent(new Element("ID_CLIENTE").setText(c.getIdCliente())); 
        addContent(new Element("ID_VUELO").setText(c.getIdVuelo()));
        addContent(new Element("FECHA").setText(c.getFechaCompra()));
        
        }catch(Exception e){
         System.out.println("CLIENTE XML " + e);
         }
    }

}