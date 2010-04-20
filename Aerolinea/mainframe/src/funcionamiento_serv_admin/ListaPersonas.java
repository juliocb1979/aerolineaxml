package funcionamiento;

/**
 * @author Cristopher Castillo
 */
import java.io.Serializable;
import java.util.Vector;
/**
 * @see java.util.Vector
 * Esta clase genera un vector que contendra todos los objetos de tipo computadores,
 * es decir cada posicion del vector tendr� un elemento tipo objeto
 */
public class ListaPersonas implements Serializable
{
    private Vector personas;
	public ListaPersonas()
    {
		personas =  null;
	}
    

   /**
     * @return personas
     * Devuelve un vector con todos los clientes registrados en el XML
     **/
    public Vector getPersonas() {
        return personas;
    }

     /**
     * @param personas
     * Permite registrar un vector con todas los clientes que se mostraran en el XML
     **/
    public void setPersonas(Vector personas) {
        this.personas = personas;
    }
}