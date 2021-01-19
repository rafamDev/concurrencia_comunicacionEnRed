/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class Cliente {
    
    public static void setCliente(){
        try {
            DatagramSocket clienteUDP = new DatagramSocket();
            final int puerto = 6000;
            InetAddress ip = InetAddress.getLocalHost();
            String mensaje = "cadena";
            byte mensaje_bytes [] = mensaje.getBytes();
            DatagramPacket paqute_envio = new DatagramPacket(mensaje_bytes, mensaje_bytes.length, ip, puerto);
            clienteUDP.send(paqute_envio);
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
