/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaXML;

import Clases.Persona;
import Clases.Reserva;
 import org.jdom.Element;

/*
/**
 *
 * @author MANU
 */
public class ReservaXML extends Element{
 public ReservaXML(Reserva r)
    {
          super("RESERVA");
        try{ 
        addContent(new Element("ID_RESERVA").setText(r.getIdReserva()));
        addContent(new Element("ID_VUELO").setText(r.getIdVuelo())); 
        addContent(new Element("ID_CLIENTE").setText(r.getIdCliente()));
        addContent(new Element("FECHA").setText(r.getFechaReserva()));
        addContent(new Element("FECHA_CADUCACION").setText(r.getFechaCaduca()));
        addContent(new Element("STATUS").setText(r.getStatus()));
        
        }catch(Exception e){
         System.out.println("RESERVA XML " + e);
         }
    }

}