package comunicacion_rmi;

import java.rmi.Naming;


/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

public class ConexionRemoto
{
    private String ip;
    private int port;
    private String url;
    private IServidorRemotoMainframe obj = null;

    public IServidorRemotoMainframe ConexionRemota ()
    {
        ip = java.util.ResourceBundle.getBundle("configuracion").getString("ip");

        String puert = java.util.ResourceBundle.getBundle("configuracion").getString("puerto_rmi"); // Del archivo de propiedades le paso el parametro de servicio
        port = Integer.parseInt(puert);

        url = "//" + "localhost:" + port + "/Servidor";
        
        try
        {
            // contactar el objeto remoto
            obj = (IServidorRemotoMainframe) Naming.lookup(url); //al servicio rmi da un vistazo al url que te estoy pasando
            System.out.println("Esta es la URL: //" + ip + ":" + port + "/Servidor");
        }
        catch(Exception e)
        {
             System.out.println (e);
        }

        return obj;
    }

}

