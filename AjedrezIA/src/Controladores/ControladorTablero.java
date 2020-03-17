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
    
    
    
    public static Pieza crearPieza(int x,int y,String nombrePieza,char equipo){
        Posicion pos = new Posicion();
        pos.setPosicion(x, y);
        Pieza pieza = null;
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
    
    public static void moverPieza(Pieza pieza,Tablero tablero){
        String nombrePieza = pieza.getNombrePieza();
        //System.out.println("Nombre Pieza: "+nombrePieza);
        if(estadoInicio==false){
            casillaInicio=pieza.getPosicion(); 
            if("NoPieza".equals(nombrePieza)){
                JOptionPane.showMessageDialog(null, "Casilla en blanco", "Validar Movimiento"
                        , JOptionPane.WARNING_MESSAGE);
            }
            else{
                estadoInicio=true;
                piezaContenida=pieza;
                System.out.println("Posicion inicial: "+casillaInicio.getX()+":"+casillaInicio.getY());
            }
        }
        else if (estadoInicio){
            casillaFin=pieza.getPosicion();
            System.out.println("Posicion final: "+casillaFin.getX()+":"+casillaFin.getY());
            if("NoPieza".equals(pieza.getNombrePieza())){
                //String piezaacumulada = piezaContenida.getNombrePieza();
                if(casillaInicio.getX() != casillaFin.getX() || 
                    casillaInicio.getY() != casillaFin.getY()){
                    if(piezaContenida.movimientoPosible(casillaInicio,casillaFin, tablero)){
                        System.out.println("Movimiento valido");
                        estadoInicio=false;
                        ArrayList<Posicion> movimientos = piezaContenida.casillasIntermedias(casillaInicio, casillaFin);
                        simularMovimiento(movimientos);
                        
                        
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Movimiento Invalido", "Validar Movimiento"
                        , JOptionPane.WARNING_MESSAGE);
                estadoInicio=false;
            }
//            if(casillaInicio.getX() != casillaFin.getX() || 
//                    casillaInicio.getY() != casillaFin.getY()){
//                System.out.println("Movimiento de Casillas");
//                if(piezaContenida.mover(casillaFin, tablero)){
//                    System.out.println("Movimiento Valido");
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Movimiento Inválido", 
//                            "Validar Movimienot", JOptionPane.ERROR_MESSAGE);
//                }
            
           // }

        }
    }
    
    public static void simularMovimiento(ArrayList<Posicion> movimientos){
        Posicion posTemporal = new Posicion();
        for(int i=0;i<movimientos.size();i++){
            posTemporal = movimientos.get(i);
            System.out.println("Movimiento: "+posTemporal.getX()+","+posTemporal.getY());           
        }
    }
    
}
