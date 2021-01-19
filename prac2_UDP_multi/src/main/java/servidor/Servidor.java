/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */

//Servidor envia mensaje a cliente.
public class Servidor {
    
    public static void setServidor(){
        try {
            // multicastsocket que envia (NO PUERTO).
            MulticastSocket multicast = new MulticastSocket();
            
            // Puerto.
            int puerto = 12345;

             // InetAddress con la ip.
            InetAddress ip_cliente = InetAddress.getByName("224.0.0.1");
            
            // Scanner para preguntar.
            Scanner entrada = new Scanner(System.in);
            
            // Preparar el mensaje.
            String mensaje = "";
            
            
            while(true){
             System.out.println("Introduce nombres de ciudades: ");    
             mensaje = entrada.nextLine();
            
                //Paquete con mensaje en bytes, LONGITUD DEL MENSAJE STRING, ip y puerto. 
                DatagramPacket paquete_envio = new DatagramPacket(mensaje.getBytes(),mensaje.length(),ip_cliente,puerto);
                multicast.send(paquete_envio);
                
                if(mensaje.trim().equalsIgnoreCase("Barcelona")){
                  break;
                }
            }
            multicast.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
