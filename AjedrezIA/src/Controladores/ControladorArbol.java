   package Controladores;

import Modelos.Arbol;
import Modelos.Jugada;
import Modelos.MinMax;
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
    public ControladorTablero ctrTablero;
    public ArrayList<Posicion> movimientosPosibles;
    public char equipoEnJuego;
    public Posicion posicionGenerada;
    public Jugada movimientoPieza=null;
    public int maximoNivel=2;
    
    public ControladorArbol(){
    }
    
    public void crearArbol(Tablero tablero){
        
        arbol = new Arbol(tablero);
        ctrTablero = ControladorTablero.getInstance();
    }
    public Nodo getNodoRaiz(){
        return arbol.getRaiz();
    }
    
    public void calcularMovimientos(Tablero tablero,char equipo,Nodo padre){
        char equipoPieza;
        Pieza pieza;
        ctrTablero.setEstadoInicio();
        //System.out.println("ESTADO INICIAL");
        //ctrTablero.imprimirTablero(tablero);
        String nombre;
        ArrayList<Jugada> jugadas = new ArrayList<>();
        equipoEnJuego = equipo;
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                pieza = tablero.getCasillas()[i][j].getPieza();
                nombre = pieza.getNombrePieza();
                equipoPieza = pieza.getEquipo();
                if(!"NoPieza".equals(nombre)){
                    if(equipoPieza == equipo){
                        //System.out.println("Nombre Pieza: "+pieza.getNombrePieza());
                        movimientosPosibles = ctrTablero.movimientosPosibles(pieza, tablero);
                        //activarPosiblesJugadas();
                        Jugada jugada = new Jugada(pieza,movimientosPosibles,tablero);
                        jugadas.add(jugada);
                    }
                }
            }
        }
        ctrTablero.restablecerEstadoInicio();
        verPosiblesJugadas(padre,jugadas,equipo);   
        jugadas.clear();
        //generarRandom();
    }
    
    public void verPosiblesJugadas(Nodo padre,ArrayList<Jugada> jugadas,char equipo){
        int posX;
        int posY;
        //Jugada movimientoPieza;
        Tablero tableroJuego = null;
        Pieza pieza = null;
        int nivel;
        ArrayList<Posicion> movimientos = null;
        //System.out.println("Cantidad de Jugadas: "+jugadas.size());
        for(int j=0;j<jugadas.size();j++){
            movimientoPieza = jugadas.get(j);
            pieza = movimientoPieza.getPieza();
            movimientos = movimientoPieza.getMovimientos();
            tableroJuego = movimientoPieza.getTabblero();
            nivel = padre.getNivel();
            //System.out.println("Nivel padre: "+nivel);
            //System.out.println("TABLERO ANTES DEL MOVIMIENTO");
            //ctrTablero.imprimirTablero(tableroJuego);
            
            posX = pieza.getPosicion().getX();
            posY = pieza.getPosicion().getY();
            //
            int camposX=0;
            int camposY=0;
                    
            for(int i=0;i<movimientos.size();i++){
                //System.out.println("Movimiento de Pieza: "+pieza.getNombrePieza()+" Color: "+pieza.getEquipo());
                generarNodosHijos(tableroJuego,posX,posY,pieza,movimientos.get(i),padre,equipo);
                camposX = movimientos.get(i).getX();
                camposY = movimientos.get(i).getY();
                tableroJuego.getCasillas()[camposX][camposY]
                        .setPieza(ctrTablero.crearPieza(camposX,camposY,"NoPieza",'X'));
                tableroJuego.getCasillas()[posX][posY]
                    .setPieza(ctrTablero.crearPieza(posX,posY,pieza.getNombrePieza(),pieza.getEquipo()));
            }
            //System.out.println("TABLERO REVERSADO DEL MOVIMIENTO");
            //ctrTablero.imprimirTablero(tableroJuego);
            //System.out.println("------------------------------");
            //System.out.println("-------FIN DE PIEZA------: "+pieza.getNombrePieza()+":"+pieza.getEquipo()+"\n");
            //System.out.println("Cambio de pieza");
        }
    }
    
    public void activarPosiblesJugadas(){
        Posicion mover = new Posicion();
        int movX;
        int movY;
        int size;
        //System.out.println("Movimientos posibles: "+movimientosPosibles.size());
        for(int i=0;i < movimientosPosibles.size();i++){
            mover = movimientosPosibles.get(i);
            movX = mover.getX();
            movY = mover.getY();
            System.out.print("("+movX+","+movY+")"+",");
        }
        System.out.println("\n");
    }
    
    public void generarNodosHijos(Tablero tab,int posX,int posY,Pieza pieza,Posicion mover,Nodo padre,char equipo){
        int movX;
        int movY;
        Posicion posInicial = new Posicion();
        posInicial.setX(posX);
        posInicial.setY(posY);
        boolean isMax;
        movX = mover.getX();
        movY = mover.getY();
        tab.getCasillas()[posX][posY]
                .setPieza(ctrTablero.crearPieza(posX,posY,"NoPieza",'X'));
        tab.getCasillas()[movX][movY]
                    .setPieza(ctrTablero.crearPieza(movX,movY,pieza.getNombrePieza(),pieza.getEquipo()));
        int profundidad = padre.getNivel();
        profundidad+=1;
        Nodo nodoHijo = new Nodo(tab);
        nodoHijo.setNivel(profundidad);
        nodoHijo.setNodoPadre(padre);
        padre.agregarNodoHijo(nodoHijo);
        nodoHijo.setIsMax(!padre.isMax());
        nodoHijo.setPieza(pieza);
        nodoHijo.setPosInicial(posInicial);
        nodoHijo.setPosFinal(mover);
        //System.out.println("TABLERO DESPUES DEL MOVIMIENTO");
        //ctrTablero.imprimirTablero(tab); 
        if(profundidad <= maximoNivel){
            if(equipo == 'B'){
                equipo = 'N';
            }
            else if(equipo == 'N'){
                equipo = 'B';
            }
            
            calcularMovimientos(tab,equipo,nodoHijo);
        }
        else{
            //System.out.println("Fin de la rama");
            //System.out.println("EQUIPO EN JUEGO "+equipoEnJuego);
            calcularFuncionEvaluacion(nodoHijo,equipo);
        }
    }
    
    
//    public Tablero copiarTablero(Tablero tablero){
//        Tablero copiaTablero = new Tablero();
//        for(int i=0;i<8;i++){
//            for(int j=0;j<8;j++){
//                copiaTablero.getCasillas()[i][j] = tablero.getCasillas()[i][j];
//            }
//        }
//        return copiaTablero; 
//    }
    
//    public void generarRandom(){
//        int cantPiezas = jugadas.size();
//        int piezaJugar;
//        ArrayList<Posicion> movimientos = null;
//        int jugadaRealizar;
//        int cantMovimientos;
//        
//        piezaJugar = (int) Math.floor(Math.random()*cantPiezas);
//        System.out.println("ValorRandom: "+piezaJugar);
//        movimientoPieza = jugadas.get(piezaJugar);
//        movimientos = movimientoPieza.getMovimientos();
//        
//        cantMovimientos = movimientos.size();
//        jugadaRealizar = (int) Math.floor(Math.random()*cantMovimientos);
//        posicionGenerada = movimientos.get(jugadaRealizar);
//    }
    
    public Posicion getPosicionGenerada(){
        return posicionGenerada; 
    }
    
    public Jugada getJugadaGenerada(){
        return movimientoPieza;
    }
    
    public void calcularFuncionEvaluacion(Nodo nodo,char equipoEnJuego){
        char equipoPieza;
        Pieza pieza;
        String nombre;
        Tablero tableroCalcula;
        tableroCalcula = nodo.getTablero();
        int valorPieza;
        int ptsFavor=0;
        int ptsContra=0;
        int valorFuncion=0;
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                pieza = tableroCalcula.getCasillas()[i][j].getPieza();
                nombre = pieza.getNombrePieza();
                equipoPieza = pieza.getEquipo();
                if(!"NoPieza".equals(nombre)){
                    valorPieza = pieza.getValorPieza();
                    if(equipoEnJuego == equipoPieza){
                        ptsFavor = ptsFavor + valorPieza;
                    }
                    else{
                        ptsContra = ptsContra + valorPieza;
                    }
                }
            }
        }
        //ctrTablero.imprimirTablero(tableroCalcula); 
        valorFuncion = ptsFavor - ptsContra;
        nodo.setValor(valorFuncion);
        //System.out.println("Funcion Evaluacion: "+valorFuncion);
    }
    
    public Nodo ejecutarMovimiento(){
        int valorCalculado;
        int valorHijo;
        Nodo raiz = getNodoRaiz();
        MinMax minmax = new MinMax(raiz,3);
        valorCalculado = minmax.calculoMinMax();
        ArrayList<Nodo> nodosHijos;
        nodosHijos = raiz.getNodosHijos();
        Nodo movRealizar = null;
        for(int i=0;i<nodosHijos.size();i++){
            movRealizar = nodosHijos.get(i);
            valorHijo = movRealizar.getValor();
            if(valorHijo == valorCalculado){
                break;
            }
        }
        return movRealizar;
    }
    
    public void imprimirArbol(Nodo padre,int nivel){
        int valor = padre.getValor();
        System.out.println("Valor Nodo: "+valor+" nivel: "+nivel);
        ArrayList<Nodo> nodosHijos = padre.getNodosHijos();
        nivel += 1;
        for(int i=0;i<nodosHijos.size();i++){
            imprimirArbol(nodosHijos.get(i),nivel);
        }
    }
}
