/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class Servidor {
      public static void main(String[] args) {
       ejecucion();
    }
     private static void ejecucion(){
          try {
            ServerSocket servidor = new ServerSocket(6000);
            System.out.println("Servidor iniciado");
            
            for(int i=0; i < 3; i++){
                
                Socket cliente = new Socket();
                
                cliente = servidor.accept();
                
                HiloServidor hilo = new HiloServidor(cliente);
                
                hilo.start();
            }    
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
