package comunicacion_sockets;

import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;



/**
 * @author Angelica Omaña
 * @author Mary Carrascal
 * @author Luis Figueras
 * @author Emmanuel Ortiz
 * @author Juan Escalante
 * @author Gustavo Briceño
 */

public class Servidor implements Runnable
{

//	 private  ServerSocket servidor;
//     private  Socket conexion;
     private int puerto;
     private static Thread miHilo;


    /**
     * Creates a new instance of Servidor
     */
        
    public Servidor(int p)
    {
        this.puerto = p;


    }

    public Servidor() {
       
    }

     
	/**
     * Este metodo se encarga de procesar cada nueva conexion que arrive
     * al servidor por lo que se inicia un nuevo hilo
     * GestorServidor para el manejo de las peticiones del Cliente.
     */
    private void procesarConexion(Socket connection) {

        miHilo= new Thread(new gestorServidor(connection));
        miHilo.start();
    }


    //--------------------------------------------------------------------//
    //      Implementacion de la interfaz Runnable
    //--------------------------------------------------------------------//
    /**
     * Metodo implementado para la recepcion de nuevas peticiones
     * del servidor. Se establece cual sera el puerto por donde se
     * recibiran las peticiones, y cada vez que llegue una nueva
     * peticion se ejecuta una llamada al metodo procesarConexion
     * para el tratamiento de la misma.
     */

	
        public void run() {
		ServerSocket serverSocket = null;
		
		Socket communicationSocket;
		
		try
                {
                serverSocket = new ServerSocket(puerto);
                //Ciclo infinito para atender peticiones de los clientes
                while(true)
                {
                    try
                    {
                        communicationSocket = serverSocket.accept();
                        procesarConexion(communicationSocket);
                        
                    }
                     catch (Exception e)
                    {
                        System.out.println("Error al tratar de aceptar la conexion");
                    }
                }
		}
            catch (IOException e)
            {
                System.out.println("El servidor no pudo ser iniciado, causa: "+e.getMessage());
		return;
            }
	}
	
	/**
	 *  Inicia un nuevo hilo de servicio
	 */
	public void iniciarServidor()
    {
            System.out.println("Servidor Iniciado");
            new Thread(this).start();
           
	}
	
	/**
	 * Inicia un nuevo servidor en modo Consola. 
	 * @param args argumentos de entrada
	 */
	public static void main(String args[]) throws IOException
    {

        String puert = java.util.ResourceBundle.getBundle("configuracion").getString("puerto_socket"); // Del archivo de propiedades le paso el parametro de servicio
        int port = Integer.parseInt(puert);
        Servidor  server = new Servidor(port);
        server.iniciarServidor();
	}

}