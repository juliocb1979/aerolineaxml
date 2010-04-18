package oficinacomercial;

import comunicacion.ClienteConexion;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

public class Main
{

    private ObjectInputStream in=null; /** flujo para la lectura de los datos del cliente*/
    private ObjectOutputStream out=null;/** flujo para la escritura de datos hacia el cliente*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        GUI ventanaPrincipal =new GUI();
        ventanaPrincipal.setVisible(true);

        //----PRUEBA
        ClienteConexion co = new ClienteConexion();
        co.abrirConexion();
        co.enviar("Desde oficina comercial: Hola servidor administrativo");
        String a = ((String)co.recibir());
        System.out.println(a);
    }

}
