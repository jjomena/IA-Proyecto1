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
    int PosInicialX=0;
    int PosInicialY=0;
    //
    int PosFinalX=0;
    int PosFinalY=0;
    //
    int valorPieza=900;

    @Override
    public boolean[][] posicionesPosibles(int x,int y,Tablero tablero) {
        boolean [][] posicionesPosibles = new boolean [8][8];
        char equipo = this.isEquipo();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (i == x || i == x+1 || i == x-1){
                    if(j == y || j == y+1 || j == y-1){
                        posicionesPosibles[i][j] = tablero.getCasillas()[i][j].getPieza().getEquipo() != equipo;
                    }
                }                   
            }
        }
        posicionesPosibles[x][y] = false;
        return posicionesPosibles;
    }
    
    @Override
     public boolean validarMovimiento(Posicion posicionInicial,Posicion posicionNueva, Tablero tablero){
         PosInicialX=posicionInicial.getX();
         PosInicialY=posicionInicial.getY();
         PosFinalX = posicionNueva.getX();
         PosFinalY = posicionNueva.getY();
         
         System.out.println("Posicion Inicial:"+PosInicialX+":"+PosInicialY);
         System.out.println("Posicion Final:"+PosFinalX+":"+PosFinalY);
         
         
           
        return posicionesPosibles(PosInicialX,PosInicialY,tablero)[PosFinalX][PosFinalY];
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

    @Override
    public char getCaracterPieza() {
        return 'R';
    }

    @Override
    public int getValorPieza() {
        return valorPieza;
    }
    
    public ArrayList<Posicion>Jaque(int x,int y){
        ArrayList<Posicion> PosicionesJaque = new ArrayList<>();
        return PosicionesJaque; 
    }

}
