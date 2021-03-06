package Controladores;

import Modelos.Alfil;
import Modelos.Caballo;
import Modelos.NoPieza;
import Modelos.Peon;
import Modelos.Pieza;
import Modelos.Posicion;
import Modelos.Reina;
import Modelos.Rey;
import Modelos.Tablero;
import Modelos.Torre;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joaquin
 */
public class ControladorTablero {
    
    public static Posicion casillaInicio;
    public static Posicion casillaFin;
    public static Pieza piezaContenida=null;
    public static boolean estadoInicio=false;
    public static boolean estadoFinal=false;
    public boolean esMisma=false;
    //
    public static ArrayList<Posicion> movimientos; //Movimientos a Ralizar
    public ArrayList<Posicion> movimientosPosibles;
    
    //private static ControladorTablero INSTANCE;
    
    public ControladorTablero(){
    }
    
//    public static ControladorTablero getInstance(){
//        if(INSTANCE==null){
//            INSTANCE = new ControladorTablero();
//        }
//        return INSTANCE;
//    }
    
    
    public Pieza crearPieza(int x,int y,String nombrePieza,char equipo){
        Posicion pos = new Posicion();
        pos.setPosicion(x, y);
        Pieza pieza;
        if( null == nombrePieza){
            NoPieza nopieza= new NoPieza();
            pieza  = nopieza;
  
        }
        else switch (nombrePieza) {
            case "Alfil":
                Alfil alfil = new Alfil();
                //alfil.setEquipo(equipo);
                pieza  = alfil;
                break;
            case "Caballo":
                Caballo caballo = new Caballo();
                pieza  = caballo;
                break;
            case "Peon":
                Peon peon = new Peon();
                pieza  = peon;
                break;
            case "Reina":
                Reina reina = new Reina();
                pieza  = reina;
                break;
            case "Torre":
                Torre torre = new Torre();
                pieza  = torre;
                break;
            case "Rey":
                Rey rey = new Rey();
                pieza  = rey;
                break;
            default:
                NoPieza nopieza= new NoPieza();
                pieza  = nopieza;
                break;
        }
        pieza.setEquipo(equipo);
        pieza.setPosicion(pos);
        return pieza;
    }
    
    public void moverPieza(Pieza pieza,Tablero tablero){
        String nombrePieza = pieza.getNombrePieza();
        //System.out.println("Nombre de la Pieza: "+nombrePieza);
        if(estadoInicio==false){
            estadoFinal=false;
            casillaInicio=pieza.getPosicion(); 
            if("NoPieza".equals(nombrePieza)){
                JOptionPane.showMessageDialog(null, "Casilla en blanco", "Validar Movimiento"
                        , JOptionPane.WARNING_MESSAGE);
            }
            else{
                estadoInicio=true;
                piezaContenida=pieza;
            }
        }
        else{
            casillaFin=pieza.getPosicion();
            if(casillaInicio.getX() != casillaFin.getX() || 
                casillaInicio.getY() != casillaFin.getY()){
                esMisma = false;
                if(piezaContenida.validarMovimiento(casillaInicio,casillaFin, tablero)){
                    estadoInicio=false;
                    movimientos = piezaContenida.casillasIntermedias(casillaInicio, casillaFin);
                    estadoFinal=true;

                }
                else{
                    JOptionPane.showMessageDialog(null, "Movimiento Invalido", "Validar Movimiento"
                    , JOptionPane.WARNING_MESSAGE);
                    estadoInicio=false;
                }
            }
            else{
                esMisma = true;
                estadoInicio=false;
                estadoFinal = true;
            }
        }
    }
    
    public ArrayList<Posicion> movimientosPosibles(Pieza pieza,Tablero tablero){
        //boolean [][] posicionesPosibles = new boolean [8][8];
        boolean [][] posicionesPosibles;
        casillaInicio=pieza.getPosicion();
        if(estadoInicio){   
            posicionesPosibles = pieza.posicionesPosibles(casillaInicio.getX(), casillaInicio.getY(),tablero);
            movimientosPosibles = new ArrayList<>();
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    Posicion posCambiante = new Posicion();
                    if(posicionesPosibles[i][j]){
                        //System.out.println("("+i+","+j+")");
                        posCambiante.setX(i);
                        posCambiante.setY(j);
                        movimientosPosibles.add(posCambiante);
                    }
                }
            }
        }
         return movimientosPosibles;  
    }
    
    
    public ArrayList<Posicion> getMovimientos(){
        return movimientos;
    }
    
    
    public boolean getEstadoFinal(){
        return estadoFinal;
    }
    
    public void setEstadoInicio(){
        estadoInicio = true;
    }
    
    public void restablecerEstadoInicio(){
        estadoInicio = false;
    }
    
    public boolean esMisma(){
        return esMisma;
    }
    
    public Pieza getPiezaContenida(){
        return piezaContenida;
    }
    
    public void imprimirTablero(Tablero tablero){
        char caracter;
        char equipo;
        System.out.println("--------------------------");
        for(int i=0;i<8;i++){
            System.out.println("\n");
            for(int j=0;j<8;j++){
                caracter = tablero.getCasillas()[i][j].getPieza().getCaracterPieza();
                equipo = tablero.getCasillas()[i][j].getPieza().getEquipo();
                if(caracter == 'N'){
                    System.out.print("| |");
                }
                else{
                    System.out.print("|"+caracter+equipo+"|");
                }
            }
        }
        System.out.println("\n");
    }
    
    public Tablero copiarTablero(Tablero tablero){
        Tablero copiaTablero = new Tablero();
        for(int i=0;i<8;i++){
            System.arraycopy(tablero.getCasillas()[i], 0, copiaTablero.getCasillas()[i], 0, 8);
        }
        return copiaTablero; 
    }   
}
