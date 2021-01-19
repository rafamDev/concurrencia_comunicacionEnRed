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
public class Multiplicacion extends Thread {
       
    private int lista [];
    
    public Multiplicacion(int lista[]){
        this.lista = lista;
    }
    
    @Override
    public void run(){
       int suma = 0;
       int multiplicacion = 1;
        for(int i=0; i < this.lista.length; i++){
           suma = suma + this.lista[i];
           multiplicacion = multiplicacion * this.lista[i];
        }
        if(multiplicacion > 100){
            System.out.println("QUE NUMERO TAN GRANDE: " + multiplicacion);
        }else{
            System.out.println("MENUDO TIMO DE MULTIPLICACIÓN: " + multiplicacion);
        }
    }
}
