package Controladores;

import Modelos.LeerArchivo;
import Vistas.TableroGUI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JFileChooser;

/**
 *
 * @author Joaquin
 */
public class ControladorInicio {
    
    public static void CargarArchivo(String Jugador,ArrayList<String> comandos){
        TableroGUI tb = new TableroGUI();
        tb.agregarComponentes();
        tb.setVisible(true);
        tb.desactivarFichas();
        tb.agregarJugador(Jugador);
        //
        for (String comando : comandos) {
            int row = 0;
            switch(comando.charAt(3)){
                case 'A':
                    row = 0;
                    break;
                case 'B':
                    row = 1;
                    break;
                case 'C':
                    row = 2;
                    break;
                case 'D':
                    row = 3;
                    break;
                case 'E':
                    row = 4;
                    break;
                case 'F':
                    row = 5;
                    break;
                case 'G':
                    row = 6;
                    break;
                case 'H':
                    row = 7;
                    break;
            }
            tb.addPieceFile(comando.charAt(0), comando.charAt(1), Integer.parseInt(comando.charAt(2)+""), row);
        }
    }
    
    public static void CargarManual(String Jugador){
        TableroGUI tb = new TableroGUI();
        tb.agregarComponentes();
        tb.setVisible(true);
        tb.activarFichas();
        tb.agregarJugador(Jugador);
    }
    
}