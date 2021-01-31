/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rafam
 */
public class Boleto implements Serializable {
   
   private int [] normales;
   private int [] estrella;

    public Boleto(){}

    public int[] getNormales() {
        return normales;
    }

    public void setNormales(int[] normales) {
       this.normales = normales;
    }

    public int[] getEstrella() {
        return estrella;
    }

    public void setEstrella(int[] estrella) {
        this.estrella = estrella;
    }

    @Override
    public String toString() {
        return "Boleto{" + "normales=" + Arrays.toString(normales) + ", estrella=" +  Arrays.toString(estrella) + '}';
    }

}
