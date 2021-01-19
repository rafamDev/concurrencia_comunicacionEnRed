/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class Servidor {
    
    private ServerSocket servidor;
    private final int puerto= 6001;
   
    public Servidor(){
        try {
            this.servidor = new ServerSocket(this.puerto);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setComunicacion(){
        try {
            Socket cliente = this.servidor.accept();
        
            DataOutputStream flujo_salida = new DataOutputStream(cliente.getOutputStream());
            DataInputStream flujo_entrada = new DataInputStream(cliente.getInputStream());
            
            // SERVIDOR PREGUNTA Y RECIBE LA LONGITUD DE LA LISTA.
            flujo_salida.writeUTF("Introduce longitud de la lista de numeros:");
            int longitud = flujo_entrada.readInt();
            System.err.println("Longitud de la lista de numeros es: " + longitud);
             
            int lista[] = new int[longitud];
            
            // SERVIDOR RECIBE DEL CLIENTE CADA NUMERO DE LA LISTA. 
            for(int i=0; i < lista.length; i++){
          
              lista[i] = flujo_entrada.readInt();
             
            }
            
            // SERVIDOR OBTIENE EL MAYOR Y EL MENOR DE LA LISTA.
            int menor = lista[0];
            int mayor = lista[0]; 
           
            for(int x=0; x < lista.length; x++){
            
               if(lista[x] > mayor){
                 mayor = lista[x];
               }
             
               if(lista[x] < menor){
                 menor = lista[x];
               }
            
            }
             
            // SERVIDOR ENVIA CADA NUMERO DE LA LISTA AL CLIENTE.
            for(int z= 0; z < lista.length; z++){
            
              flujo_salida.writeInt(lista[z]);
                    
            }  
            
            // SERVIDOR ENVIA EL NUMERO MAYOR Y MENOR AL CLIENTE.   
            flujo_salida.writeInt(mayor);
            flujo_salida.writeInt(menor);
            
            // SERVIDOR MUESTRA LA LISTA ENTERA.
            System.out.println(Arrays.toString(lista)); 
            
            
            flujo_entrada.close();
            flujo_salida.close();
            cliente.close();
            this.servidor.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
