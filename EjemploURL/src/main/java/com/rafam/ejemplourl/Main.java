/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafam.ejemplourl;

import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafam
 */
public class Main {
   
    public static void main(String args[]){
      URL url; 
        try {
            System.out.println("Constructor simple para una URL: ");
            url = new URL("https://www.marca.com/");
            visualizar(url);
            
            
            System.out.println("Constructor simple para una URL: ");
            url = new URL("http://localhost/Users/rafam/Desktop/webWork/webMcfit/home.html");
            visualizar(url);
            
            
            System.out.println("Constructor para protocolo + URL + directorio: ");
            url = new URL("https","www.marca.com","/futbol/" );
            visualizar(url);
            
            System.out.println("Constructor para protocolo + URL + puerto + directorio: ");
            url = new URL("https","www.marca.com",80,"/futbol/" );
            visualizar(url);
            
            System.out.println("Constructor para una url base y un directorio: ");
            URL url_base = new URL("https://www.marca.com/");
            url = new URL(url_base,"/futbol/atletico.html: ");
            visualizar(url);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    }

    private static void visualizar(URL url) {
      System.out.println("Url completa: " + url.toString());
       System.out.println("Protocolo: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
         System.out.println("Puerto: " + url.getPort());
          System.out.println("Fichero: " + url.getFile());
           System.out.println("Informacion de usuario: " + url.getUserInfo());
            System.out.println("Ruta: " + url.getPath());
             System.out.println("Autoridad: " + url.getAuthority());
              System.out.println("Consulta: " + url.getQuery());
    }
}