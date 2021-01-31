/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author rafam
 */
public class ServidorMain {
    public static void main(String[] args) {
        Servidor servidor = new Servidor(6000);
        servidor.setComunicacion();
    }
}
