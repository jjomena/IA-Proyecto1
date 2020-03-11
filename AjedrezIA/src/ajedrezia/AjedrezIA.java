package ajedrezia;

import ajedrez.juego.ReadFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin
 */
public class AjedrezIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> comandos = new ArrayList<String>();
        ReadFile read = new ReadFile();
        try {
            comandos = read.readFile("/Users/kristalduran/Desktop/configuracion.txt");
        } catch (IOException ex) {
            Logger.getLogger(AjedrezIA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO code application logic here
        TableroGUI tb = new TableroGUI();
        tb.agregarComponentes();
        tb.setVisible(true);
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
    
}
