/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaXML;

import Clases.Persona;
 import org.jdom.Element;

/*
/**
 *
 * @author MANU
 */
public class ClienteXML extends Element{
 public ClienteXML(Persona c)
    {
          super("CLIENTE");
        try{ 
        addContent(new Element("NOMBRE").setText(c.getNombre()));
        addContent(new Element("APELLIDO").setText(c.getApellido())); 
        addContent(new Element("ID_CLIENTE").setText(c.getCedula()));
        addContent(new Element("TELEFONO").setText(c.getTelefono()));
        addContent(new Element("ESTADO").setText(c.getEstado()));
        addContent(new Element("CIUDAD").setText(c.getCiudad()));
        addContent(new Element("ZONA").setText(c.getZona()));
        
        }catch(Exception e){
         System.out.println("CLIENTE XML " + e);
         }
    }

}
