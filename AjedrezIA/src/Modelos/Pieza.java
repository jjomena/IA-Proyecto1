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
   
   
   public boolean [][] piezasDelMismoEquipo(Tablero tablero){
        boolean [][] piezasDelMismoEquipo = new boolean [8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if ((tablero.getCasillas()[i][j].getPieza().isEquipo() == this.isEquipo()) && (tablero.getCasillas()[i][j].getPieza() instanceof NoPieza == false))
                    piezasDelMismoEquipo[i][j] = true;
            }    
        }
        return piezasDelMismoEquipo;
    }
   
     public boolean [][] piezasDelEquipoContrario(Tablero tablero){
        boolean [][] piezasDelEquipoContrario = new boolean [8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if ((tablero.getCasillas()[i][j].getPieza().isEquipo() != this.isEquipo()) && (tablero.getCasillas()[i][j].getPieza() instanceof NoPieza == false))
                    piezasDelEquipoContrario[i][j] = true;
            }    
        }
        return piezasDelEquipoContrario;
    }
   
    
     public boolean[][] movimientosPosibles(Tablero tablero) {
        boolean [][] movimientosPosibles = new boolean [8][8];
       
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (validarMovimiento(tablero.getCasillas()[i][j].getPieza().getPosicion(),tablero.getCasillas()[i][j].getPieza().getPosicion(), tablero))
                    movimientosPosibles[i][j] = true;                
            }
        } 
        
        for (int j = 7; j>=0; j--) {
            for (int i = 0; i<8; i++) {
                if(movimientosPosibles[i][j]){
                    System.out.print("|("+i+","+j+")|");
                    continue;
                }
                System.out.print("| |");
            }
            System.out.println("");
        }
   
        return movimientosPosibles;
    }
    
   
   public boolean mover(Posicion posicionNueva, Tablero tablero){
       if(movimientosPosibles(tablero)[posicionNueva.getX()][posicionNueva.getY()]){
           posicion.setX(posicionNueva.getX());
           posicion.setY(posicionNueva.getY());
           return true;
       }
       return false;
   }
//   public void imprimirPosicionesPosibles(){
//       boolean [][] posicionesPosibles = posicionesPosibles();
//                      
//       for (int j = 7; j>=0; j--) {
//           for (int i = 0; i<8; i++) {
//               if(posicionesPosibles[i][j]){
//                   System.out.print("|("+i+","+j+")|");
//                   continue;
//               }
//               System.out.print("| |");
//           }
//           System.out.println("");
//       }
//   }
}
