/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafam.clientemc1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;



/**
 *
 * @author rafam
 */
public class ClienteMC1 {
    
    public static void main(String[] args) throws Exception {
        int puerto = 12345;
        MulticastSocket ms = new MulticastSocket(puerto);
        InetAddress dir_grupo = InetAddress.getByName("224.0.0.1");
        //Todos los clientes se conectan a la misma ip, la del servidor.
        ms.joinGroup(dir_grupo);
        String mensaje = "";
        byte [] buf = new byte [1000];
            while(!mensaje.trim().equals("*")){
              DatagramPacket paquete = new DatagramPacket(buf,buf.length);
              ms.receive(paquete);
              mensaje = new String(paquete.getData());
              System.out.println("Recibo: " + mensaje.trim());
            }
        ms.leaveGroup(dir_grupo);
        ms.close();
        System.out.println("Socket cerrado");
    }
    

}
