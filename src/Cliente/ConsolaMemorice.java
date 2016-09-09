/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente;
import Interface.MemoriceInterface;
import java.io.*;

/**
 *
 * @author Johan
 */
public class ConsolaMemorice {


   	MemoriceInterface memorice;
    BufferedReader teclado;

    public ConsolaMemorice()
    {
        memorice = new MemoriceSocketCliente("172.16.8.158", 3000);
        teclado = null;

        run();
    }



    public void run()
    {
        String linea = "";

        teclado = new BufferedReader(new InputStreamReader(System.in));

        memorice.juegoNuevo();
        while(!linea.equals("salir"))
        {
            System.out.print("nuevo | salir | numero ? ");
            try
            {
                linea = teclado.readLine();
                //System.out.println("leyo de teclado " + linea);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            if(linea.equals("nuevo"))
                memorice.juegoNuevo();
            else
            if(linea.equals("salir"))
            {
                System.out.println("bye...");
                memorice.salir();
            } else
            {
                
                int result = 0;
                try{
                result=memorice.carta(Integer.parseInt(linea));
                if(result == 0)
                {
                    System.out.println("ACERTO EN " + memorice.contador() + " PUNTAJE");
                    memorice.juegoNuevo();
                } else
                if(result == 1)
                    System.out.println("Lo siento, Acabo tu turno!! " + memorice.contador() + "es tu puntaje");
                
                }
                catch(NumberFormatException e){
                    System.out.println("No es ninguna de las opciones");
                }
             }
        }
    }

    public static void main(String args[])
    {
        ConsolaMemorice cliente = new ConsolaMemorice();
    }



}
