/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafam.ejemplourl2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.InflaterInputStream;

/**
 *
 * @author rafam
 */
public class Ejemplo2URL {
    public static void main(String[] args) {
        URL url = null;
          BufferedReader br;
            InputStream inputStream;
        try {
            url = new URL("https://www.marca.com/");
            try {
                inputStream = url.openStream();
                br = new BufferedReader(new InputStreamReader(inputStream));
                String inputLine;
                  while((inputLine = br.readLine()) != null){
                      System.out.println(inputLine);
                  }
                  br.close();
            } catch (IOException ex) {
                Logger.getLogger(Ejemplo2URL.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ejemplo2URL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
