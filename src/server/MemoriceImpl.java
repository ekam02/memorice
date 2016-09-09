/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import Interface.MemoriceInterface;
import java.util.ArrayList;
/**
 *
 * 
 */
public class MemoriceImpl implements MemoriceInterface {

   private int numero,cont;
   ArrayList <String> usuarios; //declaracion del Arraylist
   
   
   public MemoriceImpl() {
        usuarios = new ArrayList();
    }
   
   public void juegoNuevo() {
        cont=0;
        numero=(int)(Math.random()*1000);
        System.out.println(numero);
    }

    public int carta(int i) {
        cont++;
        if(i<numero)
            return 1;
            
        else 
            return 0;
    }

    public int contador() {
        return cont;
    }

    public void salir() {
       
    }
    
    public boolean iniciarSesion(String nick) {
        //busqueda de usuarios iniciados para evitar duplicacion de datos
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).equals(nick))
                return false;
        }
        usuarios.add(nick);
        return true;
    }

    public boolean cerrarSesion(String nick) {
        return usuarios.remove(nick);
    }

    public String verConectados() {
        //concateno los nick en la respuesta
        String respuesta = "";
        for (int i = 0; i < usuarios.size(); i++) {
            respuesta = respuesta+"-"+usuarios.get(i);
        }
        return respuesta;
    }

    
    }

  
