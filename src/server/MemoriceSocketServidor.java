/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Administrador
 *
 */
public class MemoriceSocketServidor {
        private ServerSocket socketServidor = null;
        private Socket socketCliente = null;
	private MemoriceFactory factory = null;
        //Constructor
        public MemoriceSocketServidor(int port)
   	{
   		try {
   			socketServidor = new ServerSocket(port);
   		} catch (IOException e) {}
         }
   	
        
        public void daemon(){
            while (true) {
                try {
                        System.out.println("Estoy esperando...");
                        socketCliente = socketServidor.accept();

                        System.out.println("encontre un cliente");
                        factory = new MemoriceFactory(socketCliente);
                        factory.start();
                } catch (IOException e) {}
            }
        }

public static void main(String arg[]){
    MemoriceSocketServidor server = new MemoriceSocketServidor(3000);
		server.daemon();
}

}
