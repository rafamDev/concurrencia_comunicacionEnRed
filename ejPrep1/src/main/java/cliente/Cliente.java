/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class Cliente {
   
   private Socket cliente;

    public Cliente(String host, int puerto) {
       try {
           this.cliente = new Socket(host, puerto);
       } catch (IOException ex) {
           Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
   public void setComunicacion(){
      try {
           DataOutputStream flujo_salida = new DataOutputStream(cliente.getOutputStream());
           int numeros [] = new int[7];
           Scanner entrada = new Scanner(System.in);
           for(int i = 0; i < numeros.length; i++){
               if(i < 5){
                   System.out.println("Introduce numero normal");
                   numeros[i] = entrada.nextInt();
                   flujo_salida.writeInt(numeros[i]);
               }else{
                   System.out.println("Introduce numero estrella");
                   numeros[i] = entrada.nextInt();
                   flujo_salida.writeInt(numeros[i]);
               }
            } 
            ObjectInputStream flujo_entrada = new ObjectInputStream(cliente.getInputStream());
            System.out.println("Boleto recibido -> " + flujo_entrada.readObject());
           
            flujo_salida.close();
            flujo_entrada.close();
            this.cliente.close();
        } catch (IOException ex) {
           Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) { 
           Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    } 
   
   
}
