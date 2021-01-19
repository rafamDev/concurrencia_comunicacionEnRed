/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.HiloServidor;

/**
 *
 * @author rafam
 */
public class Cliente {
    
    private DataInputStream flujo_entrada;
    private DataOutputStream flujo_salida;
    private Socket cliente = null;
    private String nombre;
   
    public Cliente(String nombre){
       try {
            this.nombre = nombre;
            this.cliente = new Socket("localhost", 6000);
            this.flujo_salida = new DataOutputStream(this.cliente.getOutputStream());
            this.flujo_entrada = new DataInputStream(this.cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setComunicacion(){
        try {
            String cadena = "";
            Scanner entrada = new Scanner(System.in);
            System.out.println("Sesion iniciada (" + this.nombre + ")");
            while(!cadena.trim().equals("*")){
                try {
                    System.out.println("Introduzca mensaje: ");
                    cadena = entrada.nextLine();
                    this.flujo_salida.writeUTF(cadena);
                    cadena = this.flujo_entrada.readUTF();
                     if(!cadena.trim().equals("*")){
                        System.out.println("Cadena en mayusculas: " + cadena);
                     }else{
                        System.out.println("Sesion cerrada");
                     }   
                } catch (IOException ex) {
                    Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.flujo_salida.close();
            this.flujo_entrada.close();
            this.cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
