/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import objeto.Objeto;

/**
 *
 * @author rafam
 */
public class Cliente {
    
    private Socket cliente;

    public Cliente(String ip, int puerto) {
        try {
            this.cliente = new Socket(ip, puerto);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setComunicacion(){
        try {
            ObjectOutputStream flujo_salida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream flujo_entrada = new ObjectInputStream(cliente.getInputStream());
            DataInputStream flujo_entrada2 = new DataInputStream(cliente.getInputStream());
            
            Scanner entrada = new Scanner(System.in);
            System.out.println("Introduce palabra: ");
            String palabra = entrada.nextLine();
            System.out.println("Introduce vocal: ");
            String vocal = entrada.nextLine();
            
            Objeto objeto = new Objeto(palabra, vocal);
            flujo_salida.writeObject(objeto);
            
            Object objeto2 = (Objeto) flujo_entrada.readObject();
            System.out.println("Objeto recibido en el Cliente -> " + objeto2.toString() );
            System.out.println("Numero de vocales recibidas en el cliente -> " +  flujo_entrada2.readInt());
           
            flujo_entrada2.close();
            flujo_entrada.close();
            flujo_salida.close();
            cliente.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
