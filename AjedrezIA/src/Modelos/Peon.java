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
    int x=0;
    int y=0;
    //
    int x2=0;
    int y2=0;

    @Override
    boolean[][] posicionesPosibles() {
        boolean[][] posicionesPosibles = new boolean[8][8];
        char equipo = this.isEquipo();
        if (equipo=='B') {
            if (0 < x && x  <= 7) {
                posicionesPosibles[x-1][y] = true;
            }
        } else {
            
            if (0 <= x  && x  < 7) {
                posicionesPosibles[x+1][y] = true;
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
     public boolean movimientoPosible(Posicion posicionInicial,Posicion posicionNueva, Tablero tablero){
         x=posicionInicial.getX();
         y=posicionInicial.getY();
         x2 = posicionNueva.getX();
         y2 = posicionNueva.getY();
         
           
       if(posicionesPosibles()[x2][y2] && (tablero.getCasillas()[x2][y2].getPieza() instanceof NoPieza))
           return true;
       
      if (posicionesParaComer()[x2][y2] && piezasDelEquipoContrario(tablero)[x2][y2])
           return true;
      if(this.isEquipo()=='N' && y==1 && y2 == 3 && y == x )
          return true;
      if(this.isEquipo()=='B' && y==6 && y2 == 4 && y == x )
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
