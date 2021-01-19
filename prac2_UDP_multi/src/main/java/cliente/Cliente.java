/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */

// Cliente recibe mensaje del servidor.
public class Cliente {
    
    public static void setCliente(){
        try {
            
            // MultiCastsocket que recibe con puerto.
            int puerto = 12345;
            MulticastSocket multisocket = new MulticastSocket(puerto);
           
            // Ip con InetAdress.getByName("ip");
            InetAddress ip_servidor = InetAddress.getByName("224.0.0.1");
           
            // MulticastSocket se une al grupo al que le pasa la ip.
            multisocket.joinGroup(ip_servidor);
            
            // String para preparar el mensaje.
            String bytesToString = "";
            // Bytes para recibir el mensaje.
            byte bytes_mensaje_recibido [] = new byte[1024];
            
            
            while(true){
            
                // DatagramPacket para recibir el mensaje dentro del paqute, con bytes y su longitud.
                DatagramPacket paquete_recibido = new DatagramPacket(bytes_mensaje_recibido,bytes_mensaje_recibido.length);
                multisocket.receive(paquete_recibido);
                
                // Parsear el datagarmpachet con el getData a String y mostrarlo.
                bytesToString = new String(paquete_recibido.getData());
                System.err.println("La ciudad elegida es: " + bytesToString.trim());
                
                 if(bytesToString.trim().equalsIgnoreCase("Barcelona")){
                  break;
                }
                
            }
            
            // Salir del grupo
            multisocket.leaveGroup(ip_servidor);
           
            multisocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
