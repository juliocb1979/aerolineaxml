package funcionamiento;

/**
 * @author Cristopher Castillo
 */
import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Esta clase activa las funcionalidades del XML para ser leido a trav�s de la 
 * herramienta SAX
 */
public class LeerPersona  extends DefaultHandler
{
    private String elemento = null;
    private Attributes atributo = null;
    private static ListaPersonas listaPersonas;
    private Persona persona = null;
    private Vector<Persona> personas = null;
    
    public void startDocument() throws SAXException
    {
		listaPersonas = new ListaPersonas();
	}
        
    public void startElement(String uri, String localName, String rawName, Attributes atts) throws SAXException
    {
		
        elemento = rawName;
		if (elemento.equals("CLIENTE"))
        {
            persona = new Persona();
                        
            if (personas==null)
            {
				personas = new Vector<Persona>();
            }
		}
	}
	
	public void characters(char[] chars,int start,int length) 
	throws org.xml.sax.SAXException {
		
		String palabra = new String(chars, start, length).trim();
               
		if (palabra.equals("")) 
			return;
		
        if (elemento.equals("NOMBRE"))
        {
            persona.setNombre(palabra);
        }
        else if (elemento.equals("APELLIDO"))
        {
			persona.setApellido(palabra);
        }
        else if (elemento.equals("ID_CLIENTE"))
        {
			persona.getCedula();
        }
        else if (elemento.equals("TELEFONO"))
        {
			persona.setTelefono(elemento);
			personas.addElement(persona);
        }
	}
	
	@Override
	public void endDocument() throws SAXException
    {
		listaPersonas.setPersonas(personas);
	}
    
    /** 
     * Permite que el xml sea leido desde el servidor...
     */
    public static ListaPersonas getComputador(String uriXML)
    {
		try
        {
			LeerPersona profParser = new LeerPersona();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(uriXML, profParser);
		}
        catch (SAXException e)
        {
			e.printStackTrace();
		} 
        catch (IOException e)
        {
			e.printStackTrace();
		}
        catch (ParserConfigurationException e)
        {
			e.printStackTrace();
		}                
        return listaPersonas;
	}      
}