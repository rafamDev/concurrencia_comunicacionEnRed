/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.ServerThread;

/**
 *
 * @author rafam
 */
public class Client {

    private Socket client;
   
    public Client(String localhost, int port) {
        try {
            this.client = new Socket(localhost,port);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setCommunication(){
        try {
            DataInputStream in = new DataInputStream(this.client.getInputStream());
            DataOutputStream out = new DataOutputStream(this.client.getOutputStream());
            Scanner scan = new Scanner(System.in);
            int number = 0;
            int randomNumber = in.readInt();
            while(true){
              System.out.println("Introduce number:");
              number = scan.nextInt();
              out.writeInt(number);
              if(number == randomNumber){
                 break;
              }
            }
            System.out.println("Server says -> " + in.readUTF());
            out.close();
            in.close();
            this.client.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
