/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafam.rrmfg_alumnos;

import com.rafam.rrmfg.pojo.Alumno;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rafam
 */
public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int puerto = 6008;
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket cliente = new Socket(host,puerto);
            Scanner entrada = new Scanner(System.in); 
            System.out.println("Introduce nombre: ");
            String nombre = entrada.nextLine();
            System.out.println("Introduce edad: ");
            int edad = entrada.nextInt();
            System.out.println("Introduce nota: ");
            int nota = entrada.nextInt();
               Alumno alumno = new Alumno(nombre, edad, nota);
               System.out.println("Alumno a enviar --> " + alumno.toString());
               ObjectOutputStream alumno_sale = new ObjectOutputStream(cliente.getOutputStream()); 
               alumno_sale.writeObject(alumno);
               System.out.println(alumno.toString() + " salio");
                  ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
                  Alumno alumno_recibido = (Alumno) inObjeto.readObject();
                  System.out.print("Alumno recibido en el cliente: " + alumno_recibido.toString());
        alumno_sale.close();
        inObjeto.close();
        cliente.close();
    }
}
