/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class Cliente {
    
    private Socket cliente;
    
    public Cliente(String ip, int puerto){
        try {
            cliente = new Socket(ip,puerto);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setComunicacion(){
        try {
            DataOutputStream flujo_salida = new DataOutputStream(cliente.getOutputStream());
            DataInputStream flujo_entrada = new DataInputStream(cliente.getInputStream());
            Scanner entrada = new Scanner(System.in);
            int numero = 0;
            ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
              while(true){
                  System.out.println("Introduce numero: ");
                  numero = entrada.nextInt();
                  //Añado cada numero introducido en una lista dinámica, ya que ne se sabe cuantos numros introducirá el usuario.
                  listaNumeros.add(new Integer(numero));
                    if(numero != 0){
                       flujo_salida.writeInt(numero);
                       System.out.println("Numero recibido desde el servidor -> " + flujo_entrada.readInt());
                   }else{
                       flujo_salida.writeInt(numero);
                       break;
                   }
              }  
             //Obtengo el mayor de la lista. 
             System.out.println("Numero mayor: " + Collections.max(listaNumeros));
             //Obtengo el menor de la lista.
             System.out.println("Numero menor: " + Collections.min(listaNumeros));  
             System.out.println(flujo_entrada.readUTF());
             flujo_salida.close();
             flujo_entrada.close();
             cliente.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "cliente=" + cliente + '}';
    }
    
    
}
