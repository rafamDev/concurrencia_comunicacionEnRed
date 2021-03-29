/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class ServerThread extends Thread {

    private Socket client;
    private int randomNumber;
    private AtomicBoolean play;
   
    public ServerThread(Socket client, int randomNumber, AtomicBoolean play) {
       this.client = client;
       this.randomNumber = randomNumber;
       this.play = play;
    }

    @Override
    public void run() {
       setCommunication();
    }

    private void setCommunication() {
        try {
            DataInputStream in = new DataInputStream(this.client.getInputStream());
            DataOutputStream out = new DataOutputStream(this.client.getOutputStream());
            int number = 0;
            out.writeInt(this.randomNumber);
            while(play.get()){
              number = in.readInt();
              if(number == this.randomNumber){
                System.out.println("Player [" + this.client.toString() + "] is the winner!!"); 
                break;
              }
            }
            out.writeUTF("Good bye!!");
            out.close();
            in.close();
            this.client.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
          play.set(false);
        }
    }

}
