/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author rafam
 */
public class MainClient {
    public static void main(String[] args) {
        Client client = new Client("localhost",6000);
        client.setCommunication();
    }
}
