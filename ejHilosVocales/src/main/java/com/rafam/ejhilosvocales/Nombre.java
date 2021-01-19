/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafam.ejhilosvocales;

import java.util.Scanner;

/**
 *
 * @author rafam
 */
public class Nombre implements Runnable{

    private String nom_arroba;
    private int suma;
    private String nombre;
  
    public Nombre(String nombre){
      this.nombre = nombre;
    }
  
    @Override
    public void run() {
       char [] cadena = new char[this.nombre.length()];
       char [] vocal = {'a','e','i','o','u'};
       for(int i = 0; i < this.nombre.length(); i++) { 
          cadena[i] = this.nombre.charAt(i); 
          System.out.print((i+1));
            for(int j=0; j < vocal.length; j++){
                if(cadena[i] == vocal[j]){
                   cadena[i] = '@';
                }
             this.nom_arroba = new String(cadena); 
            }
        }
       System.out.println("\n"+ "Nombre con @ por cada vocal: " + this.nom_arroba);
       System.out.println("TOTAL DE CARACTERES: " + this.nombre.length());
    }  

}
