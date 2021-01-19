/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class Servidor {
    public static void setServidor(){
        
        try {
            DatagramSocket servidorUDP = new DatagramSocket(9876);
           
            
        while(true){
            
            byte bytes_mensaje_recibido [] = new byte[1024];
            
            DatagramPacket paquete_recibido = new DatagramPacket(bytes_mensaje_recibido,bytes_mensaje_recibido.length);
            servidorUDP.receive(paquete_recibido);
          
            InetAddress ip_cliente = paquete_recibido.getAddress();
            System.out.println("Desde la ip: " + ip_cliente);
            
            int puerto_cliente = paquete_recibido.getPort();
            System.out.println("Desde el puerto: " + puerto_cliente);
            
            String mensaje_recibido = new String(paquete_recibido.getData());
            System.out.println("Mensaje recibido: " + mensaje_recibido);
            
            
            if(mensaje_recibido.trim().equalsIgnoreCase("emilio")){
            
            byte bytes_envio_cliente [] = new byte[1024];
           
            String mensaje_envio = mensaje_recibido;
            bytes_envio_cliente = mensaje_envio.getBytes();
            DatagramPacket paquete_envio = new DatagramPacket(bytes_envio_cliente,bytes_envio_cliente.length,ip_cliente,puerto_cliente);
            servidorUDP.send(paquete_envio);
          
            break;
            
            }
            
        }
         
         servidorUDP.close();
        
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
