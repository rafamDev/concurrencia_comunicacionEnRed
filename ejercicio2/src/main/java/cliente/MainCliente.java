/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author rafam
 */
public class MainCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("localhost",6000);
        cliente.setComunicacion();
    }
}
