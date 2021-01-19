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
            this.cliente = new Socket(ip,puerto);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setComunicacion(){
        try {
            DataOutputStream flujo_salida = new DataOutputStream(this.cliente.getOutputStream());
            DataInputStream flujo_entrada = new DataInputStream(this.cliente.getInputStream());
              Scanner entrada = new Scanner(System.in);
              double numero = 0;
                while(true){
                   System.out.println("Intruduzca numero: ");
                   numero = entrada.nextDouble();
                   if(numero != 0){
                      flujo_salida.writeDouble(numero);
                   }else{
                      flujo_salida.writeDouble(numero); 
                      break;
                   }
                }
            System.out.println("La media es: " + flujo_entrada.readDouble());    
            flujo_salida.close();
            flujo_entrada.close();
            this.cliente.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }





}
