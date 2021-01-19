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
public class Mayor_Menor extends Thread{
     
    private int lista [];
    
    public Mayor_Menor(int lista[]){
        this.lista = lista;
    }
    
    @Override
    public void run(){
      int numMenor = this.lista[0];
      int numMayor = this.lista[0];
        for(int i=1; i < this.lista.length; i++){
              if(this.lista[i] > numMayor){
                 numMayor = this.lista[i];
              }
              if(this.lista[i] < numMenor){
                 numMenor = this.lista[i];
              }
        }
     System.out.println("El numero mayor es: " + numMayor); 
     System.out.println("El numero menor es: " + numMenor); 
    }
}
