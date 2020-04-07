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
    int PosInicialX=0;
    int PosInicialY=0;
    //
    int PosFinalX=0;
    int PosFinalY=0;
    //
    int valorPieza=30;

    @Override
    public boolean[][] posicionesPosibles(int x,int y,Tablero tablero) {
        boolean [][] posicionesPosibles = new boolean [8][8];
        char equipo = this.isEquipo();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (i == x+2){
                    if(j == y+1 || j == y-1){
                        posicionesPosibles[i][j] = tablero.getCasillas()[i][j].getPieza().getEquipo() != equipo;
                    }
                }   
                if (i == x+1){
                    if(j == y+2 || j == y-2){
                        posicionesPosibles[i][j] = tablero.getCasillas()[i][j].getPieza().getEquipo() != equipo;
                    }
                }
                if (i == x-1){
                    if(j == y+2 || j == y-2){
                        posicionesPosibles[i][j] = tablero.getCasillas()[i][j].getPieza().getEquipo() != equipo;
                    }
                }
                if (i == x-2){
                    if(j == y+1 || j == y-1){
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
       PosFinalX= posicionNueva.getX();
       PosFinalY= posicionNueva.getY();
         
           
        return posicionesPosibles(PosInicialX,PosInicialY,tablero)[PosFinalX][PosFinalY] != false;
    }

    @Override
    public String getNombrePieza() {
        return "Caballo";
    }
    
    @Override
    public ArrayList<Posicion> casillasIntermedias(Posicion posicionInicial,Posicion posicionNueva){
        PosInicialX=posicionInicial.getX();
        PosInicialY=posicionInicial.getY();
        PosFinalX= posicionNueva.getX();
        PosFinalY= posicionNueva.getY();
        ArrayList<Posicion> intermedias = new ArrayList<>();
        if((PosFinalX<PosInicialX) && (PosFinalY<PosInicialY) && (PosInicialX-PosFinalX==2)){
            while(PosFinalX<PosInicialX){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX-1);
                posCambiante.setY(PosInicialY);
                PosInicialX-=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(PosInicialX);
            posCambiante.setY(PosInicialY-1);    

            intermedias.add(posCambiante);
        }
        
        else if((PosFinalX<PosInicialX)&&(PosInicialY<PosFinalY) && (PosInicialX-PosFinalX==2)){
            while(PosFinalX<PosInicialX){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX-1);
                posCambiante.setY(PosInicialY);
                PosInicialX-=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(PosInicialX);
            posCambiante.setY(PosInicialY+1);    

            intermedias.add(posCambiante);
        }
        else if((PosInicialX<PosFinalX)&&(PosFinalY<PosInicialY) && (PosFinalX-PosInicialX==2)){
            while(PosInicialX<PosFinalX){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX+1);
                posCambiante.setY(PosInicialY);
                PosInicialX+=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(PosInicialX);
            posCambiante.setY(PosInicialY-1);    

            intermedias.add(posCambiante);
        }
        else if((PosInicialX<PosFinalX)&&(PosInicialY<PosFinalY) && (PosFinalX-PosInicialX==2)){
            while(PosInicialX<PosFinalX){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX+1);
                posCambiante.setY(PosInicialY);
                PosInicialX+=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(PosInicialX);
            posCambiante.setY(PosInicialY+1);    

            intermedias.add(posCambiante);
        }
        
        else if((PosInicialY<PosFinalY) &&(PosFinalX<PosInicialX) &&(PosFinalY-PosInicialY==2)){
            while(PosInicialY<PosFinalY){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX);
                posCambiante.setY(PosInicialY+1);
                PosInicialY+=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(PosInicialX-1);
            posCambiante.setY(PosInicialY);
            
            intermedias.add(posCambiante);
        }
        
        else if((PosInicialY<PosFinalY) &&(PosInicialX<PosFinalX) && (PosFinalY-PosInicialY==2)){
            while(PosInicialY<PosFinalY){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX);
                posCambiante.setY(PosInicialY+1);
                PosInicialY+=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(PosInicialX+1);
            posCambiante.setY(PosInicialY);
            
            intermedias.add(posCambiante);
        }
        
        else if((PosFinalY<PosInicialY) &&(PosFinalX<PosInicialX) &&(PosInicialY-PosFinalY==2)){
            while(PosFinalY<PosInicialY){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX);
                posCambiante.setY(PosInicialY-1);
                PosInicialY-=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(PosInicialX-1);
            posCambiante.setY(PosInicialY);
            
            intermedias.add(posCambiante);
        }
        
        else if((PosFinalY<PosInicialY) &&(PosInicialX<PosFinalX) && (PosInicialY-PosFinalY==2)){
            while(PosFinalY<PosInicialY){
                Posicion posCambiante = new Posicion();
                posCambiante.setX(PosInicialX);
                posCambiante.setY(PosInicialY-1);
                PosInicialY-=1;
                intermedias.add(posCambiante);
            }
            Posicion posCambiante = new Posicion();
            posCambiante.setX(PosInicialX+1);
            posCambiante.setY(PosInicialY);
            
            intermedias.add(posCambiante);
        }
        return intermedias;  
    }   

    @Override
    public char getCaracterPieza() {
        return 'C';
    }

    @Override
    public int getValorPieza() {
        return valorPieza;
    }
    
}
