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
public class Alfil extends Pieza {
    int x=0;
    int y=0;
    //
    int x2=0;
    int y2=0;
    
    public Alfil(){
        super();
    }
    
    @Override
    public boolean[][] posicionesPosibles() {
        boolean [][] posicionesPosibles = new boolean [8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (i-x == j-y|| i-x == y-j )
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
           
           if(x1 - x2 == y1-y2)
               for(int i = minX + 1; i< maxX; i++)
                   if(tablero.getCasillas()[i][minY-minX + i].getPieza() instanceof NoPieza == false)
                       return false;
                  
           if(x1 - x2 == y2 - y1)
               for(int i = minX + 1; i< maxX; i++)
                   if(tablero.getCasillas()[i][maxX + minY -i].getPieza() instanceof NoPieza == false)
                       return false;
                   
           return true;
                   
    }
    
    
    
    @Override
    public boolean movimientoPosible(Posicion posicionInicial,Posicion posicionNueva, Tablero tablero){
        x=posicionInicial.getX();
        y=posicionInicial.getY();
        x2= posicionNueva.getX();
        y2= posicionNueva.getY();
          
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
        return "Alfil";
    }

    @Override
    public ArrayList<Posicion> casillasIntermedias(Posicion posicionInicial, Posicion posicionNueva) {
        x=posicionInicial.getX();
        y=posicionInicial.getY();
        x2= posicionNueva.getX();
        y2= posicionNueva.getY();
        Posicion posCambiante = new Posicion();
        ArrayList<Posicion> intermedias = new ArrayList<>();
        
        if(x2<x && y2<y){
            while(x2<x){
                posCambiante.setX(x-1);
                posCambiante.setY(y-1);
                x-=1;
                intermedias.add(posCambiante);
            }
        }
        
        else if(x2<x && y<y2){
            while(x2<x){
                posCambiante.setX(x-1);
                posCambiante.setY(y+1);
                x-=1;
                y+=1;
                x2+=1;
                intermedias.add(posCambiante);
            }
        }
        else if(x<x2 && y2<y){
            while(x<x2){
                posCambiante.setX(x+1);
                posCambiante.setY(y-1);
                x+=1;
                y-=1;
                x+=1;
                intermedias.add(posCambiante);
            }
        }
        else if(x<x2 && y<y2){
            while(x<x2){
                posCambiante.setX(x+1);
                posCambiante.setY(y+1);
                x+=1;
                intermedias.add(posCambiante);
            }
        }
        
        return intermedias;
    }
 
}
               
                
       
          
           
           
           
           
           
           
           
           
           
           
