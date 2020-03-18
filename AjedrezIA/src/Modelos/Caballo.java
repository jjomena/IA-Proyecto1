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
public class Caballo extends Pieza {
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
                if (i == x+2){
                    if(j == y+1 || j == y-1)
                        posicionesPosibles[i][j] = true;
                }   
                if (i == x+1){
                    if(j == y+2 || j == y-2)
                        posicionesPosibles[i][j] = true;
                }
                if (i == x-1){
                    if(j == y+2 || j == y-2)
                        posicionesPosibles[i][j] = true;
                }
                if (i == x-2){
                    if(j == y+1 || j == y-1)
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
       x2= posicionNueva.getX();
       y2= posicionNueva.getY();
         
           
       if(posicionesPosibles()[x2][y2]== false)
           return false;
       
       else
           if (piezasDelMismoEquipo(tablero)[x2][y2])
                return false;
        return true;
    }

    @Override
    public String getNombrePieza() {
        return "Caballo";
    }
    
    public ArrayList<Posicion> casillasIntermedias(Posicion posicionInicial,Posicion posicionNueva){
        x=posicionInicial.getX();
        y=posicionInicial.getY();
        x2= posicionNueva.getX();
        y2= posicionNueva.getY();
        ArrayList<Posicion> intermedias = new ArrayList<>();
        if((x2<x) && (y2<y) && (x-x2==2)){
            while(x2<x){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x-1);
                posCambiante.setY(y);
                x-=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(x);
            posCambiante.setY(y-1);    

            intermedias.add(posCambiante);
        }
        
        else if((x2<x)&&(y<y2) && (x-x2==2)){
            while(x2<x){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x-1);
                posCambiante.setY(y);
                x-=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(x);
            posCambiante.setY(y+1);    

            intermedias.add(posCambiante);
        }
        else if((x<x2)&&(y2<y) && (x2-x==2)){
            while(x<x2){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x+1);
                posCambiante.setY(y);
                x+=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(x);
            posCambiante.setY(y-1);    

            intermedias.add(posCambiante);
        }
        else if((x<x2)&&(y<y2) && (x2-x==2)){
            while(x<x2){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x+1);
                posCambiante.setY(y);
                x+=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(x);
            posCambiante.setY(y+1);    

            intermedias.add(posCambiante);
        }
        
        else if((y<y2) &&(x2<x) &&(y2-y==2)){
            while(y<y2){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x);
                posCambiante.setY(y+1);
                y+=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(x-1);
            posCambiante.setY(y);
            
            intermedias.add(posCambiante);
        }
        
        else if((y<y2) &&(x<x2) && (y2-y==2)){
            while(y<y2){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x);
                posCambiante.setY(y+1);
                y+=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(x+1);
            posCambiante.setY(y);
            
            intermedias.add(posCambiante);
        }
        
        else if((y2<y) &&(x2<x) &&(y-y2==2)){
            while(y2<y){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x);
                posCambiante.setY(y-1);
                y-=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(x-1);
            posCambiante.setY(y);
            
            intermedias.add(posCambiante);
        }
        
        else if((y2<y) &&(x<x2) && (y-y2==2)){
            while(y2<y){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(x);
                posCambiante.setY(y-1);
                y-=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(x+1);
            posCambiante.setY(y);
            
            intermedias.add(posCambiante);
        }
        return intermedias;  
    }   

    @Override
    public char getCaracterPieza() {
        return 'C';
    }
}
