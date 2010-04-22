/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaXML;

import Clases.Persona;
import Clases.Vuelo;
 import org.jdom.Element;

/*
/**
 *
 * @author MANU
 */
public class VueloXML extends Element{
 public VueloXML(Vuelo v)
    {
          super("CLIENTE");
        try{ 
        addContent(new Element("ID_VUELO").setText(v.getIdVuelo()));
        addContent(new Element("ID_AVION").setText(v.getIdAvion())); 
        addContent(new Element("ORIGEN").setText(v.getOrigen()));
        addContent(new Element("DESTINO").setText(v.getDestino()));
        addContent(new Element("FECHA_SALIDA").setText(v.getFechaSalida()));
        addContent(new Element("FECHA_REGRESO").setText(v.getFechaRegreso()));
        
        }catch(Exception e){
         System.out.println("CLIENTE XML " + e);
         }
    }

}