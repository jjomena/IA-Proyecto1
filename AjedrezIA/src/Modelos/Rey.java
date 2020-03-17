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
public class Rey extends Pieza {
    int x=0;
    int y=0;
    //
    int x2=0;
    int y2=0;

    @Override
    boolean[][] posicionesPosibles() {
        boolean [][] posicionesPosibles = new boolean [8][8];
        //int x = this.getPosicion().getX();
        //int y = this.getPosicion().getY();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (i == x || i == x+1 || i == x-1){
                    if(j == y || j == y+1 || j == y-1)
                        posicionesPosibles[i][j] = true;
                }                   
            }
        }
        posicionesPosibles[x][y] = false;
        return posicionesPosibles;
    }
    
    @Override
     public boolean movimientoPosible(Posicion posicionInicial,Posicion posicionNueva, Tablero tablero){
         x=posicionInicial.getX();
         y=posicionInicial.getY();
         x2 = posicionNueva.getX();
         y2 = posicionNueva.getY();
         
         System.out.println("Posicion Inicial:"+x+":"+y);
         System.out.println("Posicion Final:"+x2+":"+y2);
         
         
           
       if(!posicionesPosibles()[x2][y2]){
           return false;
       }
       if (piezasDelMismoEquipo(tablero)[x2][y2]){
           return false;
       }
        return true;
    }

    @Override
    public String getNombrePieza() {
        return "Rey";
    }

    @Override
    public ArrayList<Posicion> casillasIntermedias(Posicion posicionInicial, Posicion posicionNueva) {
        ArrayList<Posicion> intermedias = new ArrayList<>();
        intermedias.add(posicionNueva);
        return intermedias;  
    } 
}
