/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author mautematico
 */
public class NoPieza extends Pieza {
//    public NoPieza(){
//        this(-1,-1);
//    }
//    public NoPieza(int x, int y){
//        Posicion pos = new Posicion();
//        pos.setPosicion(x, y);
//        setPosicion(pos);
//    }
    

    @Override
    public boolean[][] posicionesPosibles(int x,int y,Tablero tablero) {
        return new boolean[8][8]; 
    }
    @Override
    public boolean validarMovimiento(Posicion posicionInicial,Posicion posicionNueva, Tablero tablero){
        return false;
    }

    @Override
    public String getNombrePieza() {
        return "NoPieza";
    }

    @Override
    public ArrayList<Posicion> casillasIntermedias(Posicion posicionInicial, Posicion posicionNueva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char getCaracterPieza() {
        return 'N';
    }    

    @Override
    public int getValorPieza() {
        return 0;
    }
}
