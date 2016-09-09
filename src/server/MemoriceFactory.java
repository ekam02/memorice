/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import Interface.MemoriceInterface;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author ESTUDIANTE
 */
public class MemoriceFactory extends Thread implements Runnable {

    private MemoriceInterface memorice = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private Socket socketCliente = null;
    private String vec[];
    private String retval, cmd;

    public MemoriceFactory(Socket socketCliente) {
        this.socketCliente = socketCliente;
        memorice = new MemoriceImpl();
        try {
            in = new DataInputStream(socketCliente.getInputStream());
            out = new DataOutputStream(socketCliente.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String demux(String msg) {
        vec = msg.split(" ");
        retval = "OK";

        try {
            if (vec[0].equals("NUEVO")) {
                memorice.juegoNuevo();
            } else if (vec[0].equals("CONTADOR")) {
                retval = "" + memorice.contador();
            } else if (vec[0].equals("CARTA")) {
                retval = "" + memorice.carta(Integer.parseInt(vec[1]));
            } else if (vec[0].equals("SALIR")) {
                retval = "LOGOUT";
            }else if (vec[0].equals("INICIARSESION")){
                retval = ""+memorice.iniciarSesion(vec[1]);
            } else if (vec[0].equals("VERCONECTADOS")){
                retval = memorice.verConectados();
            } else if (vec[0].equals("CERRARSESION")){
                retval = ""+memorice.cerrarSesion(vec[1]);
        }

        } catch (Exception e) {
        }

        // retval = eco.Mensaje(msg);*/

        return retval;
    }

    public void run() {

        cmd = "NEW";

        //System.out.println("run...");
        try {
            for (; !cmd.equals("SALIR"); out.flush()) {
                cmd = in.readUTF();
                System.out.println("Equipo "+socketCliente.getInetAddress().getHostName());
                System.out.println("llego mensaje "+cmd);
                // retval = demux(cmd);
                out.writeUTF(demux(cmd.toUpperCase()));
            }
            socketCliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
