/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import objeto.Boleto;

/**
 *
 * @author rafam
 */
public class Servidor {
    private ServerSocket servidor;
 
    public Servidor(int puerto) {
        try {
            this.servidor = new ServerSocket(puerto);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setComunicacion(){
        try {
            Boleto boleto = new Boleto();
            int normales [] = new int[5];
            int estrella [] = new int [2];
            Socket cliente = this.servidor.accept();
            System.err.println("Comunicacion exitosa");
            DataInputStream flujo_entrada = new DataInputStream(cliente.getInputStream());
            for (int i= 0; i < normales.length; i++){
               normales[i] = flujo_entrada.readInt();
            }
            for (int j= 0; j < estrella.length; j++){
               estrella[j] = flujo_entrada.readInt();
            }
          
              boleto.setNormales(normales);
              boleto.setEstrella(estrella);
              ObjectOutputStream flujo_salida = new ObjectOutputStream(cliente.getOutputStream());
              flujo_salida.writeObject(boleto);
              System.out.println("Boleto enviado -> " + boleto.toString());
             
            flujo_salida.close();
            flujo_entrada.close();  
            cliente.close();
            this.servidor.close();
            System.err.println("Comunicacion finalizada");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
