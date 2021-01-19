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
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.err.println("Introduce nombre: ");
        Nombre nombre = new Nombre(entrada.nextLine());
        nombre.run();
    }

}

 