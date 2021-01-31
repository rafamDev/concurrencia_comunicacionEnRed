/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class HiloServidor extends Thread{
    
    private Socket cliente;

    public HiloServidor(Socket cliente) {
        this.cliente = cliente;
    }
    
     public void setComunicacion(){
        try {
            DataInputStream flujo_entrada = new DataInputStream(cliente.getInputStream());
            System.out.println("Cliente -> " + flujo_entrada.readUTF());
            
            double acumulador = 0;
            int contador = 0;
             while(true){
                double numero = flujo_entrada.readDouble();
                if(numero != 0){
                    acumulador = acumulador + numero;
                    contador++;
                }else{
                   break;
                }
             }
            double media = (acumulador/contador);
            System.out.println("La media es: " + media);
            
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
