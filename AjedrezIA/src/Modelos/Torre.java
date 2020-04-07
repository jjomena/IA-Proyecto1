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
    int PosInicialX=0;
    int PosInicialY=0;
    //
    int PosFinalX=0;
    int PosFinalY=0;
    //
    int valorPieza=50;

    @Override
     public boolean[][] posicionesPosibles(int x,int y,Tablero tablero) {
        boolean [][] posicionesPosibles = new boolean [8][8];
        String nombrepieza;
        boolean estado;
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
        return posicionesPosibles;
    }
    
    
//    private boolean casillasIntermediasVacias(Posicion posicionNueva, Tablero tablero) {
//           int x1 = getPosicion().getX();
//           int y1 = getPosicion().getY();
//           int x2 = posicionNueva.getX();
//           int y2 = posicionNueva.getY();
//           int minX = Math.min(x1, x2);
//           int maxX = Math.max(x1, x2);
//           int minY = Math.min(y1,y2);
//           int maxY = Math.max(y1,y2);
//           
//           if(x1 == x2)
//               for(int i = minY + 1; i< maxY; i++)
//                   if(tablero.getCasillas()[x1][i].getPieza() instanceof NoPieza == false)
//                       return false;
//                  
//           if(y1 == y2)
//               for(int i = minX + 1; i< maxX; i++)
//                   if(tablero.getCasillas()[i][y1].getPieza() instanceof NoPieza == false)
//                       return false;
//                   
//           return true;
//                   
//    }
    
    
    
    @Override
    public boolean validarMovimiento(Posicion posicionInicial,Posicion posicionNueva, Tablero tablero){
          PosInicialX=posicionInicial.getX();
          PosInicialY=posicionInicial.getY();
          PosFinalX = posicionNueva.getX();
          PosFinalY = posicionNueva.getY();
//       else
//           if (piezasDelMismoEquipo(tablero)[PosFinalX][PosFinalY])
//                return false;
//           else
//              if (casillasIntermediasVacias(posicionNueva, tablero) == false)
//                  return false;

           
        return posicionesPosibles(PosInicialX,PosInicialY,tablero)[PosFinalX][PosFinalY] != false;
    }

    @Override
    public String getNombrePieza() {
        return "Torre";
    }

    @Override
    public ArrayList<Posicion> casillasIntermedias(Posicion posicionInicial, Posicion posicionNueva) {
        PosInicialX=posicionInicial.getX();
        PosInicialY=posicionInicial.getY();
        PosFinalX= posicionNueva.getX();
        PosFinalY= posicionNueva.getY();
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
        return intermedias;
    }  

    @Override
    public char getCaracterPieza() {
        return 'T';
    }

    @Override
    public int getValorPieza() {
        return valorPieza;
    }
}
