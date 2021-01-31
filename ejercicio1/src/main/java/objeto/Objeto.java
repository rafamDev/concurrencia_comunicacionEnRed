/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

import java.io.Serializable;

/**
 *
 * @author rafam
 */
public class Objeto implements Serializable{
    
    private String palabra;
    private String vocal;

    public Objeto(String palabra, String vocal) {
        this.palabra = palabra;
        this.vocal = vocal;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getVocal() {
        return vocal;
    }

    public void setVocal(String vocal) {
        this.vocal = vocal;
    }

    @Override
    public String toString() {
        return "Objeto{" + "palabra=" + palabra + ", vocal=" + vocal + '}';
    }

    
    
}
