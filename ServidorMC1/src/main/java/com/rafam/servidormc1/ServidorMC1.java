/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafam.servidormc1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author rafam
 */
public class ServidorMC1 {
    public static void main(String[] args) throws IOException {
      BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
      MulticastSocket ms = new MulticastSocket();
        int puerto = 12345;
        InetAddress dir_grupo = InetAddress.getByName("224.0.0.1");
        String mensaje = "";
          while(!mensaje.trim().equals("*")){
              System.out.println("DATOS A ENVIAR AL GRUPO: ");
              mensaje = entrada.readLine();
              DatagramPacket paquete = new DatagramPacket(mensaje.getBytes(),mensaje.length(),dir_grupo,puerto);
              ms.send(paquete);
          }
       ms.close();
       System.out.println("Socket cerrado");
    }
}
