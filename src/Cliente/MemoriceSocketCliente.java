/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente;

import Interface.MemoriceInterface;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author ESTUDIANTE
 */
public class MemoriceSocketCliente implements MemoriceInterface{

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String mensaje;
    
  public MemoriceSocketCliente(String host, int port) {
      mensaje="";
        try{
            socket=new Socket(InetAddress.getByName(host), port);
            out=new DataOutputStream(socket.getOutputStream());
            in=new DataInputStream(socket.getInputStream());
            
        }catch(Exception e){
        
        }
  }
    
    public void juegoNuevo() {
       enviarMensaje("NUEVO");
    }

    public int carta(int i) {
        return Integer.parseInt(enviarMensaje("CARTA "+i));
    }

    public int contador() {
        return Integer.parseInt(enviarMensaje("CONTADOR"));
    }

    public void salir() {
         enviarMensaje("SALIR");
    }
    
    public String enviarMensaje(String msg){
                
              try {
                    System.out.println("Enviando "+msg);
                    out.writeUTF(msg);
                    out.flush();
                    msg = in.readUTF();
                    System.out.println("Recibiendo "+msg);
                    
           } catch (IOException e) {}
             
             return msg;
         }

   
    public boolean iniciarSesion(String nick) {
         return Boolean.parseBoolean(enviarMensaje("INICIAR SESION "+nick));
    }

   
    public boolean cerrarSesion(String nick) {
         return Boolean.parseBoolean(enviarMensaje("CERRAR SESION "+nick));
    }

    
    public String verConectados() {
         return enviarMensaje("VER CONECTADOS");
    }

    
    
    
}
