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
public abstract class Pieza {
    private Posicion posicion;
    private char equipo;
    

    public Pieza(){
        this('B');        
    }
    public Pieza(char equipo) {
        this.equipo = equipo;
        posicion = new Posicion();
    }
            

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public char isEquipo() {
        return equipo;
    }

    public void setEquipo(char equipo) {
        this.equipo = equipo;
    }
    
    public char getEquipo(){
        return equipo;
    }
    
   abstract public boolean[][] posicionesPosibles(int x,int y,Tablero tablero);
   abstract public boolean validarMovimiento(Posicion posicionInicio,Posicion posicionNueva, Tablero tablero);
   abstract public String getNombrePieza();
   abstract public char getCaracterPieza();
   abstract public int getValorPieza();
   abstract public ArrayList<Posicion> casillasIntermedias(Posicion posicionInicial,Posicion posicionNueva);
   
}
