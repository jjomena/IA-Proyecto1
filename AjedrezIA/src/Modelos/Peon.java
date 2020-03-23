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

    @Override
    public boolean[][] posicionesPosibles(int x,int y,Tablero tablero) {
        String nombrepieza;
        boolean[][] posicionesPosibles = new boolean[8][8];
        char equipo = this.isEquipo();
        if (equipo=='B') {
            if (0 < x && x  <= 7) {
                nombrepieza = tablero.getCasillas()[x-1][y].getPieza().getNombrePieza();
                if("NoPieza".equals(nombrepieza)){
                    posicionesPosibles[x-1][y] = true;
                }
                nombrepieza = tablero.getCasillas()[x-1][y-1].getPieza().getNombrePieza();
                if(!"NoPieza".equals(nombrepieza)){
                    posicionesPosibles[x-1][y-1] = true;
                }
                nombrepieza = tablero.getCasillas()[x-1][y+1].getPieza().getNombrePieza();
                if(!"NoPieza".equals(nombrepieza)){
                    posicionesPosibles[x-1][y+1] = true;
                }
                
            }
        } else {
            if (0 <= x  && x  < 7) {
                nombrepieza = tablero.getCasillas()[x+1][y].getPieza().getNombrePieza();
                if("NoPieza".equals(nombrepieza)){
                    posicionesPosibles[x+1][y] = true;
                }
                nombrepieza = tablero.getCasillas()[x+1][y-1].getPieza().getNombrePieza();
                if(!"NoPieza".equals(nombrepieza)){
                    posicionesPosibles[x+1][y-1] = true;
                }
                nombrepieza = tablero.getCasillas()[x+1][y+1].getPieza().getNombrePieza();
                if(!"NoPieza".equals(nombrepieza)){
                    posicionesPosibles[x+1][y+1] = true;
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
         
           
       if(posicionesPosibles(PosInicialX,PosInicialY,tablero)[PosFinalX][PosFinalY] && (tablero.getCasillas()[PosFinalX][PosFinalY].getPieza() instanceof NoPieza))
           return true;
       
      if (posicionesParaComer()[PosFinalX][PosFinalY] && piezasDelEquipoContrario(tablero)[PosFinalX][PosFinalY])
           return true;
      if(this.isEquipo()=='N' && PosInicialY==1 && PosFinalY == 3 && PosInicialY == PosInicialX )
          return true;
      if(this.isEquipo()=='B' && PosInicialY==6 && PosFinalY == 4 && PosInicialY == PosInicialX )
          return true;
      
        return false;
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
}
