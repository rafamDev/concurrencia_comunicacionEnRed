/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafam.rrmfgh1;

/**
 *
 * @author rafam
 */
public class Primo extends Thread {
    
    private int lista [];
    
    public Primo(int lista[]){
        this.lista = lista;
    }
    
    @Override
    public void run(){
     int suma = 0;
     for(int i=0; i < this.lista.length; i++){
         suma = suma + this.lista[i];
       }
       System.out.println("La suma es: " + suma);
       if(esPrimo(suma)){
           System.out.println("El resultado ded la suma es: " + suma + " (PRIMO)");
       }
    
    }
    
    private static boolean esPrimo(int numero){
      int contador = 2;
      boolean primo = true;
       while ((primo) && (contador!=numero)){
            if(numero % contador == 0)
               primo = false;
               contador++;
            if (numero%2==0){
               return false; 
            }   
       }
     return primo;
    }
}
