package Controladores;

import Modelos.Arbol;
import Modelos.Jugada;
import Modelos.Nodo;
import Modelos.Pieza;
import Modelos.Posicion;
import Modelos.Tablero;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Joaquin
 */
public class ControladorArbol {
    public Arbol arbol=null;
    public ControladorTablero ctrTablero = new ControladorTablero();
    public ArrayList<Posicion> movimientosPosibles;
    public ArrayList<Jugada> jugadas;
    public int profundidad = 2;
    public int nivelActual = 1;
    public char equipoEnJuego;
    public Posicion posicionGenerada;
    public Jugada movimientoPieza;
    public int maximoNivel=2;
    
    public ControladorArbol(){
    }
    
//    public void crearArbol(){
//        
//        arbol = new Arbol();
//    }
//    
//    public void agregarNodoRaiz(Tablero tablero){
//        arbol.setRaiz(tablero);
//    }
//    
//    public Nodo getNodoRaiz(){
//        return arbol.getRaiz();
//    }
    
    public void calcularMovimientos(Tablero tablero,char equipo,Nodo padre){
        char equipoPieza;
        Pieza pieza;
        ctrTablero.setEstadoInicio();
        ctrTablero.imprimirTablero(tablero);
        String nombre;
        jugadas = new ArrayList<Jugada>();
        equipoEnJuego = equipo;
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                pieza = tablero.getCasillas()[i][j].getPieza();
                nombre = pieza.getNombrePieza();
                equipoPieza = pieza.getEquipo();
                if("NoPieza" != nombre){
                    if(equipoPieza == equipo){
                        System.out.println("Nombre Pieza: "+pieza.getNombrePieza());
                        movimientosPosibles = ctrTablero.movimientosPosibles(pieza, tablero);
                        Jugada jugada = new Jugada(pieza,movimientosPosibles,tablero);
                        jugadas.add(jugada);
                    }
                }
            }
        }
        verPosiblesJugadas(padre);    
        //generarRandom();
    }
    
    public void verPosiblesJugadas(Nodo padre){
        int posX;
        int posY;
        Jugada movimientoPieza;
        Tablero tableroJuego = null;
        Pieza pieza = null;
        ArrayList<Posicion> movimientos = null;
        for(int j=0;j<jugadas.size();j++){
            movimientoPieza = jugadas.get(j);
            pieza = movimientoPieza.getPieza();
            movimientos = movimientoPieza.getMovimientos();
            tableroJuego = movimientoPieza.getTabblero();
            
            posX = pieza.getPosicion().getX();
            posY = pieza.getPosicion().getY();
            //
            for(int i=0;i<movimientos.size();i++){
                generarNodosHijos(tableroJuego,posX,posY,pieza,movimientos.get(i),padre);
                posX = movimientos.get(i).getX();
                posY =  movimientos.get(i).getY();
            }
            tableroJuego.getCasillas()[posX][posY]
                .setPieza(ctrTablero.crearPieza(posX,posY,"NoPieza",'X'));
            posX = pieza.getPosicion().getX();
            posY = pieza.getPosicion().getY();
            tableroJuego.getCasillas()[posX][posY]
                    .setPieza(ctrTablero.crearPieza(posX,posY,pieza.getNombrePieza(),pieza.getEquipo()));
            System.out.println("-------FIN DE PIEZA--------\n");
        }
    }
    
    public void activarPosiblesJugadas(){
        Posicion mover = new Posicion();
        int movX;
        int movY;
        int size;
        System.out.println("Movimientos posibles: "+movimientosPosibles.size());
        for(int i=0;i < movimientosPosibles.size();i++){
            mover = movimientosPosibles.get(i);
            movX = mover.getX();
            movY = mover.getY();
            System.out.print("("+movX+","+movY+")"+",");
        }
        System.out.println("\n");
    }
    
    public void generarNodosHijos(Tablero tab,int posX,int posY,Pieza pieza,Posicion mover,Nodo padre){
        int movX;
        int movY;
        movX = mover.getX();
        movY = mover.getY();
        tab.getCasillas()[posX][posY]
                .setPieza(ctrTablero.crearPieza(posX,posY,"NoPieza",'X'));
        tab.getCasillas()[movX][movY]
                    .setPieza(ctrTablero.crearPieza(movX,movY,pieza.getNombrePieza(),pieza.getEquipo()));
        ctrTablero.imprimirTablero(tab);
        int profundidad = padre.getNivel();
        profundidad+=1;
        Nodo nodoHijo = new Nodo(tab);
        nodoHijo.setNivel(profundidad);
        nodoHijo.setNodoPadre(padre);
        padre.agregarNodoHijo(nodoHijo);
        nodoHijo.setIsMax(!padre.isMax());
        if(profundidad < maximoNivel){
            if(equipoEnJuego == 'B'){
                equipoEnJuego = 'N';
            }
            else{
                equipoEnJuego = 'B';
            }
            calcularMovimientos(tab,equipoEnJuego,nodoHijo);
        }
    }
    
    
    public Tablero copiarTablero(Tablero tablero){
        Tablero copiaTablero = new Tablero();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                copiaTablero.getCasillas()[i][j] = tablero.getCasillas()[i][j];
            }
        }
        return copiaTablero; 
    }
    
    public void generarRandom(){
        int cantPiezas = jugadas.size();
        int piezaJugar;
        ArrayList<Posicion> movimientos = null;
        int jugadaRealizar;
        int cantMovimientos;
        
        piezaJugar = (int) Math.floor(Math.random()*cantPiezas);
        System.out.println("ValorRandom: "+piezaJugar);
        movimientoPieza = jugadas.get(piezaJugar);
        movimientos = movimientoPieza.getMovimientos();
        
        cantMovimientos = movimientos.size();
        jugadaRealizar = (int) Math.floor(Math.random()*cantMovimientos);
        posicionGenerada = movimientos.get(jugadaRealizar);
    }
    
    public Posicion getPosicionGenerada(){
        return posicionGenerada; 
    }
    
    public Jugada getJugadaGenerada(){
        return movimientoPieza;
    }
}
