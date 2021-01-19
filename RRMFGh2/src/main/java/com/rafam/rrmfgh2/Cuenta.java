/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafam.rrmfgh2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class Cuenta extends Thread {
    
    private String nombre;
    
    public Cuenta(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public void run(){
        System.out.println("NOMBRE TAREA: " + this.nombre);
       
        for(int i=1; i < 4; i++){
            System.out.println(i);
        }
        System.out.println("zapatito ingles");
    }
}
