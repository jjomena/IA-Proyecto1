/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
//import  Modelos.NoPieza;
//import Modelos.Casilla;
/**
 *
 * @author actuaria
 */
public class Tablero{
    private Casilla [][] casillas;
        
    public Tablero(){
        casillas = new Casilla[8][8];
        for (int i=0; i<8; i++){
            for(int j=0;j<8;j++){
                casillas[i][j] = new Casilla();
            }
        }
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
    
}
