/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaXML;

import Clases.Persona;
import Clases.Vuelo;
import Clases.lugar;
 import org.jdom.Element;

/*
/**
 *
 * @author MANU
 */
public class LugarXML extends Element{
 public LugarXML(lugar l)
    {
          super("LUGAR");
        try{ 
        addContent(new Element("ID_LUGAR").setText(l.getIdlugar()));
        addContent(new Element("NOMBRE").setText(l.getNombreLugar())); 
        }catch(Exception e){
         System.out.println("LUGAR XML " + e);
         }
    }

}