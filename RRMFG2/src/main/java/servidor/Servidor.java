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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class Servidor {
    private ServerSocket servidor;
    private final int puerto = 6001;
    
    public Servidor(){
        try {
            this.servidor = new ServerSocket(puerto);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setComunicacion(){
        try {
            Socket cliente = this.servidor.accept();
            DataInputStream flujo_entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(cliente.getOutputStream());
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
            flujo_salida.writeDouble(media);
            flujo_salida.close();
            flujo_entrada.close();
            cliente.close();
            this.servidor.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
