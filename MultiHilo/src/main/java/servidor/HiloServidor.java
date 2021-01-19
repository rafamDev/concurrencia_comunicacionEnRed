/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class HiloServidor extends Thread{
    
    private DataInputStream flujo_entrada;
    private DataOutputStream flujo_salida;
    private Socket cliente = null;

    public HiloServidor(Socket cliente) {
        try {
            this.cliente = cliente;
            this.flujo_salida = new DataOutputStream(this.cliente.getOutputStream());
            this.flujo_entrada = new DataInputStream(this.cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public void setComunicacion(){
        try {
            String cadena = "";
            while(!cadena.trim().equals("*")){
                try {
                    System.out.println("Comunica con el cliente: " + cliente.toString());
                    cadena = flujo_entrada.readUTF();
                    flujo_salida.writeUTF(cadena.trim().toUpperCase());
                } catch (IOException ex) {
                    Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Fin de la comunicacion con: " + cliente.toString());
            flujo_salida.close();
            flujo_entrada.close();
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
       setComunicacion();
    }
   
    
}
