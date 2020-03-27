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
public class Alfil extends Pieza{
    int PosInicialX=0;
    int PosInicialY=0;
    //
    int PosFinalX=0;
    int PosFinalY=0;
    //
    int valorPieza=30;
    
    public Alfil(){
        super();
    }
    
    @Override
    public boolean[][] posicionesPosibles(int x,int y,Tablero tablero) {
        boolean [][] posicionesPosibles = new boolean [8][8];
        String nombrepieza;
        boolean estado=true;
        posicionesPosibles[x][y] = false;
        estado=true;
        char equipo = this.isEquipo();
        int iterX = x-1;
        int iterY = y-1;
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
            if(nombrepieza != "NoPieza"){
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
    public boolean validarMovimiento(Posicion posicionInicial,Posicion posicionNueva, Tablero tablero){
        PosInicialX=posicionInicial.getX();
        PosInicialY=posicionInicial.getY();
        PosFinalX= posicionNueva.getX();
        PosFinalY= posicionNueva.getY();
          
       if(posicionesPosibles(PosInicialX,PosInicialY,tablero)[PosFinalX][PosFinalY]== false)
           return false;
       
       else
           if (piezasDelMismoEquipo(tablero)[PosFinalX][PosFinalY])
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
        PosInicialX=posicionInicial.getX();
        PosInicialY=posicionInicial.getY();
        PosFinalX= posicionNueva.getX();
        PosFinalY= posicionNueva.getY();
        ArrayList<Posicion> intermedias = new ArrayList<>();
        
        if(PosFinalX<PosInicialX && PosFinalY<PosInicialY){
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
        return 'A';
    }

    @Override
    public int getValorPieza() {
        return valorPieza;
    }

}
               
                
       
          
           
           
           
           
           
           
           
           
           
           
