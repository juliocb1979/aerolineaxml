package comunicacion_rmi_mainframe;

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
    private IServidorRemotoMainframe obj2 = null;

    public IServidorRemotoMainframe ConexionRemota ()
    {
        ip = java.util.ResourceBundle.getBundle("configuracion").getString("ip");

        String puert = java.util.ResourceBundle.getBundle("configuracion").getString("puerto_rmi"); // Del archivo de propiedades le paso el parametro de servicio
        port = Integer.parseInt(puert);

        url = "//" + ip + ":" + port + "/Servidor";
        
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



//    @Override
//    public void finalize()
//    {
//        try
//        {
//          url = "//" + ip + ":" + port + "/Servidor";
//          Naming.unbind(url);
//          System.out.println("Servidor de Archivos finalizado");
//         }
//         catch (Exception e)
//         {
//            System.out.println("Error al detener servidor, causa: " + e.toString());
//         }
//    }

}

