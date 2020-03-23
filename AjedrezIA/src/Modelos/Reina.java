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
    int PosInicialX=0;
    int PosInicialY=0;
    //
    int PosFinalX=0;
    int PosFinalY=0;
   
    @Override
    public boolean[][] posicionesPosibles(int x,int y) {
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
    public boolean validarMovimiento(Posicion posicionInicial,Posicion posicionNueva, Tablero tablero){
        PosInicialX=posicionInicial.getX();
        PosInicialY=posicionInicial.getY();
        PosFinalX = posicionNueva.getX();
        PosFinalY = posicionNueva.getY();
         
         
           
       if(posicionesPosibles(PosInicialX,PosInicialY)[PosFinalX][PosFinalY]== false)
           return false;
        return true;
    }
    
    @Override
    public String getNombrePieza() {
        return "Reina";
    }

    @Override
    public ArrayList<Posicion> casillasIntermedias(Posicion posicionInicial, Posicion posicionNueva) {
        PosInicialX=posicionInicial.getX();
        PosInicialY=posicionInicial.getY();
        PosFinalX= posicionNueva.getX();
        PosFinalY= posicionNueva.getY();
        //Posicion posCambiante = new Posicion();
        ArrayList<Posicion> intermedias = new ArrayList<>();
        if(PosInicialX==PosFinalX){
            if(PosInicialY<PosFinalY){
                while(PosInicialY<PosFinalY){
                    Posicion posCambiante = new Posicion();
                    posCambiante.setX(PosInicialX);
                    posCambiante.setY(PosInicialY+1);
                    PosInicialY+=1;
                    intermedias.add(posCambiante);
                }
            }
            else{
                while(PosFinalY<PosInicialY){
                    Posicion posCambiante = new Posicion();
                    posCambiante.setX(PosInicialX);
                    posCambiante.setY(PosInicialY-1);
                    PosInicialY-=1;
                    intermedias.add(posCambiante);
                }
            }
        }
        else if(PosInicialY==PosFinalY){
            if(PosInicialX<PosFinalX){
                while(PosInicialX<PosFinalX){
                    Posicion posCambiante = new Posicion();
                    posCambiante.setX(PosInicialX+1);
                    posCambiante.setY(PosInicialY);
                    PosInicialX+=1;
                    intermedias.add(posCambiante);
                }
            }
            else{
                while(PosFinalX<PosInicialX){
                    Posicion posCambiante = new Posicion();
                    posCambiante.setX(PosInicialX-1);
                    posCambiante.setY(PosInicialY);
                    PosInicialX-=1;
                    intermedias.add(posCambiante);
                }
            }
        }
        else if(PosFinalX<PosInicialX && PosFinalY<PosInicialY){
            while(PosFinalX<PosInicialX){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX-1);
                posCambiante.setY(PosInicialY-1);
                PosInicialX-=1;
                PosInicialY-=1;
                intermedias.add(posCambiante);
            }
        }
        
        else if(PosFinalX<PosInicialX && PosInicialY<PosFinalY){
            while(PosInicialY<PosFinalY){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX-1);
                posCambiante.setY(PosInicialY+1);
                PosInicialX-=1;
                PosInicialY+=1;
                intermedias.add(posCambiante);
            }
        }
        else if(PosInicialX<PosFinalX && PosFinalY<PosInicialY){
            while(PosInicialX<PosFinalX){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX+1);
                posCambiante.setY(PosInicialY-1);
                PosInicialX+=1;
                PosInicialY-=1;
                intermedias.add(posCambiante);
            }
        }
        else if(PosInicialX<PosFinalX && PosInicialY<PosFinalY){
            while(PosInicialX<PosFinalX){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX+1);
                posCambiante.setY(PosInicialY+1);
                PosInicialX+=1;
                PosInicialY+=1;
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

