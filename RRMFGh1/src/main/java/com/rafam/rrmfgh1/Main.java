/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafam.rrmfgh1;

import java.util.Scanner;

/**
 *
 * @author rafam
 */
public class Main {
    public static void main(String[] args) {
      Scanner entrada = new Scanner(System.in);
      System.out.println("Introduce numero 1"); 
      int num1 = entrada.nextInt();
      System.out.println("Introduce numero 2"); 
      int num2 = entrada.nextInt();
      System.out.println("Introduce numero 3"); 
      int num3 = entrada.nextInt();
      System.out.println("Introduce numero 4"); 
      int num4 = entrada.nextInt();
      System.out.println("Introduce numero 5"); 
      int num5 = entrada.nextInt();
     
      int lista[] = {num1,num2,num3,num4,num5};
      
      Multiplicacion multiplicacion = new Multiplicacion(lista); 
      multiplicacion.start();
     
      Mayor_Menor mn = new Mayor_Menor(lista);
      mn.start(); 
      
      Primo primo = new Primo(lista);
      primo.start();
      
    }
  
    
}
