/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class Server {
    public static void main(String[] args) {
        setMultiThread();
    }
    private static void setMultiThread() {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server init");
            int randomNumber = generateRandomNumber(0, 10);
            System.err.println("RandomNumber: " + randomNumber);
            AtomicBoolean play = new AtomicBoolean(true);
            for(int i=0; i < 5; i++){
             while(play.get()){
              Socket client = new Socket();
              client = server.accept();
              ServerThread serverThread = new ServerThread(client,randomNumber,play);
              serverThread.start();
             }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static int generateRandomNumber(int min,int max){
        Random rand = new Random();
	return rand.nextInt((max - min) + 1) + min;
    }            
}
