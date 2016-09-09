/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Interface.MemoriceInterface;

/**
 *
 * @author Administrador
 */
public class MemoriceHiloCliente extends Thread implements Runnable {
    
    MemoriceInterface m;
    MemoriceVentana ventana;

    public MemoriceHiloCliente(MemoriceInterface m, MemoriceVentana ventana) {
        this.m = m;
        this.ventana = ventana;
    }

       public void run(){
       
       while(true){
           m.verConectados();
           ventana.actualizarConectados(m.verConectados());
               try {
                   sleep(500);
               } catch (InterruptedException ex) {
                    System.out.println("Error en el hilo:"+ ex.getMessage());
               }
           
       }
   } 
    
}
