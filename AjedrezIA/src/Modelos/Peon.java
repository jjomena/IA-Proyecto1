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
public class Peon extends Pieza {
    int PosInicialX=0;
    int PosInicialY=0;
    //
    int PosFinalX=0;
    int PosFinalY=0;
    //
    int valorPieza=10;

    @Override
    public boolean[][] posicionesPosibles(int x,int y,Tablero tablero) {
        String nombrepieza;
        boolean[][] posicionesPosibles = new boolean[8][8];
        char equipo = this.isEquipo();
        if (equipo=='B') {
            if (x-1 >= 0) {
                nombrepieza = tablero.getCasillas()[x-1][y].getPieza().getNombrePieza();
                if("NoPieza".equals(nombrepieza)){
                    posicionesPosibles[x-1][y] = tablero.getCasillas()[x-1][y].getPieza().getEquipo() != equipo;
                }
                if(0 <= y-1){
                    nombrepieza = tablero.getCasillas()[x-1][y-1].getPieza().getNombrePieza();
                    if(!"NoPieza".equals(nombrepieza)){
                        posicionesPosibles[x-1][y-1] = tablero.getCasillas()[x-1][y-1].getPieza().getEquipo() != equipo;
                       
                    }
                }
                if(y+1 <= 7){
                    nombrepieza = tablero.getCasillas()[x-1][y+1].getPieza().getNombrePieza();
                    if(!"NoPieza".equals(nombrepieza)){
                        posicionesPosibles[x-1][y+1] = tablero.getCasillas()[x-1][y+1].getPieza().getEquipo() != equipo; 
                    }
                }
  
            }
        } else {
            if (x+1 <= 7) {
                nombrepieza = tablero.getCasillas()[x+1][y].getPieza().getNombrePieza();
                if("NoPieza".equals(nombrepieza)){
                    posicionesPosibles[x+1][y] = tablero.getCasillas()[x+1][y].getPieza().getEquipo() != equipo;
                }
                
                if(0 <= y-1){
                    nombrepieza = tablero.getCasillas()[x+1][y-1].getPieza().getNombrePieza();
                    if(!"NoPieza".equals(nombrepieza)){
                        posicionesPosibles[x+1][y-1] = tablero.getCasillas()[x+1][y-1].getPieza().getEquipo() != equipo;
                        
                    }
                }
                
                if(y+1 <= 7){
                    nombrepieza = tablero.getCasillas()[x+1][y+1].getPieza().getNombrePieza();
                    if(!"NoPieza".equals(nombrepieza)){
                        posicionesPosibles[x+1][y+1] = tablero.getCasillas()[x+1][y+1].getPieza().getEquipo() != equipo;
                    }
                }
            }
        }
        posicionesPosibles[x][y] = false;
        return posicionesPosibles;
    }

    boolean[][] posicionesParaComer() {
        boolean[][] posicionesParaComer = new boolean[8][8];
        int x = this.getPosicion().getX();
        int y = this.getPosicion().getY();
        char equipo = this.isEquipo();
        if (equipo=='B') {
            if (0 < y && y  <= 7) {
                if (0 <= x && x < 7) {
                    posicionesParaComer[x + 1][y - 1] = true;
                }
                if (0 < x && x  <= 7) {
                    posicionesParaComer[x - 1][y - 1] = true;
                }
            }
        } else {
           
             if (0 <= y  && y  < 7) {
                if (0 <= x && x < 7) {
                    posicionesParaComer[x + 1][y + 1] = true;
                }
                if (0 < x && x  <= 7) {
                    posicionesParaComer[x - 1][y + 1] = true;
                }
            }
        }

        return posicionesParaComer;
    }
    
     @Override
     public boolean validarMovimiento(Posicion posicionInicial,Posicion posicionNueva, Tablero tablero){
         PosInicialX=posicionInicial.getX();
         PosInicialY=posicionInicial.getY();
         PosFinalX = posicionNueva.getX();
         PosFinalY = posicionNueva.getY();
         
       return posicionesPosibles(PosInicialX,PosInicialY,tablero)[PosFinalX][PosFinalY] != false;
    }

    @Override
    public String getNombrePieza() {
        return "Peon";
    }

    @Override
    public ArrayList<Posicion> casillasIntermedias(Posicion posicionInicial, Posicion posicionNueva) {
        ArrayList<Posicion> intermedias = new ArrayList<>();
        intermedias.add(posicionNueva);
        return intermedias;
    }

    @Override
    public char getCaracterPieza() {
        return 'P';
    }

    @Override
    public int getValorPieza() {
        return valorPieza;
    }
}
