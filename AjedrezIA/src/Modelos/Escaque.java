/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Modelos.NoPieza;
import Modelos.Pieza;

/**
 *
 * @author actuaria
 */
public class Escaque {
    private boolean color;
    private Pieza pieza;
    
    public Escaque(){
        pieza = new NoPieza();
    }
    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    
    
    
}
