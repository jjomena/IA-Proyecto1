
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class Jugada {
    
    public Pieza pieza;
    public ArrayList<Posicion> movimientos;
    public Tablero tabblero;
    
    public Jugada(){}
    
    public Jugada(Pieza pieza,ArrayList<Posicion> movimientos,Tablero tablero){
        this.pieza = pieza;
        this.movimientos = movimientos;
        this.tabblero = tablero;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public ArrayList<Posicion> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Posicion> movimientos) {
        this.movimientos = movimientos;
    }

    public Tablero getTabblero() {
        return tabblero;
    }

    public void setTabblero(Tablero tabblero) {
        this.tabblero = tabblero;
    }
    
    
}
