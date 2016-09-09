/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Administrador
 */
public interface MemoriceInterface {
   
    public void juegoNuevo();
    public int carta(int i);
    public int contador();
    public void salir();
    public boolean iniciarSesion(String nick);
    public boolean cerrarSesion(String nick);
    public String verConectados();
 
}
