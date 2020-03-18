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
public class Reina extends Pieza {
    int x=0;
    int y=0;
    //
    int x2=0;
    int y2=0;
   
    @Override
    boolean[][] posicionesPosibles() {
        boolean [][] posicionesPosibles = new boolean [8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (i == x || j == y )
                    posicionesPosibles[i][j] = true;
                if (i-x == j-y|| i-x == y-j )
                    posicionesPosibles[i][j] = true;                
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
         
         
           
       if(posicionesPosibles()[x2][y2]== false)
           return false;
       
//       else
//           if (piezasDelMismoEquipo(tablero)[x2][y2])
//                return false;
//           else
//              if (casillasIntermediasVacias(posicionNueva, tablero) == false)
//                  return false;
        return true;
    }

    @Override
    public String getNombrePieza() {
        return "Reina";
    }

    @Override
    public ArrayList<Posicion> casillasIntermedias(Posicion posicionInicial, Posicion posicionNueva) {
        x=posicionInicial.getX();
        y=posicionInicial.getY();
        x2= posicionNueva.getX();
        y2= posicionNueva.getY();
        //Posicion posCambiante = new Posicion();
        ArrayList<Posicion> intermedias = new ArrayList<>();
        if(x==x2){
            if(y<y2){
                while(y<y2){
                    Posicion posCambiante = new Posicion();
                    posCambiante.setX(x);
                    posCambiante.setY(y+1);
                    y+=1;
                    intermedias.add(posCambiante);
                }
            }
            else{
                while(y2<y){
                    Posicion posCambiante = new Posicion();
                    posCambiante.setX(x);
                    posCambiante.setY(y-1);
                    y-=1;
                    intermedias.add(posCambiante);
                }
            }
        }
        else if(y==y2){
            if(x<x2){
                while(x<x2){
                    Posicion posCambiante = new Posicion();
                    posCambiante.setX(x+1);
                    posCambiante.setY(y);
                    x+=1;
                    intermedias.add(posCambiante);
                }
            }
            else{
                while(x2<x){
                    Posicion posCambiante = new Posicion();
                    posCambiante.setX(x-1);
                    posCambiante.setY(y);
                    x-=1;
                    intermedias.add(posCambiante);
                }
            }
        }
        else if(x2<x && y2<y){
            while(x2<x){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x-1);
                posCambiante.setY(y-1);
                x-=1;
                y-=1;
                intermedias.add(posCambiante);
            }
        }
        
        else if(x2<x && y<y2){
            while(y<y2){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x-1);
                posCambiante.setY(y+1);
                x-=1;
                y+=1;
                intermedias.add(posCambiante);
            }
        }
        else if(x<x2 && y2<y){
            while(x<x2){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x+1);
                posCambiante.setY(y-1);
                x+=1;
                y-=1;
                intermedias.add(posCambiante);
            }
        }
        else if(x<x2 && y<y2){
            while(x<x2){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x+1);
                posCambiante.setY(y+1);
                x+=1;
                y+=1;
                intermedias.add(posCambiante);
            }
        }
        return intermedias;
    }

    @Override
    public char getCaracterPieza() {
        return 'D';
    }
}

