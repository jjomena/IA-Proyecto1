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
public class Torre extends Pieza {
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
                if (i == x || j == y )
                    posicionesPosibles[i][j] = true;
                                
            }
        }
        posicionesPosibles[x][y] = false;
        return posicionesPosibles;
    }
    
    
    private boolean casillasIntermediasVacias(Posicion posicionNueva, Tablero tablero) {
           int x1 = getPosicion().getX();
           int y1 = getPosicion().getY();
           int x2 = posicionNueva.getX();
           int y2 = posicionNueva.getY();
           int minX = Math.min(x1, x2);
           int maxX = Math.max(x1, x2);
           int minY = Math.min(y1,y2);
           int maxY = Math.max(y1,y2);
           
           if(x1 == x2)
               for(int i = minY + 1; i< maxY; i++)
                   if(tablero.getCasillas()[x1][i].getPieza() instanceof NoPieza == false)
                       return false;
                  
           if(y1 == y2)
               for(int i = minX + 1; i< maxX; i++)
                   if(tablero.getCasillas()[i][y1].getPieza() instanceof NoPieza == false)
                       return false;
                   
           return true;
                   
    }
    
    
    
    @Override
    public boolean movimientoPosible(Posicion posicionInicial,Posicion posicionNueva, Tablero tablero){
          x=posicionInicial.getX();
          y=posicionInicial.getY();
          x2 = posicionNueva.getX();
          y2 = posicionNueva.getY();
         
           
       if(posicionesPosibles()[x2][y2]== false)
           return false;
       
       else
           if (piezasDelMismoEquipo(tablero)[x2][y2])
                return false;
           else
              if (casillasIntermediasVacias(posicionNueva, tablero) == false)
                  return false;
        return true;
    }

    @Override
    public String getNombrePieza() {
        return "Torre";
    }

    @Override
    public ArrayList<Posicion> casillasIntermedias(Posicion posicionInicial, Posicion posicionNueva) {
        x=posicionInicial.getX();
        y=posicionInicial.getY();
        x2= posicionNueva.getX();
        y2= posicionNueva.getY();
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
        return intermedias;
    }  
}
