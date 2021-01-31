/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.Size2DSyntax;
import objeto.Objeto;

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
            Socket cliente = servidor.accept();
            System.out.println("Conexion establecida");
            ObjectInputStream flujo_entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream flujo_salida = new ObjectOutputStream(cliente.getOutputStream());
            DataOutputStream flujo_salida2 = new DataOutputStream(cliente.getOutputStream());
            
            Objeto objeto = (Objeto) flujo_entrada.readObject();
            System.out.println("Objeto recibido en el servidor -> " + objeto.toString());
            flujo_salida.writeObject(objeto);
            
            String palabra = objeto.getPalabra();
            String vocal = objeto.getVocal();
            
            //Paso la vocal a un array.
            char vocalArray [] = vocal.toCharArray();
            //Creo un contador para contar vocales.
            int contador = 0;
              //Recorro la palabra.
              for(int i=0; i < palabra.length(); i++){
                 //Con el metodo charAt() obtengo la letra de la palabra pasandole la posicion de la letra.
                 //Almaceno en un char cada letra de la la palabra.
                 char cadaVocal = palabra.charAt(i);
                  // (1) Comparo si hay una vocal en la palabra.
                  if(cadaVocal == 'a' || cadaVocal == 'e' || cadaVocal == 'i' || cadaVocal == 'o' || cadaVocal == 'u'){
                     // (2) Comparo si es igual a la vocal introducida.
                     if(cadaVocal == vocalArray[0]){
                        //Si es asi, cuento (n+1).
                        contador++;
                     }
                  }
              }
              flujo_salida2.writeInt(contador);
              
            flujo_salida2.close();
            flujo_salida.close();
            flujo_entrada.close();
            cliente.close();
            servidor.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
