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
    //
    int valorPieza=90;
   
    @Override
    public boolean[][] posicionesPosibles(int x,int y,Tablero tablero) {
        boolean [][] posicionesPosibles = new boolean [8][8];
        String nombrepieza;
        boolean estado=true;
        posicionesPosibles[x][y] = false;
        estado=true;
        char equipo = this.isEquipo();
        int iterX = x;
        int iterY = y-1;
        while(iterY>=0){        
            nombrepieza = tablero.getCasillas()[iterX][iterY].getPieza().getNombrePieza();
            if(tablero.getCasillas()[iterX][iterY].getPieza().getEquipo() == equipo ){
                estado = false;
            }
            posicionesPosibles[iterX][iterY] = estado;
            if(!"NoPieza".equals(nombrepieza)){
                estado = false;
            }
            iterY-=1;
        }
        estado=true;
        iterX = x;
        iterY = y+1;
        while(iterY<=7){        
            nombrepieza = tablero.getCasillas()[iterX][iterY].getPieza().getNombrePieza();
            if(tablero.getCasillas()[iterX][iterY].getPieza().getEquipo() == equipo ){
                estado = false;
            }
            posicionesPosibles[iterX][iterY] = estado;
            if(!"NoPieza".equals(nombrepieza)){
                estado = false;
            }
            iterY+=1;
        }
        estado=true;
        iterX = x-1;
        iterY = y;
        while(iterX>=0){        
            nombrepieza = tablero.getCasillas()[iterX][iterY].getPieza().getNombrePieza();
            if(tablero.getCasillas()[iterX][iterY].getPieza().getEquipo() == equipo ){
                estado = false;
            }
            posicionesPosibles[iterX][iterY] = estado;
            if(!"NoPieza".equals(nombrepieza)){
                estado = false;
            }
            iterX-=1;
        }
        estado=true;
        iterX = x+1;
        iterY = y;
        while(iterX<=7){        
            nombrepieza = tablero.getCasillas()[iterX][iterY].getPieza().getNombrePieza();
            if(tablero.getCasillas()[iterX][iterY].getPieza().getEquipo() == equipo ){
                estado = false;
            }
            posicionesPosibles[iterX][iterY] = estado;
            if(!"NoPieza".equals(nombrepieza)){
                estado = false;
            }
            iterX+=1;
        }
        estado=true;
        iterX = x-1;
        iterY = y-1;
        while((iterX>=0) && (iterY>=0)){        
            nombrepieza = tablero.getCasillas()[iterX][iterY].getPieza().getNombrePieza();
            if(tablero.getCasillas()[iterX][iterY].getPieza().getEquipo() == equipo ){
                estado = false;
            }
            posicionesPosibles[iterX][iterY] = estado;
            if(!"NoPieza".equals(nombrepieza)){
                estado = false;
            }
            iterX-=1;
            iterY-=1;
        }
        
        estado=true;
        iterX = x-1;
        iterY = y+1;
        while((iterX>=0) && (iterY<=7)){
            nombrepieza = tablero.getCasillas()[iterX][iterY].getPieza().getNombrePieza();
            if(tablero.getCasillas()[iterX][iterY].getPieza().getEquipo() == equipo ){
                estado = false;
            }
            posicionesPosibles[iterX][iterY] = estado;
            if(!"NoPieza".equals(nombrepieza)){
                estado = false;
            }
            iterX-=1;
            iterY+=1;
        }
        estado=true;
        iterX = x+1;
        iterY = y-1;
        while((iterX<=7) && (iterY>=0)){
            nombrepieza = tablero.getCasillas()[iterX][iterY].getPieza().getNombrePieza();
            if(tablero.getCasillas()[iterX][iterY].getPieza().getEquipo() == equipo ){
                estado = false;
            }
            posicionesPosibles[iterX][iterY] = estado;
            if(!"NoPieza".equals(nombrepieza)){
                estado = false;
            }
            iterX+=1;
            iterY-=1;
        }
        estado=true;
        iterX = x+1;
        iterY = y+1;
        while((iterX<=7) && (iterY<=7)){
            nombrepieza = tablero.getCasillas()[iterX][iterY].getPieza().getNombrePieza();
            if(tablero.getCasillas()[iterX][iterY].getPieza().getEquipo() == equipo ){
                estado = false;
            }
            posicionesPosibles[iterX][iterY] = estado;
            if(!"NoPieza".equals(nombrepieza)){
                estado = false;
            }
            iterX+=1;
            iterY+=1;
        }
        return posicionesPosibles;
    }
    
    
    
    
    @Override
    public boolean validarMovimiento(Posicion posicionInicial,Posicion posicionNueva, Tablero tablero){
        PosInicialX=posicionInicial.getX();
        PosInicialY=posicionInicial.getY();
        PosFinalX = posicionNueva.getX();
        PosFinalY = posicionNueva.getY();
            
        return posicionesPosibles(PosInicialX,PosInicialY,tablero)[PosFinalX][PosFinalY] != false;
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

    @Override
    public int getValorPieza() {
        return valorPieza;
    }


}

