/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
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
    private final String ip = "localhost";
    private final int puerto = 6001;
 
    public Cliente(){
        try {
            this.cliente = new Socket(this.ip, this.puerto);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setComunicacion(){
        try {
          
            DataOutputStream flujo_salida = new DataOutputStream(this.cliente.getOutputStream());
            DataInputStream flujo_entrada = new DataInputStream(this.cliente.getInputStream());
           
            // SERVIDOR PIDE LA LONGITUD DE LA LISTA AL CLIENTE.
            System.out.println(flujo_entrada.readUTF());
            Scanner entrada_longitud = new Scanner(System.in);
            int longitud = entrada_longitud.nextInt();
            flujo_salida.writeInt(longitud);
            
            // CLIENTE ENVIA CADA NUMERO ESTABLECIDO POR EL USUARIO.
            Scanner entrada = new Scanner(System.in);
            for(int i=0; i < longitud; i++){
             System.out.println("Inserte numero " + (i+1) + ": ");   
             flujo_salida.writeInt(entrada.nextInt());
            }
        
            // CLIENTE RECIBE CADA NUMERO, LOS COMPARA Y LOS MUESTRA.
            for(int z=0; z < longitud; z++){
              int num = flujo_entrada.readInt();
               
                if(num < 10){
                   System.out.println("Numero de la lista ( < 10), devuelto del servidor: " + num);
                }
                
                if(num > 10){
                   System.out.println("Numero de la lista ( > 10), devuelto del servidor: " + num);
                }  
            }
      
            
            // CLIENTE RECIBE EL NUMERO MAYOR Y MENOR DE LA LISTA.
            System.out.println("El numero mayor de la lista es: " + flujo_entrada.readInt());
           
            System.out.println("El numero menor de la lista es: " + flujo_entrada.readInt());
            
            
            flujo_salida.close();
            flujo_entrada.close();
            this.cliente.close();
        
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }



  

}
