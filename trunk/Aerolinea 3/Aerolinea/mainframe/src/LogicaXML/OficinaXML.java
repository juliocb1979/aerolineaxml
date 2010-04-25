/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaXML;

/**
 *
 * @author Juan Escalante
 */
import Clases.Oficina;
import org.jdom.Element;

public class OficinaXML extends Element {

    public OficinaXML(Oficina o)
    {
            super("OFICINA");
            try
            {
                addContent(new Element("ID_OFICINA").setText(o.getIdOficina()));
                addContent(new Element("NOMBRE").setText(o.getNombreOficina()));
                addContent(new Element("ESTADO").setText(o.getEstadoOficina()));
                addContent(new Element("CIUDAD").setText(o.getCiudadOficina()));
                addContent(new Element("ZONA").setText(o.getZonaOficina()));
            }
            catch(Exception e)
            {
                System.out.println("Oficina XML" + e);
            }
    }
}
