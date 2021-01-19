/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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
             final int puerto = 6000;
             DatagramSocket servidorUDP = new DatagramSocket(puerto);
             System.out.println("Conexion establecida");
               byte mensaje_bytes [] = new byte[1024];
               DatagramPacket paquete_recibido = new DatagramPacket(mensaje_bytes, mensaje_bytes.length);
               servidorUDP.receive(paquete_recibido);
               String mensaje = new String(paquete_recibido.getData());
               int longitud_mensaje = mensaje.trim().length();
               System.out.println("El numero de caracteres es: " + longitud_mensaje);
         
         } catch (SocketException ex) {
             Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
