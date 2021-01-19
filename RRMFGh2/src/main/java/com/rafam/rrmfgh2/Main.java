/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafam.rrmfgh2;

/**
 *
 * @author rafam
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cuenta c = new Cuenta("TAREA 1");
        c.start();
        c.join();
        
        Cuenta c2 = new Cuenta("TAREA 2");
        c2.start();
        c2.join();
        
        Cuenta c3 = new Cuenta("TAREA 3");
        c3.start();
        c3.join();
        
        Cuenta c4 = new Cuenta("TAREA 4");
        c4.start();
        c4.join();
        
        Cuenta c5 = new Cuenta("TAREA 5");
        c5.start();
       
    }
}
