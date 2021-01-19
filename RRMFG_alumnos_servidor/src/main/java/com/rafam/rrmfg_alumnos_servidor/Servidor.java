/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafam.rrmfg_alumnos_servidor;

import com.rafam.rrmfg.pojo.Alumno;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author rafam
 */
public class Servidor {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int num_puerto = 6008;
        ServerSocket servidor = new ServerSocket(num_puerto);
        System.out.println("Esperando cliente...");
        ArrayList<Alumno> lista_alumno = new ArrayList<Alumno>();
         while(true){
          Socket cliente = servidor.accept();
          System.out.println("Conexion aceptada");
          ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
          Alumno alumno = (Alumno) inObjeto.readObject();
          System.out.println("Alumno recibido: " + alumno.toString());
          lista_alumno.add(alumno);
            for(Alumno alumno_N : lista_alumno){
                System.out.println("Alumnos en lista: " + alumno_N.toString());
            }
           ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
           outObjeto.writeObject(alumno);  
           outObjeto.close(); 
           inObjeto.close();
           cliente.close();
       }
    }
}   