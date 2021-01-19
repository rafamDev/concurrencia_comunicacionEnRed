/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class Cliente {
    

    
    public static void setCliente(){
        try {
           
            //Creacion de clienteUDP
            DatagramSocket clienteUDP = new DatagramSocket();
            
            //bytes del Mensaje a enviar al servidor y recibir del servidor.
            byte bytes_mensaje_envio [] = new byte[1024];
           
            //Datos del servidor al que enviar el mensaje (IP y PUERTO).
            InetAddress ip_servidor = InetAddress.getLocalHost();
            
            int puerto = 9876;
           
            
            //Pedir datos
           Scanner entrada_numero = new Scanner(System.in);
           System.out.println("Introduce cantidad de nombres: ");
           int cantidad_nombres = entrada_numero.nextInt();
           
           String nombres[] = new String[cantidad_nombres];
           for(int i=0; i < cantidad_nombres; i++){
            System.out.println("Introduce nombre " + (i+1) + ": ");
            Scanner entrada_nombre = new Scanner(System.in);
            nombres[i] = entrada_nombre.nextLine();
         
            //Pasar a bytes lo introducido
            bytes_mensaje_envio = nombres[i].getBytes();
            
           //Enviar DATAGRAM al servidor.
            System.out.println("Enviando nombre con: " + bytes_mensaje_envio.length + " bytes, al servidor.");
            DatagramPacket envioUDP = new DatagramPacket(bytes_mensaje_envio, bytes_mensaje_envio.length, ip_servidor, puerto);
            clienteUDP.send(envioUDP);
          
           }
        
           byte bytes_mensaje_recibido [] = new byte[1024];
           
           DatagramPacket paquete_recibido = new DatagramPacket(bytes_mensaje_recibido, bytes_mensaje_envio.length);
           clienteUDP.receive(paquete_recibido);
           String mensaje_recibido = new String(paquete_recibido.getData());
           System.out.print(mensaje_recibido + " es el nombre clave que finaliza la comunicacion UDP");
           
          
           clienteUDP.close();
            
            
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

   
    
}
