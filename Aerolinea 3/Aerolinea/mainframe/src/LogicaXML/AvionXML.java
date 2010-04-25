/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaXML;

import Clases.Avion;
import Clases.Vuelo;
 import org.jdom.Element;

/*
/**
 *
 * @author MANU
 */
public class AvionXML extends Element{
 public AvionXML(Avion a)
    {
          super("AVION");
        try{ 
        addContent(new Element("ID_AVION").setText(a.getIdAvion()));
        addContent(new Element("MARCA").setText(a.getMarca())); 
        addContent(new Element("MODELO").setText(a.getModelo()));
        addContent(new Element("CAPACIDAD").setText(a.getCapacidad()));
        
        }catch(Exception e){
         System.out.println("AVION XML " + e);
         }
    }

}