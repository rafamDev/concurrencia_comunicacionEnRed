/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class HiloServidor extends Thread {
    
    private Socket cliente;

    public HiloServidor(Socket cliente) {
        this.cliente = cliente;
    }
    public void setComunicacion(){
        try {
            DataOutputStream flujo_salida = new DataOutputStream(cliente.getOutputStream());
            DataInputStream flujo_entrada = new DataInputStream(cliente.getInputStream());
            int numero = 0;
                while(true){
                    numero = flujo_entrada.readInt();
                      if(numero != 0){
                         flujo_salida.writeInt(numero);
                      }else{
                         break;
                      }
               }  
               flujo_salida.writeUTF("Servidor dice -> Adios");
               System.out.println("IP cliente: " + cliente.getInetAddress());  
               System.out.println("Cliente desconectado: " + cliente.toString());
             
             flujo_salida.close();
             flujo_entrada.close();
             cliente.close();
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        setComunicacion();
    }

}
